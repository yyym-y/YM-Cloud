<template>
  <div>
    <div class="topArea">
      <bar>{{ name }}</bar>
      <userImg :userImg="userImg"></userImg>
    </div>
  </div>
</template>

<script>
import userImg from '@/components/general/user-img.vue'
import bar from '@/components/general/nevegation-bar.vue'
export default {
    props : ['name', 'userImg'],
    components : {
      userImg, bar
    }
}
</script>

<style scoped>
  .topArea{
    width: 800px;
    height: 60px;
    margin: 0 auto;
    margin-top: 25px;
    
  }
</style>