package ${package.Mapper};

<#--import ${package.Entity}.${entity};-->
<#--import ${superMapperClassPackage};-->
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ${table.comment!} Mapper 接口
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
@Mapper
<#--public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {-->
public interface ${table.mapperName} {

    /**
     * 保存${table.comment!}
     */
    Integer insert(${entity} ${cfg.lowerEntityName});

    /**
     * 删除${table.comment!}
     */
    void delete(Integer id);

    /**
     * 根据ID更新${table.comment!}
     */
    void update(${entity} ${cfg.lowerEntityName});

    /**
     * 根据ID查询${table.comment!}
     */
    ${cfg.upperTableName}BO select(Integer id);

    /**
     * 条件分页查询${table.comment!}
     */
    IPage<${cfg.upperTableName}BO> selectPage(Page<${cfg.upperTableName}BO> page, @Param("query") ${cfg.upperTableName}QueryDTO ${table.name}QueryDTO);

  }
</#if>
