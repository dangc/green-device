package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;
import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterRdo;
import com.nuri.green.device.spec.GwService;
import com.nuri.green.device.spec.MeterService;
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
public class MeterTest {

    @Autowired
    MeterService meterService;

    @Test
    public void test() {
        MeterRdo meterRdo = meterService.findById(1);

        log.info("meterRdo :: {}", new Gson().toJson(meterRdo));
    }

    @Test
    public void test2() {
        Meter meter = new Meter();
        meter.setMeterId(1);
        int count = meterService.count(meter);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        Meter meter = new Meter();
        meter.setMeterId(1);
        List<MeterRdo> lists = meterService.findAllByCondition(meter);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        Meter meter = new Meter();
        meter.setMeterId(1);
        meter.setMeterSerial("6970631400020506");
        int result = meterService.update(meter);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        Meter meter = new Meter();
        meter.setMeterSerial("111111111111");
        meter.setDeviceId(11);
        meter.setMeterType("MT001");
        meter.setEnergyType("ME001");
        meter.setMeterPhase("MP001");

        int result = meterService.insert(meter);

        log.info("getMeterId :: {}", meter.getMeterId());
    }
}
