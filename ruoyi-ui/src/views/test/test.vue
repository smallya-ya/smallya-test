
<template>
  <div class="background-image" :style="{ backgroundImage: `url(${require('@/assets/images/test-background.jpg')})` }">
    <vue-particles color="#dedede">    </vue-particles>

    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="150px">
        <el-col :span="24">
          <el-form-item label="方案名称" prop="field102">
            <el-input v-model="formData.field102" placeholder="请输入方案名称" clearable :style="{width: '30%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="地图名称" prop="field101">
            <el-input v-model="formData.field101" placeholder="请输入地图名称" clearable :style="{width: '30%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="参与人数" prop="field106">
            <el-input-number v-model="formData.field106" placeholder="人数参与参与人数"></el-input-number>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="日期范围" prop="field108">
            <el-date-picker type="daterange" v-model="formData.field108" format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd" :style="{width: '30%'}" start-placeholder="演习开始日期"
                            end-placeholder="演习结束日期" range-separator="至" clearable></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="时间范围" prop="field107">
            <el-time-picker v-model="formData.field107" is-range format="HH:mm:ss" value-format="HH:mm:ss"
                            :style="{width: '30%'}" start-placeholder="演习开始时间" end-placeholder="演习结束时间" range-separator="至"
                            clearable></el-time-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">创建</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    </div>


</template>

<style scoped>

.background-image {
  background-size: cover;
  width: 100%;
  height: 100%;/* 添加这一行 */
  z-index: -1;
}
</style>
<script >
import { addmap } from "@/api/test/test";

export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field102: undefined,
        field101: undefined,
        field106: 10,
        field108: null,
        field107: null,
        field109: '',
      },
      rules: {
        field102: [{
          required: true,
          message: '请输入方案名称',
          trigger: 'blur'
        }],
        field101: [{
          required: true,
          message: '请输入地图名称',
          trigger: 'blur'
        }],
        field106: [{
          required: true,
          message: '人数参与参与人数',
          trigger: 'blur'
        }],
        field108: [{
          required: true,
          message: '日期范围不能为空',
          trigger: 'change'
        }],
        field107: [{
          required: true,
          message: '时间范围不能为空',
          trigger: 'change'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        console.log(this.form)
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
