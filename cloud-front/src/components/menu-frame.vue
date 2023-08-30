<template>
    <div>
        <Menu :firstMenuInfos="firstMenuInfos" :secondMenuInfos="secondMenuInfos"
                @realClick="getClickMethod"></Menu>
    </div>
</template>

<script>
import Menu from '@/components/general/total-menu.vue'
import Bus from '@/utils/bus.js'
import {getSecondMenuInfos} from '@/utils/communicate.js'
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
            secondMenuInfos : []
        }
    },
    methods: {
        getClickMethod(value) {
            Bus.$emit('getBarName', this.firstMenuInfos[value.father - 1].name)
        }
    },
    async mounted() {
        console.log(getSecondMenuInfos(1))
        await axios.get("https://yapi.pro/mock/44512/yyym/menu")
             .then(result =>{
                this.secondMenuInfos = result.data.data
             })
        // this.secondMenuInfos = [
        //     [
        //         {
        //             "secondMenuKey": 1,
        //             "name": "ALL"
        //         },
        //         {
        //             "secondMenuKey": 2,
        //             "name": "四级词汇"
        //         },
        //         {
        //             "secondMenuKey": 3,
        //             "name": "六级词汇"
        //         },
        //         {
        //             "secondMenuKey": 4,
        //             "name": "考研词汇"
        //         }
        //     ],
        //     [
        //         {
        //             "secondMenuKey": 1,
        //             "name": "图床1"
        //         },
        //         {
        //             "secondMenuKey": 2,
        //             "name": "图床2"
        //         },
        //         {
        //             "secondMenuKey": 3,
        //             "name": "图床3"
        //         },
        //         {
        //             "secondMenuKey": 4,
        //             "name": "图床4"
        //         }
        //     ]
        // ]
    }
}
</script>

<style>

</style>