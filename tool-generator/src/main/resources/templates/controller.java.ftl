package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import org.apache.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.kimzing.web.resolver.json.JsonParam;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${cfg.packageName}.*;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * ${table.comment!}接口层.
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = "${table.comment!}")
@RestController
<#else>
@Controller
</#if>
<#--@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")-->
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Reference
    ${table.serviceName} ${cfg.lowerServiceName};

    @ApiOperation(value = "保存${table.comment!}")
    @PostMapping
    public void save(@RequestBody ${cfg.upperTableName}SaveDTO ${table.name}SaveDTO) {
        ${table.name}Service.save(${table.name}SaveDTO);
    }

    @ApiOperation(value = "移除${table.comment!}")
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id) {
         ${table.name}Service.remove(id);
    }

    @ApiOperation(value = "更新${table.comment!}")
    @PutMapping
    public void update(@RequestBody ${cfg.upperTableName}UpdateDTO ${table.name}UpdateDTO) {
        ${table.name}Service.update(${table.name}UpdateDTO);
    }

    @ApiOperation(value = "查询单个${table.comment!}")
    @GetMapping("/{id}")
    public ${cfg.upperTableName}BO get(@PathVariable("id") Integer id) {
        return ${table.name}Service.get(id);
    }

    @ApiOperation(value = "分页条件查询${table.comment!}")
    @GetMapping("/list")
    public PageResult<${cfg.upperTableName}BO> listPage(@JsonParam ${cfg.upperTableName}QueryDTO ${table.name}QueryDTO, @ModelAttribute PageParam pageParam) {
        return ${table.name}Service.listPage(${table.name}QueryDTO, pageParam);
    }

}
</#if>
