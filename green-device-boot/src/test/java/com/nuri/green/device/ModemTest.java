package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterRdo;
import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.spec.MeterService;
import com.nuri.green.device.spec.ModemService;
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
public class ModemTest {

    @Autowired
    ModemService modemService;

    @Test
    public void test() {
        ModemRdo modemRdo = modemService.findById(11);

        log.info("modemRdo :: {}", new Gson().toJson(modemRdo));
    }

    @Test
    public void test2() {
        Modem modem = new Modem();
        modem.setDeviceId(11);
        int count = modemService.count(modem);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        Modem modem = new Modem();
        modem.setDeviceId(11);
        List<ModemRdo> lists = modemService.findAllByCondition(modem);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        Modem modem = new Modem();
        modem.setDeviceId(11);
        modem.setNodeKind("NAMR-G100AEW1");
        int result = modemService.update(modem);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        Modem modem = new Modem();
        modem.setDeviceId(55);
        modem.setDeviceSerial("000B120000000108");
        modem.setModemType("DT003");
        modem.setNodeKind("NAMR-G100AEW");
        modem.setModelSeq(2);
        modem.setFwVersion("1.0");
        modem.setFwBuild("1.0");
        modem.setHwVersion("1.0");
        modem.setModemMode("DM001");

        int result = modemService.insert(modem);

        log.info("getDeviceId :: {}", modem.getDeviceId());
    }
}
