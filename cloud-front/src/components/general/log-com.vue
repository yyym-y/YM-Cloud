<template>
    <div>
        <div class="log-area3">
            <div class="log-area">
            <div class="decorate-square-2"></div>
            <div class="decorate-square-1"></div>
            <div class="decorate-square-3"></div>
            <div class="centre">
            <img class="left" src="@/assets/general/Log-img1.png" alt="">
            <div class="right">
                <div class="text">登录账号</div>
                <form class="userInfo" @submit.prevent>
                    <div class="Box">
                    <img class="userInfo-img-1" src="@/assets/general/person.png" alt="">
                    <input type="text" class="userName" placeholder="输入用户名" v-model="userPut.UID">
                    </div>
                    <div class="Box">
                    <img class="userInfo-img-2" src="@/assets/general/lock.png" alt="">
                    <input type="password" class="password" placeholder="请输入密码" v-model="userPut.password">
                    </div>
                    <a href="#" class="fogetPassword" @click="forget">忘记密码</a>
                    <input type="submit" class="submitUserInfo Box" value="登录" @click="log">
                </form>
                    <button class="Box New" @click="register">注册账号</button>
            </div>
            </div>
            <div class="decorate-square-5"></div>
            <div class="decorate-square-4"></div>
            <div class="decorate-square-6"></div>
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
            userPut : {
                UID : "",
                password : ""
            }
        }
    },
    methods : {
        register() {
            Bus.$emit("openRegister", true);
        },
        forget() {
            Bus.$emit("openForget", true);
        },
        log() {
            axios.post(this.head + '/LogIn/Check', this.userPut, this.config) 
                 .then((result) => {
                    if(result.data.code == 1) {
                        this.$message.success("登录成功")
                        this.$router.push('/Discovery')
                        return
                    }else {
                        this.$message.error("账号或密码错误")
                    }
                 })
        }
    }
}
</script>

<style scoped>
    body{
    background-color: #cbd8ff;
    width: 100%;
    height: 100%;
    }
    .log-area3 {
        z-index: 1;
    }
    *{
        margin: 0;
        border: 0;
        background-size: 100% 100%;
        user-select:none;
    }
    .log-area{
        width: 874px;
        height: 530px;
        background-color: #ededff;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
        box-shadow: 0 4px 4px 0 rgba(0, 0, 0, 0.25);
    }
    .centre{
        width: 690px;
        height: 400px;
        background-color: #ededff;
        margin: 0 auto;
        margin-top : 85px;
    }
    .left{
        width: 350px;
        height: 350px;
        margin: 0 auto;
        margin-top: 25px;
        float: left;
        /* background-image: url(../sample-img-1.png); */
        background-size: 100% 100%;
    }
    .right{
        background-color:  #ededff;
        height: 250px;
        width: 280px;
        float: right;
        margin-top: 75px;
    }
    .text{
        color: #456af3;
        font-size: 25px;
        font-weight: 900;
        margin: 10px;
    }
    .Box{
        display: block;
        height: 40px;
        width: 205px;
        border-radius: 40px;
        background-color: #ebedff;
        margin-top: 7px;
        border-width: 2px;
        border-color: #98abf9;
        border-style: solid;
    }
    input{
        background-color: rgba(0, 0, 0, 0);
        border: 0px;
        outline: none;
        height: 29px;
        width: 140px;
        float: right;
        margin-right: 17px;
        margin-top: 5px;
    }
    .submitUserInfo{
        float: none;
        border-color:#456af3;
        background-color: #456af3;
        font-size: 17px;
        color: white;
        font-weight: 500;
    }
    .fogetPassword{
        margin-left: 160px;
        font-size: 12px;
    }
    .userInfo-img-1, .userInfo-img-2{
        width: 30px;
        height: 30px;
        border: 0;
        margin-left: 10px;
        margin-top: 5px;
    }
    img:not([src]){opacity:0;}
    img{ -webkit-user-drag: none;}

    .New{
        background-color: white;
        text-align: center;
    }
    .decorate-square-1{
        width: 230px;
        height: 80px;
        background-color: #edb900;
        float: left;
        position: absolute;
    }
    .decorate-square-2{
        width: 320px;
        height: 35px;
        background-color: #c6ca00;
        float: left;
        position: absolute;
    }
    .decorate-square-3{
        width: 250px;
        height: 70px;
        background-color: #f6c0c8;
        float: right;
    }
    .decorate-square-4{
        width: 150px;
        height: 45px;
        background-color: #ef7654;
        float: right;
    }
    .decorate-square-5{
        width: 50px;
        height: 50px;
        background-color: rgba(198, 202, 0, 0.6);
        position: absolute;
        border-radius: 50%;
        transform: translate(-24px,-50px);
    }
    .decorate-square-6{
        width: 110px;
        height: 110px;
        background-color: rgba(242, 238, 232, 0.8);
        position: absolute;
        border-radius: 50%;
        transform: translate(450px,-10px);
    }
</style>
