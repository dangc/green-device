package com.nuri.green.device.client;

import com.nuri.green.device.entity.ModemNms;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("green-device")
public interface ModemNmsFeignClient {

    @PostMapping(value = "green/${rest.version}/devices/modem-nms")
    String insert(ModemNms modemNms);

}
