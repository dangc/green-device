package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.DeviceService;
import com.nuri.green.device.spec.GwService;
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
@RequestMapping("/green/${rest.version}/devices")
@RestController
public class GwResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final GwService gwService;

    public GwResource(GwService gwService) {
        this.gwService = gwService;
    }

    @ApiOperation(value = "IF-GND-DEVICE-005", notes = "GW 상세정보 조회")
    @GetMapping("/gws/{deviceId}")
    public ResponseMessage findById(@PathVariable int deviceId, HttpServletRequest request) {

        ResponseMessage response = null;

        GwRdo gwRdo = this.gwService.findById(deviceId);
        if (gwRdo != null) {
            response = new ResponseMessage(ResultCode.Y, gwRdo);
        } else {
            String errMsg = "device id [" + deviceId + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-006", notes = "GW 목록 조회")
    @GetMapping("/gws")
    public ResponseMessage findAllByCondition(Gw gw, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.gwService.findAllByCondition(gw));
        result.setTotalCnt(this.gwService.count(gw));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-007", notes = "GW 등록")
    @PostMapping("/gws")
    public ResponseMessage insert(@RequestBody Gw gw, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.gwService.insert(gw);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-008", notes = "GW 수정")
    @PutMapping("/gws")
    public ResponseMessage update(@RequestBody Gw gw, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.gwService.update(gw);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
