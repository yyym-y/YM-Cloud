<template>
    <div class="area">
        <leftMenu></leftMenu>
        <rightMenu></rightMenu>
    </div>
</template>

<script>
import leftMenu from '@/components/left-area.vue'
import rightMenu from '@/components/right-area.vue'
export default {
    components: {
        leftMenu, rightMenu
    }
}
</script>

<style scoped>
    .area{
        width: 1151.5px;
        height: 626.5px;
        z-index: 3;
        border-radius: 30px;
    }
</style>