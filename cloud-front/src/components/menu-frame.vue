<template>
    <div>
        <Menu :firstMenuInfos="firstMenuInfos" :secondMenuInfos="secondMenuInfos"
                @realClick="getClickMethod" v-if="flag"></Menu>
    </div>
</template>

<script>
import Menu from '@/components/general/total-menu.vue'
import Bus from '@/utils/bus.js'
import axios from 'axios'
export default {
    components : {
        Menu
    },
    data(){
        return {
            firstMenuInfos : [
                {
                    "imgSrc" : require('@/assets/vocabulary/ABC.png'),
                    "openImgSrc" : require('@/assets/vocabulary/ABC-colored.png'),
                    "name" : "Vocabulary",
                    "firstMenuKey" : 1,
                    "ifHaveSecondMenu" : true,
                },
                {
                    "imgSrc" : require('@/assets/cloud-img/cloud.png'),
                    "openImgSrc" : require('@/assets/cloud-img/cloud-colored.png'),
                    "name" : "Cloud-Img",
                    "firstMenuKey" : 2,
                    "ifHaveSecondMenu" : true,
                }
            ],
            secondMenuInfos : [[{"secondMenuKey": 1,"name": "ALL"}],[{"secondMenuKey": 1,"name": "ALL"}]],
            flag : false
        }
    },
    methods: {
        // EvenBus 广播点击的菜单信息
        getClickMethod(value) {
            // 广播一级菜单的名字
            Bus.$emit('getFirstMenuName', this.firstMenuInfos[value.father - 1].name)
            // 广播二级菜单的名字
            Bus.$emit('getSecondMenuName', this.secondMenuInfos[value.father - 1][value.son - 1].name)
        }
    },
    // 以下方法是在创建vue实例的时候将secondMenuInfos从后端请求回来
    async created() {
        await axios.get("https://yapi.pro/mock/44512/yyym/menu")
                   .then(result => {
                        this.secondMenuInfos = result.data.data.secondInfos
                        this.flag = true
                   })
    }
}
</script>

<style>

</style>