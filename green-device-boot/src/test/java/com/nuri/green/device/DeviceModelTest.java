package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.spec.DeviceModelService;
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
public class DeviceModelTest {

    @Autowired
    DeviceModelService deviceModelService;

    @Test
    public void test() {
        DeviceModelRdo deviceModelRdo = deviceModelService.findById(1);

        log.info("deviceModelRdo :: {}", new Gson().toJson(deviceModelRdo));
    }

    @Test
    public void test2() {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setModelSeq(1);
        int count = deviceModelService.count(deviceModel);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setModelSeq(1);
        List<DeviceModelRdo> lists = deviceModelService.findAllByCondition(deviceModel);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setModelSeq(1);
        deviceModel.setVendorSeq(3);
        int result = deviceModelService.update(deviceModel);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setModelNm("LS1410DR");
        deviceModel.setDeviceType("DT005");

        int result = deviceModelService.insert(deviceModel);

        log.info("getModelSeq :: {}", deviceModel.getModelSeq());
    }
}
