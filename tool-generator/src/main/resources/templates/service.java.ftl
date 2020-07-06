package ${package.Service};

import ${package.Entity}.*;
<#--import ${superServiceClassPackage};-->
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;

/**
 * ${table.comment!} 服务接口
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
<#--public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {-->
public interface ${table.serviceName} {

    /**
     * 保存${table.comment!}
     */
    void save(${table.name?cap_first}SaveDTO ${table.name}SaveDTO);

    /**
     * 移除${table.comment!}
     */
    void remove(Integer id);

    /**
     * 更新${table.comment!}
     */
    void update(${table.name?cap_first}UpdateDTO ${table.name}UpdateDTO);

    /**
     * 查询单个${table.comment!}
     */
    ${table.name?cap_first}BO get(Integer id);

    /**
     * 分页条件查询${table.comment!}
     */
    PageResult<${table.name?cap_first}BO> listPage(${table.name?cap_first}QueryDTO ${table.name}QueryDTO, PageParam pageParam);
}
</#if>
