package ${package.ServiceImpl};

import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
<#--import ${superServiceImplClassPackage};-->
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package.Entity}.${entity};
import com.kimzing.${cfg.moduleName}.domain.${cfg.packageName}.*;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.kimzing.utils.page.MPPageUtil.convertPage;
import static com.kimzing.utils.page.MPPageUtil.convertPageResult;

import javax.annotation.Resource;

/**
 * ${table.comment!} 服务实现类
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
@Service(protocol = "dubbo", timeout = 2000)
<#--public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {-->
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Resource
    ${table.mapperName} ${table.mapperName?uncap_first};

    /**
     * 保存${table.comment!}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${table.name?cap_first}BO save(${table.name?cap_first}SaveDTO ${table.name}SaveDTO) {
        ${entity} ${entity?uncap_first} = BeanUtil.mapperBean(${table.name}SaveDTO, ${entity}.class);
        ${table.mapperName?uncap_first}.insert(${entity?uncap_first});

        return BeanUtil.mapperBean(${entity?uncap_first}, ${table.name?cap_first}BO.class);
    }

    /**
     * 移除${table.comment!}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Integer id) {
        ${table.mapperName?uncap_first}.delete(id);
    }

    /**
     * 更新${table.comment!}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(${table.name?cap_first}UpdateDTO ${table.name}UpdateDTO) {
        ${entity} ${entity?uncap_first} = BeanUtil.mapperBean(${table.name}UpdateDTO, ${entity}.class);
        ${table.mapperName?uncap_first}.update(${entity?uncap_first});
    }

    /**
     * 查询单个${table.comment!}
     */
    @Override
    @Transactional(readOnly = true)
    public ${table.name?cap_first}BO get(Integer id) {
        return ${table.mapperName?uncap_first}.selectById(id);
    }

    /**
     * 分页条件查询${table.comment!}
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<${table.name?cap_first}BO> listPage(${table.name?cap_first}QueryDTO ${table.name}QueryDTO, PageParam pageParam) {
        IPage<${table.name?cap_first}BO> ${table.name}BOPage = ${table.mapperName?uncap_first}.selectPage(convertPage(pageParam), ${table.name}QueryDTO);
        return convertPageResult(${table.name}BOPage);
    }

}
</#if>
