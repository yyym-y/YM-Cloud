<template>
  <div class="area">
      <div class="real">
        <router-view></router-view>
      </div>
    <canvas class="background"></canvas>
  </div>
</template>
<script>
  export default {
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
    z-index: 1;
    background-color: #1cefff;
  }
  .real{
    height: 100vh;
    width: 100vw;
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 2;
    position: absolute;
  }
  *{
    margin : 0px;
    padding: 0px;
  }
</style>
