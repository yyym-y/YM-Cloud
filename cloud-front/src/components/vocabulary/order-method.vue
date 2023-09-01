<template>
    <div>
        <img class="order" @click="clickOrderMethod" ref="order"  :src="nowSrc">
    </div>
</template>

<script>
export default {
    data() {
        return {
            img : [
                require('@/assets/vocabulary/alpha-order.png'),
                require('@/assets/vocabulary/alpha-reverse-order.png'),
                require('@/assets/vocabulary/random-choice.png')
            ],
            pos : 0,
            nowSrc : require('@/assets/vocabulary/alpha-order.png')
        }
    },
    methods : {
        clickOrderMethod() {
            this.pos ++; this.pos %= 3
            this.nowSrc = this.img[this.pos]
        }
    }
}
</script>

<style scoped>
    .order{
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