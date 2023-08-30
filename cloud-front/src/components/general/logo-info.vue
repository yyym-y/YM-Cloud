<template>
  <div class="area">
    <div class="img"></div>
    <div class="name">YM~Cloud</div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
  .area{
    width: 204px;
    height: 63px;
  }
  .img{
    width: 63px;
    height: 63px;
    background-image: url("@/assets/general/logo.png");
    background-size: 100% 100%;
    float: left;
  }
  .name{
    width: 137.9px;
    height: 45.5px;
    color: #3A3F8A;
    font-weight: 1000;
    font-size: 22px;
    float: left;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 8.75px;
    margin-left: 3px;
  }

</style>