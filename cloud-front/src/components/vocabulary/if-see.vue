<template>
    <div>
        <img class="eye" @click="clickEyeMethod" ref="eye"  :src="nowSrc">
    </div>
</template>

<script>
export default {
    methods : {
        clickEyeMethod(){
            if(this.ifShow)
                this.nowSrc = this.closeEyeImg
            else
                this.nowSrc = this.openEyeImg
            this.ifShow = ! this.ifShow
        }
    },
    data() {
        return {
            ifShow : true,
            nowSrc : require('@/assets/vocabulary/eye-show.png'),
            openEyeImg : require('@/assets/vocabulary/eye-show.png'),
            closeEyeImg : require('@/assets/vocabulary/eye-closed.png')
        }
    }
}
</script>

<style scoped>
    .eye{
        width: 20px;
        height: 20px;
        background-size: 100% 100%;
        float: right;
        display: block;
        border-style: none;
        margin-left: 10px;
        padding:0; border:0;
    }
</style>