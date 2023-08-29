<template>
  <div>
    <div v-for="(pr, index) in info" :key="index">
        <firstMenu
            :imgSrc="require('@/assets/ABC.png')" :name="pr.name" :openImgSrc="require('@/assets/ABC-colored.png')">
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
                    "imgSrc" : "@/assets/ABC.png",
                    "name" : "Vocabulary",
                    "openImgSrc" : "@/assets/ABC-colored",
                    "userKey" : 1,
                    "firstMenuKey" : 1
                },
                {
                    "imgSrc" : "@/assets/ABC.png",
                    "name" : "Vocabulary",
                    "openImgSrc" : "@/assets/ABC-colored",
                    "userKey" : 1,
                    "firstMenuKey" : 1
                },
                {
                    "imgSrc" : "@/assets/ABC.png",
                    "name" : "Vocabulary",
                    "openImgSrc" : "@/assets/ABC-colored",
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