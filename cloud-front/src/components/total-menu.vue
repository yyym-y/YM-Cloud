<template>
  <div>
    <div v-for="(pr, index) in info" :key="index">
        <firstMenu
            :imgSrc="pr.imgSrc" :name="pr.name" :openImgSrc="pr.openImgSrc"
            :userKey="pr.userKey" :firstMenuKey="pr.firstMenuKey" :ifClick="pr.ifClick"
            :ifCloseSon="pr.ifCloseSon" @ifClick="clickNumMethod">
        </firstMenu>
    </div>
  </div>
</template>

<script>
import firstMenu from './first-menu.vue'
export default {
    components : {
        firstMenu
    },
    data() {
        return {
            info : [
                {
                    "imgSrc" : require('@/assets/ABC.png'),
                    "name" : "Vocabulary",
                    "openImgSrc" : require('@/assets/ABC-colored.png'),
                    "userKey" : 1,
                    "firstMenuKey" : 1,
                    "ifClick" : false,
                    'ifCloseSon' : true
                },
                {
                    "imgSrc" : require('@/assets/ABC.png'),
                    "name" : "Vocabulary",
                    "openImgSrc" : require('@/assets/ABC-colored.png'),
                    "userKey" : 1,
                    "firstMenuKey" : 2,
                    "ifClick" : false,
                    'ifCloseSon' : true
                },
                {
                    "imgSrc" : require('@/assets/ABC.png'),
                    "name" : "Vocabulary",
                    "openImgSrc" : require('@/assets/ABC-colored.png'),
                    "userKey" : 1,
                    "firstMenuKey" : 3,
                    "ifClick" : false,
                    'ifCloseSon' : true
                }
            ],
            lastClick : {
                "father" : -1,
                "son" : -1,
                "static" : false
            }
        }
    },
    methods: {
        // 以下四个函数均是为了解决点击颜色错乱的情况
        open(num) {
            this.info[num - 1].ifClick = true
            this.info[num - 1].ifCloseSon = false
        },
        close(num) {
            this.info[num - 1].ifClick = false
            this.info[num - 1].ifCloseSon = true
        },
        init() {
            for(let i = 0 ; i < this.info.length ; i ++){
                this.info[i].ifClick = false
                this.info[i].ifCloseSon = false
            }
            this.lastClick = {
                "father" : -1,
                "son" : -1,
                "static" : false
            }
        },
        clickNumMethod(clickInfo) {
            if(!clickInfo.static){
                if(this.lastClick.father == clickInfo.father)
                    this.init()
                return
            }
            if(this.lastClick.father == -1){
                this.open(clickInfo.father)
                this.lastClick = clickInfo
                return
            }
            if(this.lastClick.father != clickInfo.father && clickInfo.son == -1){
                return
            }
            this.close(this.lastClick.father)
            this.open(clickInfo.father)
            console.log(this.lastClick.father)
            console.log(clickInfo.father)
            this.lastClick = clickInfo
        }
       
    }
}
</script>

<style>

</style>