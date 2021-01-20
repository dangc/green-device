package com.nuri.green.device;

import com.google.gson.Gson;
import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.entity.Vendor;
import com.nuri.green.device.entity.VendorRdo;
import com.nuri.green.device.spec.ModemService;
import com.nuri.green.device.spec.VendorService;
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
public class VendorTest {

    @Autowired
    VendorService vendorService;

    @Test
    public void test() {
        VendorRdo vendorRdo = vendorService.findById(1);

        log.info("vendorRdo :: {}", new Gson().toJson(vendorRdo));
    }

    @Test
    public void test2() {
        Vendor vendor = new Vendor();
        vendor.setVendorSeq(1);
        int count = vendorService.count(vendor);

        log.info("count :: {}", count);
    }

    @Test
    public void test3() {
        Vendor vendor = new Vendor();
        vendor.setVendorSeq(1);
        List<VendorRdo> lists = vendorService.findAllByCondition(vendor);

        log.info("lists :: {}", new Gson().toJson(lists));
    }

    @Test
    public void test4() {
        Vendor vendor = new Vendor();
        vendor.setVendorSeq(1);
        vendor.setVendorNm("한전KDN");
        int result = vendorService.update(vendor);

        log.info("result :: {}", result);
    }

//    @Test
    public void test5() {

        Vendor vendor = new Vendor();
        vendor.setVendorCode("9999");
        vendor.setVendorNm("test");
        vendor.setRemark("test");
        vendor.setRegId("system");
        vendor.setUpdateId("system");

        int result = vendorService.insert(vendor);

        log.info("getVendorSeq :: {}", vendor.getVendorSeq());
    }
}
