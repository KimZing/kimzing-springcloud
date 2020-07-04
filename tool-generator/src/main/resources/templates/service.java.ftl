package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    /**
     * 保存用户
     * @return
     */
    Integer save(UserSaveOrUpdateDTO userSaveDTO);

    /**
     * 移除用户
     * @return
     */
    Integer remove(Integer id);

    /**
     * 更新用户
     * @return
     */
    Integer update(UserSaveOrUpdateDTO userSaveDTO);

    /**
     * 通过ID查询单个用户
     * @return
     */
    UserSaveOrUpdateDTO get(Integer id);

    /**
     * 分页查询用户
     * @param userQueryDTO
     * @param pageParam
     * @return
     */
    List<UserSaveOrUpdateDTO> list(UserQueryDTO userQueryDTO, PageParam pageParam);
}
</#if>
