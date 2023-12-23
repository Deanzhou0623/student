<script setup lang="ts">

import {ArrowDown,Fold} from "@element-plus/icons-vue";

async function toUser() {
  console.log("个人信息查看!页面跳转")
}

async function exit() {
  console.log("退出登录")
}
</script>

<template>
  <div style="display: flex;line-height: 60px">
    <div>
      <el-icon style="margin-left: 0px; margin-top: 0px">
        <Fold></Fold>
      </el-icon>
    </div>

    <div style="flex: 1;text-align: center;font-size: 35px">
      <span>欢迎来到仓库管理系统</span>
    </div>


    <div class="toolbar">
      <span>肖嘉俊</span>
      <el-dropdown>
        <el-icon style="margin-left: 8px; margin-top: 23px">
          <ArrowDown/>
        </el-icon>

        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="toUser">个人信息</el-dropdown-item>
            <el-dropdown-item @click="exit">退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<style scoped>

</style>