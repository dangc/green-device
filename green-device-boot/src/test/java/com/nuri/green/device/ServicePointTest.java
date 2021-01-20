package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;
import com.nuri.green.device.spec.ModemService;
import com.nuri.green.device.spec.ServicePointService;
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
public class ServicePointTest {

    @Autowired
    ServicePointService servicePointService;

    @Test
    public void test() {
        ServicePointRdo servicePointRdo = servicePointService.findById(11);

        log.info("servicePointRdo :: {}", new Gson().toJson(servicePointRdo));
    }

    @Test
    public void test2() {
        ServicePoint servicePoint = new ServicePoint();
        servicePoint.setServicePointId(1);
        int count = servicePointService.count(servicePoint);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        ServicePoint servicePoint = new ServicePoint();
        servicePoint.setServicePointId(1);
        List<ServicePointRdo> lists = servicePointService.findAllByCondition(servicePoint);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        ServicePoint servicePoint = new ServicePoint();
        servicePoint.setServicePointId(1);
        servicePoint.setDong("72011");
        int result = servicePointService.update(servicePoint);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        ServicePoint servicePoint = new ServicePoint();
        servicePoint.setServicePointNm("test");
        servicePoint.setServicePointType("AF001");
        servicePoint.setAptNo("A15608002");
        servicePoint.setDong("1");
        servicePoint.setHo("2");
        servicePoint.setRemark("test");
        servicePoint.setRegId("system");
        servicePoint.setUpdateId("system");

        int result = servicePointService.insert(servicePoint);

        log.info("getDeviceId :: {}", servicePoint.getServicePointId());
    }
}
