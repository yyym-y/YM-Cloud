<template>
    <div>
        <div class="add" @click="clickAddMethod"></div>
    </div>
</template>

<script>
export default {
    methods : {
        clickAddMethod(){
            console.log("click add")
        }
    }
}
</script>

<style scoped>
    .add{
        width: 20px;
        height: 20px;
        background-size: 100% 100%;
        background-image: url("@/assets/vocabulary/add.png");
        float: right;
        margin-left: 10px;
    }
</style>