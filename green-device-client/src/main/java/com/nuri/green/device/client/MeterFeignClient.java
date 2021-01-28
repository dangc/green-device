package com.nuri.green.device.client;

import com.nuri.green.device.entity.Meter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("green-device")
public interface MeterFeignClient {

    @GetMapping("green/${rest.version}/devices/meters/{deviceId}/")
    String findById(@PathVariable("deviceId") Integer meterId);

    @GetMapping("green/${rest.version}/devices/meters")
    String findAllByCondition(@SpringQueryMap Meter meter);

    @PostMapping(value = "green/${rest.version}/devices/meters")
    String insert(Meter meter);

    @PutMapping(value = "green/${rest.version}/devices/meters")
    String update(Meter meter);

    // TODO 필요한 API추가

}
