package com.kimzing.user.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;

/**
 * MybatisPlus分页辅助工具.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/5 02:20
 */
public class PageUtil {

    /**
     * 将项目中的分页转换为MybatisPlus分页
     * @param pageParam
     * @param <T>
     * @return
     */
    public static <T> Page<T> convertPage(PageParam pageParam) {
        return new Page<>(pageParam.getPageNum(), pageParam.getPageSize(), true);
    }

    public static <T> PageResult<T> convertPageResult(IPage<T> iPage) {
        return new PageResult<T>(iPage.getTotal(), (int)iPage.getCurrent(), (int)iPage.getSize(), iPage.getRecords());
    }

}
