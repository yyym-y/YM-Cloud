<template>
    <div>
        <Menu :firstMenuInfos="firstMenuInfos" :secondMenuInfos="secondMenuInfos"
                @realClick="getClickMethod"></Menu>
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
            secondMenuInfos : [[{"secondMenuKey": 1,"name": "ALL"}],[{"secondMenuKey": 1,"name": "ALL"}]]
        }
    },
    methods: {
        getClickMethod(value) {
            Bus.$emit('getBarName', this.firstMenuInfos[value.father - 1].name)
        }
    },
    // 以下方法是在创建vue实例的时候将secondMenuInfos从后端请求回来
    async created() {
        await axios.get("https://yapi.pro/mock/44512/yyym/menu")
                   .then(result => {
                        this.secondMenuInfos = result.data.data.secondInfos
                   })
    }
}
</script>

<style>

</style>