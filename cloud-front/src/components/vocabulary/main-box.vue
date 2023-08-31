<template>
    <div>
        <div class="box">
            <toolBar></toolBar>
        </div>
    </div>
</template>

<script>
import toolBar from '@/components/vocabulary/tool-bar.vue'
export default {
    components : {
        toolBar
    }
}
</script>

<style scoped>
    .box{
        width: 800px;
        height: 521.5px;
        background-color: white;
        border-top-left-radius: 30px;
        border-top-right-radius: 30px;
        margin-top: 20px;
        display: flex;
        justify-content: center;
    }
</style>