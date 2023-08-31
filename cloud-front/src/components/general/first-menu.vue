<template>
    <div class="area">
        <!-- {{ menuInfo.secondInfo }} -->
        <div class="top" @click="OpenSecondMenu">
            <img class="img1" :src="nowPic" ref="iimg">
            <div class="name" ref="name">{{ firstMenuInfo.name }}</div>
            <img class="img2" src="@/assets/general/arrow.png" ref="arrr" v-if="firstMenuInfo.ifHaveSecondMenu">    
        </div>
        <div class="bottom" v-if="ifOpen && firstMenuInfo.ifHaveSecondMenu">
            <div v-for='(pr, index) in secondMenuInfos' :key="pr.secondMenuKey" >
                <secondMenu
                    :menukey="pr.secondMenuKey" @ifClick="clickNumMethod" :light="ifLight[index]">
                    {{ pr.name }}
                </secondMenu>
            </div>
        </div>
    </div>
</template>

<script>
import secondMenu from '@/components/general/second-menu.vue'
export default {
    components: {secondMenu},
    props : ['firstMenuInfo', 'secondMenuInfos', 'ifClick', 'ifCloseSon'],
    data() {
        return {
            lastClick : -1,
            ifOpen : false,
            nowPic : "",
            ifLight : []
        }
    },
    methods: {
        // 当儿子被点击的时候执行的方法， 获取儿子的编号， 会返回父亲编号以及儿子编号
        clickNumMethod(keyValue) {
            if(this.lastClick != -1)
                this.ifLight[this.lastClick - 1] = false
            this.lastClick = keyValue
            this.ifLight[keyValue - 1] = true
            this.$emit("ClickSecondMenu", {
                "father" : this.firstMenuInfo.firstMenuKey, "son" : keyValue, "static" : this.ifOpen
            })
            this.$forceUpdate()
        },
        // 翻转箭头
        flipArrow() {
            // if(! this.firstMenuInfo.ifHaveSecondMenu){
            //     return
            // }
            let ele = this.$refs.arrr
            if(this.ifOpen)
                ele.style.transform = "rotate(0deg)"
            else
                ele.style.transform = "rotate(-90deg)"
        },
        // 修改标签的图片
        changeMenuImg() {
            if(this.ifOpen) this.nowPic = this.firstMenuInfo.openImgSrc
            else this.nowPic = this.firstMenuInfo.imgSrc
        },
        //打开二级菜单, 单击标题栏会返回父亲编号并且儿子编号为 -1
        OpenSecondMenu() {
            this.ifOpen = ! this.ifOpen
            this.flipArrow()
            this.changeMenuImg()
            this.$emit("ClickSecondMenu", {
                "father" : this.firstMenuInfo.firstMenuKey, "son" : -1, "static" : this.ifOpen
            })
        }
    },
    created() {
        this.nowPic = this.firstMenuInfo.imgSrc
        console.log(this.secondMenuInfos)
        // if(typeof(this.secondMenuInfos) == "undefined")
        //     return        
        for(let i = 0 ; i < this.secondMenuInfos.length ; i++)
            this.ifLight.push(false)
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
            if(typeof(this.secondMenuInfos) == "undefined")
                return
            if(newValue){
                for(let i = 0 ; i < this.secondMenuInfos.length ; i++)
                    this.ifLight[i] = false
                this.$forceUpdate()
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