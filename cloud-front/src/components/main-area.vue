<template>
  <div>
    <div class="area">
        <mainBox></mainBox>
    </div>
  </div>
</template>

<script>
import mainBox from '@/components/vocabulary/main-box.vue'
export default {
    components : {
        mainBox
    }
}
</script>

<style scoped>
    .area{
        display: flex;
        justify-content: center;
    }
</style>