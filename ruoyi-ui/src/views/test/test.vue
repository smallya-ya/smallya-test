<template>
  <div>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
      <el-form-item label="方案名称" prop="field101">
        <el-input v-model="formData.field101" placeholder="请输入方案名称" clearable :style="{width: '100%'}">
        </el-input>
      </el-form-item>
      <el-form-item label="地图名称" prop="field102">
        <el-input v-model="formData.field102" placeholder="请输入地图名称" clearable :style="{width: '100%'}">
        </el-input>
      </el-form-item>
      <el-form-item label="参与人数" prop="field109">
        <el-input-number v-model="formData.field109" placeholder="参与人数"></el-input-number>
      </el-form-item>
      <el-form-item label="日期范围" prop="field106">
        <el-date-picker type="daterange" v-model="formData.field106" format="yyyy-MM-dd"
          value-format="yyyy-MM-dd" :style="{width: '100%'}" start-placeholder="开始日期" end-placeholder="结束日期"
          range-separator="至" clearable></el-date-picker>
      </el-form-item>
      <el-form-item label="时间范围" prop="field107">
        <el-time-picker v-model="formData.field107" is-range format="HH:mm:ss" value-format="HH:mm:ss"
          :style="{width: '100%'}" start-placeholder="开始时间" end-placeholder="结束时间" range-separator="至"
          clearable></el-time-picker>
      </el-form-item>
      <el-form-item label="确认创建" prop="field108">
        <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field101: undefined,
        field102: undefined,
        field109: 10,
        field106: null,
        field107: null,
        field108: undefined,
      },
      rules: {
        field101: [{
          required: true,
          message: '请输入方案名称',
          trigger: 'blur'
        }],
        field102: [{
          required: true,
          message: '请输入地图名称',
          trigger: 'blur'
        }],
        field109: [{
          required: true,
          message: '参与人数',
          trigger: 'blur'
        }],
        field106: [{
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
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style>
</style>
