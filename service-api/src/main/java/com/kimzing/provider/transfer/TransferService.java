package com.kimzing.provider.transfer;

import java.math.BigDecimal;

/**
 * 转账服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:25
 */
public interface TransferService {

    void transfer(Integer userId, BigDecimal changeAmount);

}
