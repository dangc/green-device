package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;
import com.nuri.green.device.spec.DeviceService;
import com.nuri.green.device.spec.DeviceStatusService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceStatusTest {

    @Autowired
    DeviceStatusService deviceStatusService;

    @Test
    public void test() {
        DeviceStatusRdo deviceStatusRdo = deviceStatusService.findById(1);

        log.info("deviceStatusRdo :: {}", new Gson().toJson(deviceStatusRdo));
    }

    @Test
    public void test2() {
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setDeviceId(1);
        int count = deviceStatusService.count(deviceStatus);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setDeviceId(1);
        List<DeviceStatusRdo> lists = deviceStatusService.findAllByCondition(deviceStatus);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setDeviceId(1);
        deviceStatus.setDeviceStatus("DS001");
        int result = deviceStatusService.update(deviceStatus);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setDeviceId(1);
        deviceStatus.setDeviceStatus("DS001");
        deviceStatus.setInitCommDt("20210120000000");
        deviceStatus.setServerId("LWM2M");
        int result = deviceStatusService.insert(deviceStatus);

        log.info("deviceId :: {}", deviceStatus.getDeviceId());
    }
}
