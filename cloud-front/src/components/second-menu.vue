<template scope="prop">
  <div class="area">
    <div class="bar"></div>
    <div class="content gray" @click="mess" ref="wapper">
      <slot>default</slot>
    </div>    
  </div>
</template>

<script>
export default {
  props : ['menukey', 'light'],
  methods: {
    mess() {
      this.$emit('ifClick', this.menukey)
    }
  },
  watch: {
    light (newValue){
      let ele = this.$refs.wapper
      if(newValue){
        ele.style.color = "#DB8850"
        ele.style.fontSize = "2.2vh"
      }else {
        ele.style.color = "#B1AAA5"
        ele.style.fontSize = "1.8vh"
      }
    }
  }
}
</script>

<style scoped>
    .area{
      height: 22px;
      width: 150px;
      margin-left: 2.5vw;
    }
    .content{
      height: 20.3px;
      width:  120px;
      font-size: 10px;
      float: left;
      margin-left: 25px;
      display: flex;
      align-items: center;
      color : #B1AAA5;
    }
    .bar{
      height: 22px;
      width: 1.5px;
      background-color: #B1AAA5;
      float: left;
    }
</style>