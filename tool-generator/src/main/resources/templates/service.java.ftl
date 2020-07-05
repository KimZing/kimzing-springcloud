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
    void save(${cfg.upperTableName}SaveDTO ${table.name}SaveDTO);

    /**
     * 移除${table.comment!}
     */
    void remove(Integer id);

    /**
     * 更新${table.comment!}
     */
    void update(${cfg.upperTableName}UpdateDTO ${table.name}UpdateDTO);

    /**
     * 查询单个${table.comment!}
     */
    ${cfg.upperTableName}BO get(Integer id);

    /**
     * 分页条件查询${table.comment!}
     */
    PageResult<${cfg.upperTableName}BO> listPage(${cfg.upperTableName}QueryDTO ${table.name}QueryDTO, PageParam pageParam);
}
</#if>
