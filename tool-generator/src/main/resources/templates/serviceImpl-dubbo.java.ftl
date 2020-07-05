package ${package.ServiceImpl};

import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
<#--import ${superServiceImplClassPackage};-->
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.user.domain.user.*;
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
 * <p>
 *     如果编写version版本号，调用方同样需要制定版本号
 * </p>
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
    ${table.mapperName} ${cfg.lowerMapperName};

    /**
     * 保存${table.comment!}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(${cfg.upperTableName}SaveDTO ${table.name}SaveDTO) {
        ${entity} ${cfg.lowerEntityName} = BeanUtil.mapperBean(${table.name}SaveDTO, ${entity}.class);
        ${cfg.lowerMapperName}.insert(${cfg.lowerEntityName});
    }

    /**
     * 移除${table.comment!}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Integer id) {
        ${cfg.lowerMapperName}.delete(id);
    }

    /**
     * 更新${table.comment!}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(${cfg.upperTableName}UpdateDTO ${table.name}UpdateDTO) {
        ${entity} ${cfg.lowerEntityName} = BeanUtil.mapperBean(${table.name}UpdateDTO, ${entity}.class);
        ${cfg.lowerMapperName}.update(${cfg.lowerEntityName});
    }

    /**
     * 查询单个${table.comment!}
     */
    @Override
    @Transactional(readOnly = true)
    public ${cfg.upperTableName}BO get(Integer id) {
        return ${cfg.lowerMapperName}.select(id);
    }

    /**
     * 分页条件查询${table.comment!}
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<${cfg.upperTableName}BO> listPage(${cfg.upperTableName}QueryDTO ${table.name}QueryDTO, PageParam pageParam) {
        // MARK Page对象必须放在第一个
        IPage<${cfg.upperTableName}BO> ${table.name}BOPage = ${cfg.lowerMapperName}.selectPage(convertPage(pageParam), userQueryDTO);
        return convertPageResult(userBOPage);
    }

}
</#if>
