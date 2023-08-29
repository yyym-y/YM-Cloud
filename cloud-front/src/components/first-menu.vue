<template>
    <div class="area">
        <div class="top" @click="OpenSecondMenu">
            <img class="img1" :src="nowPic" ref="iimg">
            <div class="name">{{ name }}</div>
            <img class="img2" src="@/assets/arrow.png" ref="arrr">           
        </div>
        <div class="bottom" v-if="ifOpen">
            <div v-for='pr in info' :key="pr.secondMenuKey" >
                <secondMenu 
                    :menukey="pr.secondMenuKey" @ifClick="clickNumMethod" :light="pr.ifLight">
                    {{ pr.name }}
                </secondMenu>
            </div>
        </div>
    </div>
</template>

<script>
import secondMenu from './second-menu.vue'
export default {
    components: {secondMenu},
    props : ['imgSrc', 'name', 'openImgSrc'],
    data() {
        return {
            info:[
                {"userKey": 1, "firstMenuKey": 1, "secondMenuKey": 1, "name": "ALL", "ifLight": false},
                {"userKey": 1, "firstMenuKey": 1, "secondMenuKey": 2, "name": "四级词汇", "ifLight": false},
                {"userKey": 1, "firstMenuKey": 1, "secondMenuKey": 3, "name": "六级词汇", "ifLight": false},
                {"userKey": 1, "firstMenuKey": 1, "secondMenuKey": 4, "name": "考研词汇", "ifLight": false}
            ],
            lastClick : -1,
            ifOpen : false,
            nowPic : ""
        }
    },
    methods: {
        clickNumMethod(keyValue) {
            if(this.lastClick != -1)
                this.info[this.lastClick - 1].ifLight = false
            this.lastClick = keyValue
            this.info[keyValue - 1].ifLight = true
        },
        flipArrow() {
            let ele = this.$refs.arrr
            if(this.ifOpen)
                ele.style.transform = "rotate(0deg)"
            else
                ele.style.transform = "rotate(-90deg)"
        },
        changeMenuImg() {
            if(this.ifOpen) this.nowPic = this.openImgSrc
            else this.nowPic = this.imgSrc
        },
        OpenSecondMenu() {
            this.ifOpen = ! this.ifOpen
            this.flipArrow()
            this.changeMenuImg()
        }
    },
    mounted() {
        this.nowPic = this.imgSrc
    }
}
</script>

<style scoped>
    *{
        user-select: none;
    }
    .top{
        width: 170px;
        height: 21px;
        margin-top: 15px;
        margin-left: 15px;
    }
    .img1{
        width: 21px;
        height: 21px;
        float: left;
        background-size: 100% 100%;
    }
    .name{
        width: 77.7px;
        height: 20.3px;
        display: flex;
        /* justify-content: center; */
        align-items: center;
        color: #A8A8AC;
        font-size: 14px;
        float: left;
        margin-left: 16px;
    }
    .bottom{
        margin-top: 10px;
    }
    .img2{
        width: 14px;
        height: 14px;
        float: right;
        background-size: 100% 100%;
        transform: rotate(-90deg);
        margin-top: 5.6px;
        margin-right: 7px;
    }
</style>