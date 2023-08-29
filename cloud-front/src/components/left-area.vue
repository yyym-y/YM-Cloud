<template>
  <div>
    <div class="info">
      <div class="llogo">
        <logo></logo>
      </div>
      <div class="menuBar">MENU</div>
      <div class="list">
        <Menu></Menu>
      </div>
    </div>
  </div>
</template>

<script>
import logo from '@/components/logo-info.vue'
import Menu from '@/components/total-menu.vue'
export default {
  components: {
    logo , Menu
  }
}
</script>

<style scoped>
  .info{
    height: 626.5px;
    width: 226px;
    background-color: white;
    border-top-left-radius: 30px;
    border-bottom-left-radius: 30px;
    float: left;
    box-shadow: 2px 0 4px 0 rgba(0,0,0,0.25);
    border-right-color: gray;
    border-right-style: solid;
    border-right-width: 2px;
  }
  .llogo{
    margin: 0 auto;
    margin-top: 32px;
    width: 204px;
    height: 63px;
    display: flex;
    justify-content: center;
  }
  .menuBar{
    width: 180px;
    height: 20.3px;
    font-size: 13px;
    font-weight: 700;
    color: #AEAFB8;
    margin: 25px auto;
  }
  .list{
    width: 11vw;
    margin: 0 auto;
  }
</style>