package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.*;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.AptInfoService;
import com.nuri.green.device.spec.ServicePointService;
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
public class ServicePointResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final ServicePointService servicePointService;

    public ServicePointResource(ServicePointService servicePointService) {
        this.servicePointService = servicePointService;
    }

    @ApiOperation(value = "IF-GND-SP-006", notes = "서비스 포인트 상세정보 조회")
    @GetMapping("/service-points/{servicePointId}")
    public ResponseMessage findById(@PathVariable int servicePointId, HttpServletRequest request) {

        ResponseMessage response = null;

        ServicePointRdo servicePointRdo = this.servicePointService.findById(servicePointId);
        if (servicePointRdo != null) {
            response = new ResponseMessage(ResultCode.Y, servicePointRdo);
        } else {
            String errMsg = "service point id [" + servicePointId + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-007", notes = "서비스 포인트 목록 조회")
    @GetMapping("/service-points")
    public ResponseMessage findAllByCondition(ServicePoint servicePoint, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.servicePointService.findAllByCondition(servicePoint));
        result.setTotalCnt(this.servicePointService.count(servicePoint));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-008", notes = "서비스 포인트 등록")
    @PostMapping("/service-points")
    public ResponseMessage insert(@RequestBody ServicePoint servicePoint, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.servicePointService.insert(servicePoint);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-SP-009", notes = "서비스 포인트 수정")
    @PutMapping("/service-points")
    public ResponseMessage update(@RequestBody ServicePoint servicePoint, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.servicePointService.update(servicePoint);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
