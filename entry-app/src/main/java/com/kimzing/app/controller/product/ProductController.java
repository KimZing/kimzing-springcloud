package com.kimzing.app.controller.product;


import com.kimzing.product.domain.product.ProductBO;
import com.kimzing.product.domain.product.ProductQueryDTO;
import com.kimzing.product.service.product.ProductService;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.kimzing.web.resolver.json.JsonParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * 产品信息接口层.
 *
 * @author KimZing
 * @since 2020-07-23
 */
@Api(tags = "产品信息")
@RestController
@RequestMapping("/product")
public class ProductController {

    @DubboReference
    ProductService productService;

    @ApiOperation(value = "查询单个产品信息")
    @GetMapping("/{id}")
    public ProductBO get(@PathVariable("id") Integer id) {
        return productService.get(id);
    }

    @ApiOperation(value = "分页条件查询产品信息")
    @GetMapping("/list")
    public PageResult<ProductBO> listPage(@JsonParam(required = false) ProductQueryDTO productQueryDTO, @ModelAttribute PageParam pageParam) {
        return productService.listPage(productQueryDTO, pageParam);
    }

}
