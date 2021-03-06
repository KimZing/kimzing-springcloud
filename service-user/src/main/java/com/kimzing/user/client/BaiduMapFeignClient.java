package com.kimzing.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 百度地图客户端.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:53
 */
@FeignClient(name = "baidu", url = "${baidu.map.url}")
public interface BaiduMapFeignClient {

    /**
     * 模拟根据经纬度查询所处的区域ID
     * @param longitude
     * @param latitude
     * @return
     */
    @GetMapping("/area/{longitude}/{latitude}")
    Integer getAreaIdByLongitudeAndLatitude(@PathVariable("longitude") String longitude, @PathVariable("latitude") String latitude);

}
