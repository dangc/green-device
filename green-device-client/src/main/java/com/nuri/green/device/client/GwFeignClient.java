package com.nuri.green.device.client;

import com.nuri.green.device.entity.Gw;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("green-device")
public interface GwFeignClient {

    @GetMapping("green/${rest.version}/devices/gws/{deviceId}/")
    String findById(@PathVariable("deviceId") Integer deviceId);

    @GetMapping("green/${rest.version}/devices/gws")
    String findAllByCondition(@SpringQueryMap Gw gw);

    @PostMapping(value = "green/${rest.version}/devices/gws")
    String insert(Gw gw);

    @PutMapping(value = "green/${rest.version}/devices/gws")
    String update(Gw gw);

}
