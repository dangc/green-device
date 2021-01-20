package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointRdo;
import com.nuri.green.device.spec.CommPointService;
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
public class CommPointTest {

    @Autowired
    CommPointService commPointService;

    @Test
    public void test() {
        CommPointRdo commPointRdo = commPointService.findById(1);

        log.info("deviceRdo :: {}", new Gson().toJson(commPointRdo));
    }

    @Test
    public void test2() {
        CommPoint commPoint = new CommPoint();
        commPoint.setCommPointId(1);
        int count = commPointService.count(commPoint);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        CommPoint commPoint = new CommPoint();
        commPoint.setCommPointId(1);
        List<CommPointRdo> lists = commPointService.findAllByCondition(commPoint);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        CommPoint commPoint = new CommPoint();
        commPoint.setCommPointId(1);
        commPoint.setServicePointId(1);
        int result = commPointService.update(commPoint);
        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {
        CommPoint commPoint = new CommPoint();
        commPoint.setServicePointId(1);
        commPoint.setDeviceId(1);
        commPoint.setDeviceSerial("1001");
        commPoint.setRegId("system");
        commPoint.setUpdateId("system");
        int result = commPointService.insert(commPoint);
        log.info("result :: {}", result);
    }

}
