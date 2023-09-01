<template>
  <div>
    <div class="bar">
        <div class="English">{{ English }}</div>
        <div class="Chinese">{{ Chinese }}</div>
        <img :src="star" class="ifStar" ref="ifStar">
    </div>
  </div>
</template>

<script>
export default {
    props : ['English', 'Chinese', 'ifStar', 'note'],
    data() {
        return {
        star : require('@/assets/vocabulary/star-colored.png')
        }
    }
}
</script>

<style scoped>
    .bar{
        width: 750px;
        height: 25px;
    }
    .English {
        width : 200px;
        height : 25px;
        float: left;
        font-size: 16px;
        transform: translateY(-17px);
        padding-left: 20px;
        display: flex;
        align-items: center;
    }
    .Chinese {
        width : 450px;
        height : 25px;
        float: left;
        font-size: 15px;
        transform: translateY(-17px);
        padding-left: 20px;
        display: flex;
        align-items: center;
    }
    .ifStar{
        width: 25px;
        height: 25px;
        float: right;
        transform: translateY(-17px);
        margin-right: 25px;
    }
</style>