<template>
  <div class="area-vocabulary">
    <div class="left-info">
        <img src="@/assets/general/arrow.png" class="right-arror">
        <div class="text-info">{{ content }}</div>
    </div>
    <div class="right-tool-bar">
        <add></add>
        <eye></eye>
        <edit></edit>
    </div>
    <div class="line"></div>
  </div>
</template>

<script>
import add from '@/components/vocabulary/add-voc.vue'
import edit from '@/components/vocabulary/edit-voc.vue'
import eye from '@/components/vocabulary/if-see.vue'
export default {
    components : {
        add, edit,eye
    },
    data() {
        return {
            content : "考研英语"
        }
    }
}
</script>

<style scopped>
    .area-vocabulary{
        width: 700px;
        height: 30px;
        margin-top: 19px;
    }
    .right-arror{
        width: 20px;
        height: 20px;
        float: left;
        transform: rotate(-90deg);
    }
    .left-info{
        width: 100px;
        height: 20px;
        float: left;
    }
    .text-info{
        float: left;
        margin-left: 10px;
        font-size: 14px;
    }
    .line{
        width: 740px;
        background-color: black;
        height: 2px;
        margin-top: 25px;
        transform: translate(-20px);
    }
    .right-tool-bar {
        float: right;
        height: 20px;
        width: 300px;
    }
</style>