package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.device.spec.MeasurementPointService;
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
public class MeasurementPointTest {

    @Autowired
    MeasurementPointService measurementPointService;

    @Test
    public void test() {
        MeasurementPointRdo measurementPointRdo = measurementPointService.findById(1);
        log.info("MeasurementPointRdo :: {}", new Gson().toJson(measurementPointRdo));
    }

    @Test
    public void test2() {
        MeasurementPoint measurementPoint = new MeasurementPoint();
        measurementPoint.setMeasurementPointId(1);
        int count = measurementPointService.count(measurementPoint);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        MeasurementPoint measurementPoint = new MeasurementPoint();
        measurementPoint.setMeasurementPointId(1);
        List<MeasurementPointRdo> lists = measurementPointService.findAllByCondition(measurementPoint);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        MeasurementPoint measurementPoint = new MeasurementPoint();
        measurementPoint.setMeasurementPointId(1);
        measurementPoint.setMeterId(1);
        int result = measurementPointService.update(measurementPoint);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        MeasurementPoint measurementPoint = new MeasurementPoint();
        measurementPoint.setServicePointId(51);
        measurementPoint.setMeterId(50);
        measurementPoint.setMeterSerial("1234");

        int result = measurementPointService.insert(measurementPoint);

        log.info("getMesurementPointId :: {}", measurementPoint.getMeasurementPointId());
    }
}
