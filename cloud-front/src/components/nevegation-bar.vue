<template>
  <div class="area">
    <div class="first-name">Discovery</div>
    <div class="img"></div>
    <div class="now-name">
        <slot>now-name</slot>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>
    .area{
        height: 52px;
        width: 450px;
    }
    .first-name{
        width: 152px;;
        height: 52px;
        color: #4B51AD;
        font-weight: 1000;
        font-size: 28px;
        display: flex;
        justify-content: center;
        align-items: center;
        float: left;
    }
    .img{
        height: 30px;
        width: 30px;
        background-image: url("../../public/img/arrow.png");
        background-size: 100% 100%;
        transform: rotate(-90deg);
        float: left;
        margin-top: 11px;
        margin-right: 10px;
    }
    .now-name{
        height: 52px;
        width: 200px;
        color: #A8A8AC;
        font-size: 28px;
        display: flex;
        align-items: center;
        float: left;
    }
</style>
    