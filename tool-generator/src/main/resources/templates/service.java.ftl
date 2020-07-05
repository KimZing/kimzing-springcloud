package ${package.Service};

import ${package.Entity}.${cfg.packageName}.*;
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
    public void remove(Integer id);

    /**
     * 更新${table.comment!}
     */
    public void update(${cfg.upperTableName}UpdateDTO ${table.name}UpdateDTO);

    /**
     * 查询单个${table.comment!}
     */
    public ${cfg.upperTableName}BO get(Integer id);

    /**
     * 分页条件查询${table.comment!}
     */
    public PageResult<${cfg.upperTableName}BO> listPage(${cfg.upperTableName}QueryDTO ${table.name}QueryDTO, PageParam pageParam);
}
</#if>
