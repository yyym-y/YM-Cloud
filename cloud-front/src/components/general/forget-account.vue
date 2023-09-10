<template>
<div>
    <div class="fog-area">
        <div>
            <div class="text">注册账号</div>
            <div class="close" @click="cclose"></div>
            <form class="fformm">
              <div class="sss"><div class="text2">E-mail : </div>
                <input type="email" placeholder="输入邮箱" v-model="email"></div>
              <div class="sss"><div class="text2">password : </div>
                <input type="password" placeholder="输入新密码" v-model="password"></div>
              <div class="sss"><div class="text2">re-password : </div>
                <input type="password" placeholder="再次输入新密码" v-model="checkPassword"></div>
              <input type="submit" class="sub" value="提交" @click="submitForget">
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
  data() {
    return {
      email : "",
      password : "",
      checkPassword : ""
    }
  },
  methods : {
    submitForget() {
      if(this.password != this.checkPassword) {
        this.noSame(); return;
      }
      if(this.email == "") {
        this.$message.error('邮箱不能为空');
      }
      if(! this.checkPasswordF()) return;
      let parm = {
        "email" : this.email,
        "password" : this.password
      }
      axios.post(this.head + '/LogIn/Forget', parm, this.config)
           .then((result) => {
              if(result.data.code == 1) {
                this.inputCode(); return;
              }
              if(result.data.msg == "Email_No_Found_Error") {
                this.emailNoFind(); return;
              }
              if(result.data.msg == "Email_Form_Error") {
                this.emailFormError(); return;
              }
           })
    },
    cclose() {
      Bus.$emit("closeForgetWindow", true)
    },
    checkPasswordF() {
      let str = this.password;
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
    emailNoFind() {
      this.$message.error('该邮箱未被注册');
    },
    emailFormError() {
      this.$message.error('邮箱格式不支持');
    },
    noSame() {
        this.$message.error('两次输入的密码不一致');
    },
    success() {
      this.$message.success("修改密码成功")
    },
    inputCode() {
        this.$prompt('请输入发送至邮箱的验证码', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputErrorMessage: '验证码不正确'
        }).then(({ value }) => {
          let parm2 = {
            "email" : this.email,
            "password" : this.password,
            "code" : value
          }
          axios.post(this.head + "/LogIn/Forget/Code", parm2, this.config)
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
    .fog-area {
        width: 450px;
        height: 270px;
        background-color: white;
        z-index: 9999;
        position: absolute;
        transform: translate(-230px, -120px);
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
    .fformm {
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