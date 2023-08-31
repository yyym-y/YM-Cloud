<template>
    <div>
        <div class="edit" @click="clickEditMethod"></div>
    </div>
</template>

<script>
export default {
    methods : {
        clickEditMethod(){
            console.log("click edit")
        }
    }
}
</script>

<style scoped>
    .edit{
        width: 20px;
        height: 20px;
        background-size: 100% 100%;
        background-image: url("@/assets/vocabulary/edit.png");
        float: right;
        margin-left: 10px;
    }
</style>