<template>
  <div>
    <el-table ref="productTable"
              :data="productList"
              style="width: 100%"
              @selection-change="handleSelectionChange"
              v-loading="listLoading"
              border>
      <el-table-column type="selection" width="60" align="center"></el-table-column>
      <el-table-column label="产品图片" width="120" align="center">
        <template slot-scope="scope"><img style="height: 80px" :src="scope.row.image"></template>
      </el-table-column>
      <el-table-column label="名称" align="center">
        <template slot-scope="scope">
          <p>{{scope.row.title}}</p>
        </template>
      </el-table-column>
      <el-table-column label="价格" width="120" align="center">
        <template slot-scope="scope">
          <p>价格：￥{{scope.row.price}}</p>
        </template>
      </el-table-column>
      <el-table-column label="库存" width="100" align="center">
        <template slot-scope="scope">
          <p>{{scope.row.stock}}</p>
        </template>
      </el-table-column>
      <el-table-column label="销量" width="100" align="center">
        <template slot-scope="scope">{{scope.row.sales}}</template>
      </el-table-column>
      <el-table-column label="操作" width="160" align="center">
        <template slot-scope="scope">
          <p>
            <el-button
              size="mini"
              @click="handleShowProduct(scope.$index, scope.row)">查看
            </el-button>
            <el-button
              size="mini"
              @click="handleUpdateProduct(scope.$index, scope.row)">编辑
            </el-button>
          </p>
          <p>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </p>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import {getProductList} from '@/api/product'

  export default {
    data() {
      return {
        listLoading: true,
        productList: [],
      }
    },
    created() {
      getProductList().then(response => {
        this.productList = response.data.list
      }).catch(error => {
        console.log(error)
      })
      this.listLoading=false
    },
    methods: {
      handleShowProduct() {},
      handleUpdateProduct(){},
      handleDelete(){},
      handleSelectionChange(){},
    }
  }
</script>

<style scoped>

</style>