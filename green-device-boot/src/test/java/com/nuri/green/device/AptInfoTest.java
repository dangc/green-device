package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.AptInfo;
import com.nuri.green.device.entity.AptInfoLocation;
import com.nuri.green.device.entity.AptInfoRdo;
import com.nuri.green.device.spec.AptInfoService;
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
public class AptInfoTest {

    @Autowired
    AptInfoService aptInfoService;

    @Test
    public void test() {
        AptInfoRdo aptInfoRdo = aptInfoService.findById("A13580204");

        log.info("test : {}", aptInfoRdo.getAptNm());
    }

    @Test
    public void test2() {
        AptInfo aptInfo = new AptInfo();
        aptInfo.setAptNo("A13580204");
        int count = aptInfoService.count(aptInfo);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        AptInfo aptInfo = new AptInfo();
        aptInfo.setAptNo("A13580204");
        List<AptInfoRdo> lists = aptInfoService.findAllByCondition(aptInfo);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        AptInfo aptInfo = new AptInfo();
        aptInfo.setAptNo("A13580204");
        aptInfo.setAptNm("개포주공2단지");
        aptInfo.setUpdateId("system");
        int result = aptInfoService.update(aptInfo);
        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {
        AptInfo aptInfo = new AptInfo();
        aptInfo.setAptNo("100000");
        aptInfo.setAptNm("개포주공12단지");
        aptInfo.setLocationId("1168010300");
        aptInfo.setRegId("system");
        aptInfo.setUpdateId("system");
        int result = aptInfoService.insert(aptInfo);
        log.info("result :: {}", result);
    }

    @Test
    public void test6() {

        AptInfoLocation result = aptInfoService.findLocationById("A13580204");
        log.info("result :: {}", new Gson().toJson(result));
    }
}
