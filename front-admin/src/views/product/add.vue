<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="productInfo" :rules="rules" ref="productInfoForm"
             :label-position="'right'" label-width="auto" size="small" label-suffix=":"
             style="width: 600px;">
      <el-form-item label="商品名称" prop="title">
        <el-input v-model="productInfo.title" type="text" placeholder="请输入商品标题" maxlength="10"
                  show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="副标题">
        <el-input v-model="productInfo.subTitle" type="text" placeholder="请输入副标题" maxlength="18"
                  show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input-number v-model="productInfo.price" :precision="2" :step="1" :min="0"
                         controls-position="right"></el-input-number>
      </el-form-item>
      <el-form-item label="库存">
        <el-input-number v-model="productInfo.stock" :min="0" controls-position="right"></el-input-number>
      </el-form-item>
      <el-form-item label="库存预警">
        <el-input-number v-model="productInfo.lowStock" :min="0" controls-position="right"></el-input-number>
      </el-form-item>
      <el-form-item label="销量">
        <el-input-number v-model="productInfo.sales" :min="0" controls-position="right"></el-input-number>
      </el-form-item>
      <el-form-item label="关键词">
        <el-input v-model="productInfo.keywords" placeholder="请输入搜索关键词，以逗号分隔"></el-input>
      </el-form-item>
      <el-form-item label="上架状态">
        <el-select v-model="productInfo.publishStatus" placeholder="请选择上架状态">
          <el-option
            key="UNPUBLISHED"
            label="下架"
            value="UNPUBLISHED">
          </el-option>
          <el-option
            key="PUBLISHED"
            label="上架"
            value="PUBLISHED">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="商品主图">
        <el-upload action="http://127.0.0.1:9001/admin/storage/upload/default" :on-success="handleImageSuccess"
                   :data="uploadAttr"
                   list-type="picture-card" :auto-upload="true" :limit='1' name="file">
          <i slot="default" class="el-icon-plus"></i>
          <div slot="file" slot-scope="{file}">
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
            <span class="el-upload-list__item-actions">
              <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file.url)">
                <i class="el-icon-zoom-in"></i>
              </span>
              <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                <i class="el-icon-delete"></i>
              </span>
            </span>
          </div>
        </el-upload>
      </el-form-item>
      <el-form-item label="专辑图片">
        <el-upload action="http://127.0.0.1:9001/admin/storage/upload/default" :on-success="handleAlbumImageSuccess"
                   :data="uploadAttr"
                   list-type="picture-card" :auto-upload="true" :limit='5' name="file">
          <i slot="default" class="el-icon-plus"></i>
          <div slot="file" slot-scope="{file}">
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
            <span class="el-upload-list__item-actions">
              <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file.url)">
                <i class="el-icon-zoom-in"></i>
              </span>
              <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                <i class="el-icon-delete"></i>
              </span>
            </span>
          </div>
        </el-upload>
      </el-form-item>
      <el-form-item label="电脑端详情">
        <el-input v-model="productInfo.detailPc"></el-input>
      </el-form-item>
      <el-form-item label="手机端详情">
        <el-input v-model="productInfo.detailMobile"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitProductForm()">立即创建</el-button>
        <el-button @click="resetProductForm">重置</el-button>
      </el-form-item>
    </el-form>

    <el-dialog :visible.sync="image.visiable">
      <img width="100%" :src="image.url" alt="">
    </el-dialog>
  </el-card>
</template>

<script>
  import {addProduct} from "@/api/product";

  var rules = {
    title: [
      {required: true, message: "商品名称不能为空"}
    ],
    price: [
      {required: true, message: "商品价格不能为空"}
    ],
  }
  export default {
    data() {
      return {
        image: {
          visiable: false,
          url: ""
        },
        uploadAttr: {
          bucket: "product",
          path: "images"
        },
        productInfo: {
          title: null, // 商品标题
          subTitle: null, // 商品副标题
          price: null, // 价格
          stock: 0, // 库存
          lowStock: 0, // 库存预警值
          sales: 0, // 销量
          keywords: null, // 关键字
          publishStatus: "UNPUBLISHED", // 上架状态
          image: null,//商品主图
          albumImages: null, // 专辑图片,以逗号分割
          detailPc: null, // PC端网页详情
          detailMobile: null, // 移动端网页详情
        },
        rules: rules
      }
    },
    methods: {
      handleImageSuccess(res) {
        this.productInfo.image = res.data.url
        console.log(1111, res, 2222, this.productInfo)
      },
      handleAlbumImageSuccess(res) {
        this.productInfo.image = res.data.url
        console.log(1111, res, 2222, this.productInfo)
      },
      handlePictureCardPreview(url) {
        this.image.url = url
        this.image.visiable = true
      },
      handleRemove(file) {
        console.log(file.url)
      },
      submitProductForm() {
        this.$refs.productInfoForm.validate((valid) => {
          if (valid) {
            addProduct(this.productInfo).then(response => {
              if (response.code === "0") {
                this.$notify({
                  title: '成功',
                  message: '创建成功',
                  type: 'success',
                  position: 'top-right'
                })
              }
            })
          } else {
            alert('error submit!!');
            return false;
          }
        });
      },
      resetProductForm() {
        this.$refs.productInfoForm.resetFields();
      }
    }
  }
</script>

<style scoped>
  .form-container {
    width: 800px;
    padding-left: 70px;
    margin-left: 50px;
  }
</style>