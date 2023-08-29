<template>
  <div>
    <div v-for="(pr, index) in info" :key="index">
        <!-- <firstMenu
            :imgSrc="require('../assets/' + pr.imgSrc)" :name="pr.name" :openImgSrc="require()">
        </firstMenu> -->
        {{ '../assets/' + pr.imgSrc }}
    </div>
    <firstMenu></firstMenu>
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
                    "imgSrc" : "ABC.png",
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