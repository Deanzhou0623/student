<script setup lang="ts">
import axios from "../api/request.ts"
import {ref, onMounted, reactive} from "vue";
import {Course, MaybatisPage} from "../model/Mode9090.ts";

let course = ref<Course[]>([])
let total = 10;
const searchCourse: Course = {
  name: ''
}

const addCourse: Course = reactive({
  name: '',
  no: '',
  description: '',
  times: '',
  teacher: ''
});
const updateCourse: Course = reactive({
  name: '',
  no: '',
  description: '',
  times: '',
  teacher: ''
});
const input = ref('')
// 新增参数
const dialogFormVisible = ref(false)
const dialogFormVisible2 = ref(false)
const formLabelWidth = '140px'

function clearAddCourse() {
  Object.keys(addCourse).forEach(key => {
    addCourse[key] = ''; // 或者设置为适当的初始值
  });
}

// const count = ref(0);
async function getAllCourse(currentPage: number, pageSize: number) {
  if (currentPage == null || pageSize == null) {
    currentPage = 1;
    pageSize = 20;
  }
  searchCourse.name = input.value;
  const resp = await axios.post<MaybatisPage<Course>>(`/course/selectPage?pageNum=${currentPage}&pageSize=${pageSize}`, searchCourse)
  console.log(resp)
  course.value = resp.data.data.list
  total = resp.data.data.total
  console.log(total)
}

async function clickPageNum(currentPage: number, pageSize: number) {
  console.log("触发clickPageNum")
  getAllCourse(currentPage, pageSize)
}

//添加课程
async function addCourseFunction(course: Course) {
  await axios.post<Course>('/course/add', course)
  await getAllCourse(1, 20);
  clearAddCourse();
}


/**
 * 数据回显
 * @param course
 */
async function changeCoursefunction(course: Course) {
  console.log(course)
  updateCourse.id = course.id
  updateCourse.no = course.no
  updateCourse.name = course.name
  updateCourse.description = course.description
  updateCourse.teacher = course.teacher
  updateCourse.times = course.times
  console.log("***************")
  console.log(updateCourse)

  // await axios.post<Course>('/course/add', course)
  getAllCourse(1, 20);
}

/**
 * 修改
 * @param course
 */
async function updateCoursefunction(course: Course) {
  await axios.put<Course>('/course/update', course)
  getAllCourse(1, 20);
}
/**
 * 删除
 * @param id
 */
async function delCoursefunction(id: number) {
  await axios.delete<Course>('/course/delete/'+id)
  getAllCourse(1, 20);
}



/**
 * 重置
 */
async function clearSelect() {
  searchCourse.name = '';
  input.value = ''
  console.log(searchCourse.name, input)
}

// 页面加载完之后才开始调用
onMounted(() => getAllCourse(1, 20))




</script>
<template>
  <div style="margin-top: 5px">
    <el-input v-model="input" placeholder="请输入查询条件" @keyup.enter="getAllCourse" style="width: 200px"/>
    <el-button type="primary" @click="getAllCourse(1,20)" style="margin-left: 5px">查询</el-button>
    <el-button type="info" @click="clearSelect">重置</el-button>

    <el-button type="success" @click="dialogFormVisible = true">
      新增
    </el-button>

    <el-dialog v-model="dialogFormVisible" title="新增课程">
      <el-form :model="addCourse">
        <el-form-item label="课程编号" :label-width="formLabelWidth">
          <el-input v-model="addCourse.no" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="课程名称" :label-width="formLabelWidth">
          <el-input v-model="addCourse.name" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="任课老师" :label-width="formLabelWidth">
          <el-input v-model="addCourse.teacher" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="课程介绍" :label-width="formLabelWidth">
          <el-input v-model="addCourse.description" autocomplete="off"/>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="addCourseFunction(addCourse);dialogFormVisible= false">
          提交
        </el-button>
      </span>
      </template>
    </el-dialog>

    <el-dialog v-model="dialogFormVisible2" title="修改课程">
      <el-form :model="updateCourse">
        <el-form-item label="课程编号" :label-width="formLabelWidth">
          <el-input v-model="updateCourse.no" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="课程名称" :label-width="formLabelWidth">
          <el-input v-model="updateCourse.name" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="任课老师" :label-width="formLabelWidth">
          <el-input v-model="updateCourse.teacher" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="课程介绍" :label-width="formLabelWidth">
          <el-input v-model="updateCourse.description" autocomplete="off"/>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible2 = false">取消</el-button>
        <el-button type="primary" @click="updateCoursefunction(updateCourse);dialogFormVisible2= false">
          提交
        </el-button>
      </span>
      </template>
    </el-dialog>


  </div>

  <div>
    <el-scrollbar>
      <el-table :data="course">
        <el-table-column prop="id" label="Id" width="140"/>
        <el-table-column prop="no" label="No" width="140"/>
        <el-table-column prop="name" label="Name" width="120"/>
        <el-table-column prop="teacher" label="Teacher" width="120"/>
        <el-table-column prop="description" label="Description" width="120"/>
        <el-table-column prop="times" label="Times" width="120"/>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button type="success" @click="changeCoursefunction(scope.row); dialogFormVisible2 = true">编辑</el-button>
            <el-button type="danger" @click="() => {delCoursefunction(scope.row.id); }">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-scrollbar>
    <el-pagination background @change="clickPageNum" layout="prev, pager, next" :total="total"/>
  </div>
</template>