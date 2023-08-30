<template>
  <div>
    <img class="headImg" ref="head" :src="userImg">
  </div>
</template>

<script>
export default {
  props : ['userImg']
}
</script>

<style>
    .headImg{
      float: right;
      width: 52.5px;
      height: 52.5px;
      border-radius: 10px;
    }
</style>