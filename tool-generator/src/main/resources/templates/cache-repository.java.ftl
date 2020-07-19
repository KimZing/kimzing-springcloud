package ${package.Mapper};

<#--import ${package.Entity}.${entity};-->
<#--import ${superMapperClassPackage};-->
import com.kimzing.${cfg.moduleName}.domain.${cfg.packageName}.*;
import org.springframework.stereotype.Repository;
import com.kimzing.redis.KFCRedisTemplate;
import javax.annotation.Resource;

/**
 * ${table.comment!} 缓存操作
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
@Repository
<#--public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {-->
public class ${table.name?cap_first}CacheRepository {

    public static final String PREFIX = "${table.name}:";

    @Resource
    KFCRedisTemplate kfcRedisTemplate;

    /**
     * 插入${table.comment!}缓存
     */
    public void insert(${table.name?cap_first}CachePO ${table.name}CachePO) {
        kfcRedisTemplate.opsForValue().set(PREFIX + ${table.name}CachePO.getId(), ${table.name}CachePO);
    }

    /**
     * 删除${table.comment!}缓存
     */
    public void delete(Integer id) {
        kfcRedisTemplate.delete(PREFIX + id);
    }

    /**
     * 读取${table.comment!}缓存
     */
    public ${table.name?cap_first}CachePO get(Integer id) {
        return kfcRedisTemplate.get(PREFIX + id, UserCachePO.class);
    }

}
</#if>
