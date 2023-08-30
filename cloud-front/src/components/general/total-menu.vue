<template>
  <div>
    <!-- {{ menuInfo }} -->
    <div v-for="(pr, index) in firstMenuInfos" :key="index">
        <firstMenu
            :firstMenuInfo="pr" :secondMenuInfos="secondMenuInfos[index]" @ClickSecondMenu="clickNumMethod"
            :ifCloseSon="ifCloseSon[index]" :ifClick="ifClick[index]">
        </firstMenu>
    </div>
  </div>
</template>

<script>
import firstMenu from '@/components/general/first-menu.vue'
export default {
    components : {
        firstMenu
    },
    props : ['firstMenuInfos', "secondMenuInfos"],
    data() {
        return {
            lastClick : {
                "father" : -1,
                "son" : -1,
                "static" : false
            },
            ifClick : [],
            ifCloseSon : []
        }
    },
    methods: {
        // 以下四个函数均是为了解决点击颜色错乱的情况
        open(num) {
            this.ifClick[num - 1] = true
            this.ifCloseSon[num - 1] = false
        },
        close(num) {
            this.ifClick[num - 1] = false
            this.ifCloseSon[num - 1] = true
        },
        init() {
            for(let i = 0 ; i < this.firstMenuInfos.length ; i ++){
                this.ifClick[i] = false
                this.ifCloseSon[i] = true
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
                this.$forceUpdate()
                return
            }
            if(this.lastClick.father == -1){
                this.open(clickInfo.father)
                this.lastClick = clickInfo
                this.$forceUpdate()
                return
            }
            if(this.lastClick.father != clickInfo.father && clickInfo.son == -1){
                this.$forceUpdate()
                return
            }
            this.close(this.lastClick.father)
            this.open(clickInfo.father)
            this.lastClick = clickInfo
            this.$forceUpdate()
        }
       
    },
    created() {
        for(let i = 0 ; i < this.firstMenuInfos.length ; i++){
            this.ifClick.push(false)
            this.ifCloseSon.push(true)
        }
    },
    // 监听lastClick, 向上层反馈点击情况，并自动过滤无用点击
    watch : {
        lastClick(newValue) {
            if(newValue.father != -1){
                if(! this.firstMenuInfos[newValue.father - 1].ifHaveSecondMenu){
                    this.$emit("realClick", newValue)
                }else{
                    if(newValue.son != -1)
                        this.$emit("realClick", newValue)
                }
            }
        }
    }
}
</script>

<style>

</style>