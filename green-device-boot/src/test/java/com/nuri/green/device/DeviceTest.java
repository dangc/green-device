package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.spec.DeviceService;
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
public class DeviceTest {

    @Autowired
    DeviceService deviceService;

    @Test
    public void test() {
        DeviceRdo deviceRdo = deviceService.findById(1);

        log.info("deviceRdo :: {}", new Gson().toJson(deviceRdo));
    }

    @Test
    public void test2() {
        Device device = new Device();
        device.setDeviceSerial("1001");
        int count = deviceService.count(device);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        Device device = new Device();
        device.setDeviceSerial("1001");
        List<DeviceRdo> lists = deviceService.findAllByCondition(device);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        Device device = new Device();
        device.setDeviceId(1);
        device.setIp("127.0.0.1");
        int result = deviceService.update(device);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        Device device = new Device();
        device.setDeviceSerial("test");
        device.setIp("127.0.0.1");
        device.setLocationId("1159010600");
        device.setCommType("CT001");
        device.setNodeType("NT001");

        int result = deviceService.insert(device);

        log.info("deviceId :: {}", device.getDeviceId());
    }
}
