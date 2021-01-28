package com.nuri.green.device.client;

import com.nuri.green.device.entity.Modem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("green-device")
public interface ModemFeignClient {

    @GetMapping("green/${rest.version}/devices/modems/{deviceId}/")
    String findById(@PathVariable("deviceId") Integer meterId);

    @GetMapping("green/${rest.version}/devices/modems")
    String findAllByCondition(@SpringQueryMap Modem modem);

    @PostMapping(value = "green/${rest.version}/devices/modems")
    String insert(Modem modem);

    @PutMapping(value = "green/${rest.version}/devices/modems")
    String update(Modem modem);

}
