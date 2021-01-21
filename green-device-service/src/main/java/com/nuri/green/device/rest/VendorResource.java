package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;
import com.nuri.green.device.entity.Vendor;
import com.nuri.green.device.entity.VendorRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.DeviceModelService;
import com.nuri.green.device.spec.VendorService;
import com.nuri.green.store.page.PagingGridResult;
import com.nuri.green.api.response.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(value = "AptInfoResource", tags = "GREEN-DEVICE-SERVICE")
@CrossOrigin("*")
@RequestMapping("/green/v0.1/devices")
@RestController
public class VendorResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final VendorService vendorService;

    public VendorResource(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "IF-GND-DEVICE-023", notes = "제조사 정보 조회")
    @GetMapping("/vendors/{vendorSeq}")
    public ResponseMessage findById(@PathVariable int vendorSeq, HttpServletRequest request) {

        ResponseMessage response = null;

        VendorRdo vendorRdo = this.vendorService.findById(vendorSeq);
        if (vendorRdo != null) {
            response = new ResponseMessage(ResultCode.Y, vendorRdo);
        } else {
            String errMsg = "vendor seq [" + vendorSeq + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-024", notes = "제조사 목록")
    @GetMapping("/vendors")
    public ResponseMessage findAllByCondition(Vendor vendor, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.vendorService.findAllByCondition(vendor));
        result.setTotalCnt(this.vendorService.count(vendor));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-025", notes = "제조사 등록")
    @PostMapping("/vendors")
    public ResponseMessage insert(@RequestBody Vendor vendor, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.vendorService.insert(vendor);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-026", notes = "제조사 수정")
    @PutMapping("/vendors")
    public ResponseMessage update(@RequestBody Vendor vendor, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.vendorService.update(vendor);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
