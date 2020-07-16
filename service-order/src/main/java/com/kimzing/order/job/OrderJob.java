package com.kimzing.order.job;

import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.order.domain.order.OrderQueryDTO;
import com.kimzing.order.domain.order.OrderStatusEnum;
import com.kimzing.order.service.order.OrderService;
import com.kimzing.utils.date.DateUtil;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 订单相关定时任务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/17 02:00
 */
@Slf4j
@Component
public class OrderJob {

    @Resource
    OrderService orderService;

    /**
     * 检查订单状态是否有问题(已经超时未支付，但状态不是cancel)
     * 虽然已经通过消息队列进行了检查，但消息不一定成功，这里做一个检查来再次保障一下，只是为了演示定时任务的功能写法
     * @param param
     * @return
     */
    @XxlJob(value = "checkOrderStatus", init = "init", destroy = "destroy")
    public ReturnT<String> execute(String param) {
        // 需要通过 "XxlJobLogger.log" 打印执行日志
        XxlJobLogger.log("====>开始订单状态检查");
        PageParam pageParam = new PageParam();
        // 为了演示功能，直接查询1000条数据
        pageParam.setPageNum(1);
        pageParam.setPageSize(1000);
        PageResult<OrderBO> orderBOPageResult = orderService.listPage(new OrderQueryDTO(), pageParam);
        orderBOPageResult.getData().forEach(order -> {
            log.info("检查订单:[{}], 创建时间:[{}], 当前状态:[{}]", order.getId(), order.getCreateTime(), order.getStatus());
            if (DateUtil.betweenTwoTime(order.getCreateTime(), LocalDateTime.now(), ChronoUnit.MINUTES) > 30
            && order.getStatus() == OrderStatusEnum.CREATED) {
                log.info("订单[{}]状态异常, 发送告警邮件！", order.getId());
            }
        });
        XxlJobLogger.log("====>结束订单状态检查");
        return ReturnT.SUCCESS;
    }

    public void init() {
        log.info("=========>init");
    }

    public void destroy() {
        log.info("<=========destroy");
    }

}
