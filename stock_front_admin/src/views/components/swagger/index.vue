<template>
    <div class="swagger" style="">
        <iframe id="iframe" :src="url" scrolling="auto" frameborder="0"></iframe>
    </div>
</template>

<script>
import {ip} from '@/common/env.js'

export default {
    name: "component-swagger",
    data () {
        return {
            url:ip + '/swagger-ui/index.html'
        }
    },
}
</script>

<style lang="css" scoped>
.swagger{
    position: relative;
    margin-left: -10px;
    margin-right: -10px;
    padding-top:25%;
    padding-bottom:25%;
    width:100%;
    font-size:12px;
    overflow: hidden;
}
#iframe{
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    width: 100%;
    height: 100%;
    background: #fff;
    overflow-y: hidden;
}
</style>