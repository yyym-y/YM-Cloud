<template>
  <div>
    <div class="voc-area">
      <div v-for="(pr, index) in data" :key="index">
        <vocabulary :Chinese="pr.Chinese" :English="pr.English" :ifStar="pr.ifStar"></vocabulary>
      </div>
    </div>
  </div>
</template>

<script>
import vocabulary from '@/components/vocabulary/voc-info.vue'
export default {
  components : {
    vocabulary
  },
  data() {
    return {
      data : [
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
        {"English" : "vocabulary", "Chinese" : "词汇", "ifStar" : true , "note" : "default"},
      ]
    }
  }
}
</script>

<style scoped>
    .voc-area{
        width: 750px;
        height: 466px;
        margin: 0 auto;
        transform: translateY(25px);
    }
</style>