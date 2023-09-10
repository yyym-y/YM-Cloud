<template>
  <div>
    <LogIn></LogIn>
    <div class="register" ref="reg">
        <makeAcount></makeAcount>
    </div>
    <div class="forget" ref="fog">
        <Forget></Forget>
    </div>
  </div>
</template>

<script>
import LogIn from '@/components/general/log-com.vue'
import makeAcount from '@/components/general/new-account'
import Bus from '@/utils/bus.js'
import Forget from '@/components/general/forget-account.vue'
export default {
    components : {
        makeAcount,
        LogIn,
        Forget
    },
    data() {
      return {
        ifOpenWindow : false
      }
    },
    created() {
      Bus.$on("closeRegisterWindow", (result) => {
        if(result) {
          if(this.ifOpenWindow == false) return
          let ele = this.$refs.reg;
          ele.style.display = "none";
          this.ifOpenWindow = false;
        }
      }),

      Bus.$on("openRegister", (result) => {
        if(result) {
          if(this.ifOpenWindow == true) return;
          this.ifOpenWindow = true;
          let ele = this.$refs.reg;
          ele.style.display = "unset";
        }
      }),

      Bus.$on("closeForgetWindow", (result) => {
        if(result) {
          if(this.ifOpenWindow == false) return
          let ele = this.$refs.fog;
          ele.style.display = "none"
          this.ifOpenWindow = false;
        }
      }),

      Bus.$on("openForget", (result) => {
        if(result) {
          if(this.ifOpenWindow == true) return;
          this.ifOpenWindow = true;
          let ele = this.$refs.fog;
          ele.style.display = "unset";
        }
      })
    }
}
</script>

<style scoped>
  .register {
    display: none;
  }
  .forget {
    display: none;
  }
</style>