<script setup lang="ts">
// import axios from "axios"
import axios from "../api/request"
import {ref,onMounted} from "vue";
import {Course, MaybatisPage, SpringList} from "../model/Mode9090.ts";

let course = ref<Course[]>([])

// const count = ref(0);
async function getAllCourse(){
  const resp = await axios.get<MaybatisPage<Course>>("http://localhost:9090/api/course/selectPage?pageNum=1&pageSize=10")
  console.log(resp)
  course = resp.data.data.list
  console.log(course)

}
const deleteCourse = async id => {
  const resp = await axios.get<SpringList<Object>>("api/course/delete/"+id)
  course = resp.data.data
  console.log(course)
};
const updateCourse = async id => {
  const resp = await axios.get<SpringList<Object>>("api/course/delete/"+id)
  course = resp.data.data
  console.log(course)
};

// 页面加载完之后才开始调用
onMounted(()=> getAllCourse())
// getAllStudent()

const item = {
  date: '2016-05-02',
  name: 'Tom',
  address: 'No. 189, Grove St, Los Angeles',
  id: 12,
  no: '01',
  description: '人工智能',
  times: '2023-12-23 10:00:00',
  teacher: 'Mr.Xiao'

}
// TODO:记得回复成
const tableData = ref(Array.from({ length: 10 }).fill(item))


</script>
<template>
  <div>
    <el-scrollbar>
      <el-table :data="tableData">
        <el-table-column prop="id" label="Id" width="140" />
        <el-table-column prop="no" label="No" width="140" />
        <el-table-column prop="name" label="Name" width="120" />
        <el-table-column prop="teacher" label="Teacher" width="120" />
        <el-table-column prop="description" label="Description" width="120" />
        <el-table-column prop="times" label="Times" width="120" />
        <el-table-column label="操作">
          <el-button type="success" @click="updateCourse()">编辑</el-button>
          <el-button type="danger" @click="deleteCourse()">删除</el-button>
        </el-table-column>>
      </el-table>
    </el-scrollbar>
    <el-pagination background layout="prev, pager, next" :total="1000" />
  </div>

</template>