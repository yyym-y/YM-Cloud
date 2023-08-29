<template>
  <div>
    <div v-for="(pr, index) in info" :key="index">
        <firstMenu
            :imgSrc="pr.imgSrc" :name="pr.name" :openImgSrc="pr.openImgSrc">
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
                    "firstMenuKey" : 1
                },
                {
                    "imgSrc" : require('@/assets/ABC.png'),
                    "name" : "Vocabulary",
                    "openImgSrc" : require('@/assets/ABC-colored.png'),
                    "userKey" : 1,
                    "firstMenuKey" : 1
                },
                {
                    "imgSrc" : require('@/assets/ABC.png'),
                    "name" : "Vocabulary",
                    "openImgSrc" : require('@/assets/ABC-colored.png'),
                    "userKey" : 1,
                    "firstMenuKey" : 1
                }
            ]
        }
    }
}
</script>

<style>

</style>