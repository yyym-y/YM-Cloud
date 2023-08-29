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
    width: 300px;
    height: 90px;
  }
  .img{
    width: 90px;
    height: 90px;
    background-image: url("@/assets/logo.png");
    background-size: 100% 100%;
    float: left;
  }
  .name{
    width: 197px;
    height: 65px;
    color: #3A3F8A;
    font-weight: 1000;
    font-size: 28px;
    float: left;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 15px;
  }

</style>