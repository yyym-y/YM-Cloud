<template>
    <div class="area">
        <div class="top" @click="OpenSecondMenu">
            <img class="img1" :src="nowPic" ref="iimg">
            <div class="name" ref="name">{{ name }}</div>
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
    props : ['imgSrc', 'name', 'openImgSrc', 'userKey', 'firstMenuKey', 'ifClick', 'ifCloseSon'],
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
        // 当儿子被点击的时候执行的方法， 获取儿子的编号， 会返回父亲编号以及儿子编号
        clickNumMethod(keyValue) {
            if(this.lastClick != -1)
                this.info[this.lastClick - 1].ifLight = false
            this.lastClick = keyValue
            this.info[keyValue - 1].ifLight = true
            this.$emit("ifClick", {"father" : this.firstMenuKey, "son" : keyValue, "static" : this.ifOpen})
        },
        // 翻转箭头
        flipArrow() {
            let ele = this.$refs.arrr
            if(this.ifOpen)
                ele.style.transform = "rotate(0deg)"
            else
                ele.style.transform = "rotate(-90deg)"
        },
        // 修改标签的图片
        changeMenuImg() {
            if(this.ifOpen) this.nowPic = this.openImgSrc
            else this.nowPic = this.imgSrc
        },
        //打开二级菜单, 单击标题栏会返回父亲编号并且儿子编号为 -1
        OpenSecondMenu() {
            this.ifOpen = ! this.ifOpen
            this.flipArrow()
            this.changeMenuImg()
            this.$emit("ifClick", {"father" : this.firstMenuKey, "son" : -1, "static" : this.ifOpen})
        }
    },
    mounted() {
        this.nowPic = this.imgSrc
    },
    watch: {
        //监测ifClick， 如果为true， 就会高亮该标签
        ifClick(newValue){
            let ele = this.$refs.name
            if(newValue){
                ele.style.color = "#DB8850"
                ele.style.fontWeight = "700"
            }else{
                ele.style.color = "#A8A8AC"
                ele.style.fontWeight = "500"
            }
        },
        //监测ifCloseSon， 如果为true， 就把ifLight全部置为false， 即儿子全部熄灭
        ifCloseSon(newValue){
            if(newValue){
                for(let i = 0 ; i < this.info.length ; i++)
                    this.info[i].ifLight = false
            }
        }
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