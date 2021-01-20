package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;
import com.nuri.green.device.spec.DeviceService;
import com.nuri.green.device.spec.GwService;
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
public class GwTest {

    @Autowired
    GwService gwService;

    @Test
    public void test() {
        GwRdo gwRdo = gwService.findById(1);

        log.info("gwRdo :: {}", new Gson().toJson(gwRdo));
    }

    @Test
    public void test2() {
        Gw gw = new Gw();
        gw.setDeviceId(1);
        int count = gwService.count(gw);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        Gw gw = new Gw();
        gw.setDeviceId(1);
        List<GwRdo> lists = gwService.findAllByCondition(gw);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        Gw gw = new Gw();
        gw.setDeviceId(1);
        gw.setModelSeq(2);
        int result = gwService.update(gw);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        Gw gw = new Gw();
        gw.setDeviceId(11);
        gw.setDeviceSerial("1011");


        int result = gwService.insert(gw);

        log.info("deviceId :: {}", gw.getDeviceId());
    }
}
