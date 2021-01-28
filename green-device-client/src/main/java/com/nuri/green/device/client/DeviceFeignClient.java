package com.nuri.green.device.client;

import com.nuri.green.device.entity.Device;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("green-device")
public interface DeviceFeignClient {

    @GetMapping("green/${rest.version}/devices/{deviceId}/")
    String findById(@PathVariable("deviceId") Integer deviceId);

    @GetMapping("green/${rest.version}/devices/")
    String findAllByCondition(@SpringQueryMap Device device);

}
