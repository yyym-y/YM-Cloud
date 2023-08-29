<template>
  <div class="area">
    <!-- <first-menu 
      :imgSrc="require('@/assets/ABC.png')" :name="name" :openImgSrc="require('@/assets/ABC-colored.png')">
    </first-menu> -->
    <!-- <canvas class="background"></canvas> -->
    <div class="real">
      <Box></Box>
    </div>
  </div>
</template>
<script>
  import Box from '@/components/main-box.vue'
  export default {
    components: {
      Box
    },
    data() {
      return {
        name : "Vocabulary"
      }
    }
  }
</script>
<style>
  .background {
    position: absolute;
    display: block;
    top: 0;
    left: 0;
    z-index: 2;
  }
  .real{
    height: 100vh;
    width: 100vw;
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1;
    background: #1cefff;
    position: absolute;
  }
  *{
    margin : 0px;
    padding: 0px;
  }
</style>
