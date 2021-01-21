package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.DeviceModelService;
import com.nuri.green.device.spec.DeviceService;
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
public class DeviceModelResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final DeviceModelService deviceModelService;

    public DeviceModelResource(DeviceModelService deviceModelService) {
        this.deviceModelService = deviceModelService;
    }

    @ApiOperation(value = "IF-GND-DEVICE-019", notes = "디바이스 모델 조회")
    @GetMapping("/models/{modelSeq}")
    public ResponseMessage findById(@PathVariable int modelSeq, HttpServletRequest request) {

        ResponseMessage response = null;

        DeviceModelRdo deviceModelRdo = this.deviceModelService.findById(modelSeq);
        if (deviceModelRdo != null) {
            response = new ResponseMessage(ResultCode.Y, deviceModelRdo);
        } else {
            String errMsg = "model seq [" + modelSeq + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-020", notes = "디바이스 모델 목록")
    @GetMapping("/models")
    public ResponseMessage findAllByCondition(DeviceModel deviceModel, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.deviceModelService.findAllByCondition(deviceModel));
        result.setTotalCnt(this.deviceModelService.count(deviceModel));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-021", notes = "디바이스 모델 등록")
    @PostMapping("/models")
    public ResponseMessage insert(@RequestBody DeviceModel deviceModel, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.deviceModelService.insert(deviceModel);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-022", notes = "디바이스 모델 수정")
    @PutMapping("/models")
    public ResponseMessage update(@RequestBody DeviceModel deviceModel, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.deviceModelService.update(deviceModel);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
