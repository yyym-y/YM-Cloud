<template>
  <div>
    <div class="new-area">
        <div>
            <div class="text">注册账号</div>
            <div class="close" @click="cclose"></div>
            <form class="fform">
              <div class="sss"><div class="text2">user-name : </div>
                <input type="text" placeholder="输入用户名" v-model="info.userName"></div>
              <div class="sss"><div class="text2">E-mail : </div>
                <input type="email" placeholder="输入邮箱" v-model="info.email"></div>
              <div class="sss"><div class="text2">password : </div>
                <input type="password" placeholder="输入密码" v-model="info.password"></div>
              <div class="sss"><div class="text2">re-password : </div>
                <input type="password" placeholder="再次输入密码" v-model="checkPassword"></div>
              <input type="submit" class="sub" value="提交" @click="submitRegister">
            </form>
        </div>
    </div>
  </div>
</template>

<script>
import Bus from '@/utils/bus.js'
import axios from 'axios';
export default {
  inject : ['config', 'head'],
  data () {
    return {
      info : {
        userName : "",
        email : "",
        password : ""
      },
      checkPassword : "",
      info2 : {
        userName : "",
        email : "",
        password : "",
        code : ""
      }
    }
  },
  methods : {
     submitRegister() {
      if(this.checkPassword != this.info.password){
        this.noSame(); return
      }
      if(! this.checkuserName()) return;
      if(! this.checkPasswordF()) return;
      this.info2.userName = this.info.userName;
      this.info2.email = this.info.email;
      this.info2.password = this.info.password;
      axios.post(this.head + "/LogIn/Register", this.info, this.config)
      .then((result) => {
        if(result.data.code == 1) {
          this.inputCode(); return
        }
        if(result.data.msg == "UserName_Same_Error") {
          this.userNameUse(); return;
        }
        if(result.data.msg == "Email_Same_Error") {
          this.emailUse(); return;
        }
        if(result.data.msg == "Email_Form_Error") {
          this.emailFormError(); return;
        }
      })
    },
    cclose() {
      Bus.$emit("closeRegisterWindow", true);
    },
    noSame() {
        this.$message.error('两次输入的密码不一致');
    },
    userNameUse() {
      this.$message.error('用户名已被使用');
    },
    emailUse() {
      this.$message.error('邮箱名已被使用');
    },
    emailFormError() {
      this.$message.error('邮箱格式不支持');
    },
    codeWrongError() {
      this.$message.error('验证码错误');
    },
    success() {
      this.$message.success("注册成功")
    },
    checkuserName() {
      let name = this.info.userName;
      if(name.indexOf("<") != -1 || name.indexOf("@") != -1 || 
         name.indexOf(">") != -1 || name.indexOf(" ") != -1|| 
         name.indexOf("580") != -1 || name.indexOf(",") != -1) {
        this.$message.error("用户名不能包含 < >  @   ' ' '580' , ")
        return false
      }
      if(name.length <= 1 || name > 30) {
        this.$message.error("用户名长度应该在2~30之间")
        return false
      }
      return true
    },
    checkPasswordF() {
      let str = this.info.password;
      if(str.indexOf("<script>") != -1) {
        this.$message.error("哥们,别想注入")
        return false
      }
      if(str.length <= 7 || str.length > 30) {
        this.$message.error("密码长度应该在8~30之间")
        return false
      }
      return true
    },
    inputCode() {
        this.$prompt('请输入发送至邮箱的验证码', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputErrorMessage: '验证码不正确'
        }).then(({ value }) => {
          this.info2.code = value
          axios.post(this.head + "/LogIn/Register/Code", this.info2, this.config)
               .then((result) => {
                  if(result.data.code == 0) {
                    this.codeWrongError();
                    this.inputCode();
                    this.cclose();
                    return;
                  }
                  this.success();
               })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
      }
  }
}
</script>

<style scoped>
    .close {
      /* position: absolute; */
      width: 23px;
      height: 23px;
      float: right;
      transform: translate(-5px, -45px);
      background-image: url("@/assets/general/close.png");
      background-size: 100% 100%;
    }
    .new-area {
        width: 450px;
        height: 300px;
        background-color: white;
        z-index: 9999;
        position: absolute;
        transform: translate(-230px, -140px);
        border-radius: 5px;
        border-style: solid;
        border-color: gray;
        border-width: 1px;
        box-shadow: 1px 1px 1px 1px rgba(0,0,0,0.1);
    }
    .text {
      width: 230px;
      height: 40px;
      font-size: 25px;
      color : gray;
      font-weight: 500;
      margin-top: 10px;
      margin-left: 30px;
      border-bottom-width: 1px;
      border-bottom-color: red;
      border-bottom-style: solid;
    }
    .fform {
      width: 400px;
      height: 200px;
      margin-left: 40px;
      margin-top: 25px;
      font-size: 17px;
      font-weight: 100;
    }
    input {
      width: 200px;
      height: 25px;
    }
    .sss {
      margin-bottom: 15px;
    }
    .text2 {
      width: 120px;
      float: left;
    }
    .sub {
      width: 100px;
      height: 30px;
      background: white;
      float: right;
      margin-right: 180px;
      margin-top: 5px;
    }
</style>