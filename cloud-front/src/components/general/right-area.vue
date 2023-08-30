<template>
  <div>
    <div class="info">
      <topMenu :name="name" :userImg="userImg"></topMenu>
    </div>
  </div>
</template>

<script>
import topMenu from '@/components/general/top-menu.vue'
import Bus from '@/utils/bus.js'
export default {
  components : {
    topMenu
  },
  data() {
    return {
      "name" : "",
      "userImg" : require('@/assets/general/波奇.png')
    }
  },
  mounted() {
    Bus.$on("getBarName", (name) => {
      console.log(name)
      this.name = name
    })
  }
}
</script>

<style scoped>
  .info{
    height: 626.5px;
    width: 922px;
    background-color: #EBF1FD;
    border-top-right-radius: 30px;
    border-bottom-right-radius: 30px;
    float: right;

  }
</style>