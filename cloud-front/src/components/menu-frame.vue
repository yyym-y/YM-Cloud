<template>
    <div>
        <Menu :firstMenuInfos="info.firstMenuInfos" :secondMenuInfos="info.secondInfos"
                @realClick="getClickMethod"></Menu>
    </div>
</template>

<script>
import Menu from '@/components/general/total-menu.vue'
export default {
    components : {
        Menu
    },
    data(){
        return {
            info : {
                "userKey" : 1,
                "firstMenuInfos" : [
                    {
                        "imgSrc" : require('@/assets/vocabulary/ABC.png'),
                        "openImgSrc" : require('@/assets/vocabulary/ABC-colored.png'),
                        "name" : "Vocabulary",
                        "firstMenuKey" : 1,
                        "ifHaveSecondMenu" : true,
                    },
                    {
                        "imgSrc" : require('@/assets/vocabulary/ABC.png'),
                        "openImgSrc" : require('@/assets/vocabulary/ABC-colored.png'),
                        "name" : "Vocabulary",
                        "firstMenuKey" : 2,
                        "ifHaveSecondMenu" : false,
                    },
                ],
                "secondInfos" : [
                    [
                        {"secondMenuKey": 1, "name": "ALL"},
                        {"secondMenuKey": 2, "name": "四级词汇"},
                        {"secondMenuKey": 3, "name": "六级词汇"},
                        {"secondMenuKey": 4, "name": "考研词汇"}                   
                    ],
                    []
                ]
            }   
            
        }
    },
    methods: {
        getClickMethod(value) {
            console.log(value)
        }
    }
}
</script>

<style>

</style>