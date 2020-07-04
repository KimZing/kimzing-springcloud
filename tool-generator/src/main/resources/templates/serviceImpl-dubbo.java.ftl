package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.apache.dubbo.config.annotation.Service;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
@Service(protocol = "dubbo", version = "1.0.0", timeout = 2000)
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Resource
    ${table.mapperName} ${table.mapperName};

    @Override
    public Integer save(UserDTO userSaveDTO) {
        return userMapper.insert(BeanUtil.mapperBean(userSaveDTO, UserPO.class));
    }

    @Override
    public Integer remove(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer update(UserDTO userSaveDTO) {
        return userMapper.updateById(BeanUtil.mapperBean(userSaveDTO, UserPO.class));
    }

    @Override
    public UserDTO get(Integer id) {
        UserPO userPO = userMapper.selectById(id);
        return BeanUtil.mapperBean(userPO, UserDTO.class);
    }

    //TODO 替换为公共包
    @Override
    public List<UserDTO> list(UserQueryDTO userQueryDTO, PageParam pageParam) {
        IPage<UserPO> userEntityIPage =
            userMapper.selectPage(new Page<>(pageParam.getPageNum(), pageParam.getPageSize()), null);
        return BeanUtil.mapperList(userEntityIPage.getRecords(), UserDTO.class);
    }

}
</#if>
