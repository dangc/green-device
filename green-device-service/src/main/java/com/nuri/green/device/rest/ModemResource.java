package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.ModemService;
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
@RequestMapping("/green/v0.1/devices")
@RestController
public class ModemResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final ModemService modemService;

    public ModemResource(ModemService modemService) {
        this.modemService = modemService;
    }

    @ApiOperation(value = "IF-GND-DEVICE-009", notes = "모뎀 상세정보 조회")
    @GetMapping("/modems/{deviceId}")
    public ResponseMessage findById(@PathVariable int deviceId, HttpServletRequest request) {

        ResponseMessage response = null;

        ModemRdo modemRdo = this.modemService.findById(deviceId);
        if (modemRdo != null) {
            response = new ResponseMessage(ResultCode.Y, modemRdo);
        } else {
            String errMsg = "device id [" + deviceId + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-010", notes = "모뎀 목록 조회")
    @GetMapping("/modems")
    public ResponseMessage findAllByCondition(Modem modem, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.modemService.findAllByCondition(modem));
        result.setTotalCnt(this.modemService.count(modem));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-011", notes = "모뎀 등록")
    @PostMapping("/modems")
    public ResponseMessage insert(@RequestBody Modem modem, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.modemService.insert(modem);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-012", notes = "모뎀 수정")
    @PutMapping("/modems")
    public ResponseMessage update(@RequestBody Modem modem, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.modemService.update(modem);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
