package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.DeviceService;
import com.nuri.green.page.PagingGridResult;
import com.nuri.green.response.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(value = "AptInfoResource", tags = "GREEN-DEVICE-SERVICE")
@CrossOrigin("*")
@RequestMapping("/green/v0.1")
@RestController
public class DeviceResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final DeviceService deviceService;

    public DeviceResource(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @ApiOperation(value = "IF-GND-DEVICE-001", notes = "디바이스 상세정보 조회")
    @GetMapping("/devices/{deviceId}")
    public ResponseMessage findById(@PathVariable int deviceId, HttpServletRequest request) {

        ResponseMessage response = null;

        DeviceRdo deviceRdo = this.deviceService.findById(deviceId);
        if (deviceRdo != null) {
            response = new ResponseMessage(ResultCode.Y, deviceRdo);
        } else {
            String errMsg = "device id [" + deviceId + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-002", notes = "디바이스 목록 조회")
    @GetMapping("/devices")
    public ResponseMessage findAllByCondition(Device device, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.deviceService.findAllByCondition(device));
        result.setTotalCnt(this.deviceService.count(device));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-003", notes = "디바이스 등록")
    @PostMapping("/devices")
    public ResponseMessage insert(@RequestBody Device device, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.deviceService.insert(device);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-004", notes = "디바이스 수정")
    @PutMapping("/devices")
    public ResponseMessage update(@RequestBody Device device, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.deviceService.update(device);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-017", notes = "디바이스 지역 코드")
    @GetMapping("/devices/{deviceId}/locations")
    public ResponseMessage locations(@PathVariable int deviceId, HttpServletRequest request) {
        return null;
    }

    @ApiOperation(value = "IF-GND-DEVICE-027", notes = "디바이스 상태 조회")
    @GetMapping("/devices/{deviceId}/status")
    public ResponseMessage status(@PathVariable int deviceId, HttpServletRequest request) {
        return null;
    }
}
