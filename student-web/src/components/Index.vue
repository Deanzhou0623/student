<template>
  <el-container class="layout-container-demo" style="height: 100%">
    <el-aside width="200px">
      <Aside isCollapse="isCollapse"></Aside>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <Header></Header>
      </el-header>

      <el-main>
        <Main></Main>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
import Aside from "./Aside.vue";
import Header from "./Header.vue";
import Main from "./Main.vue";
</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
}

.layout-container-demo .el-header {
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}

.layout-container-demo .el-menu {
  border-right: none;
}

.layout-container-demo .el-main {
  padding: 0;
}

.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}

</style>
