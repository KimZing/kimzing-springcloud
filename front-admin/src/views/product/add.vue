<template>
  <div style="margin-top: 5px;margin-left: 20px; width: 500px">
    <el-form :model="productInfo" :rules="rules" ref="productInfoForm" :label-position="'left'" label-width="80px"
             size="small">
      <el-form-item label="商品名称" prop="title">
        <el-input v-model="productInfo.title"></el-input>
      </el-form-item>
      <el-form-item label="副标题">
        <el-input v-model="productInfo.subTitle"></el-input>
      </el-form-item>
      <el-form-item label="关键词">
        <el-input v-model="productInfo.keywords"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="productInfo.price"></el-input>
      </el-form-item>
      <el-form-item label="库存">
        <el-input v-model="productInfo.stock"></el-input>
      </el-form-item>
      <el-form-item label="库存预警">
        <el-input v-model="productInfo.lowStock"></el-input>
      </el-form-item>
      <el-form-item label="销量">
        <el-input v-model="productInfo.sales"></el-input>
      </el-form-item>
      <el-form-item label="是否上架">
        <el-input v-model="productInfo.publishStatus"></el-input>
      </el-form-item>
      <el-form-item label="商品主图">
        <el-input v-model="productInfo.image"></el-input>
      </el-form-item>
      <el-form-item label="专辑图片">
        <el-input v-model="productInfo.albumImages"></el-input>
      </el-form-item>
      <el-form-item label="电脑端详情">
        <el-input v-model="productInfo.albumImages"></el-input>
      </el-form-item>
      <el-form-item label="手机端详情">
        <el-input v-model="productInfo.albumImages"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        productInfo: {},
        rules: {
          title: [{required: true, message: '请输入标题', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}]
        }
      }
    }
  }
</script>

<style scoped>

</style>