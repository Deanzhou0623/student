<script setup lang="ts">
import axios from "../api/request.ts"
import {ref,onMounted} from "vue";
import {Course, MaybatisPage, SpringList} from "../model/Mode9090.ts";

let course = ref<Course[]>([])

// const count = ref(0);
async function getAllCourse(currentPage: number, pageSize: number){
  const resp = await axios.get<MaybatisPage<Course>>(`/course/selectPage?pageNum=${currentPage}&pageSize=${pageSize}`)
  console.log(resp)
  course = resp.data.data.list
  console.log(course)
}
async function clickPageNum(currentPage: number, pageSize: number){
  console.log("触发clickPageNum")
  getAllCourse(currentPage,pageSize)
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
      <el-table :data="course">
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
    <el-pagination background @change="clickPageNum" layout="prev, pager, next" :total="1000" />
  </div>
</template>