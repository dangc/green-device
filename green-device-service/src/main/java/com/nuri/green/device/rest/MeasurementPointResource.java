package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.MeasurementPointService;
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
public class MeasurementPointResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final MeasurementPointService measurementPointService;

    public MeasurementPointResource(MeasurementPointService measurementPointService) {
        this.measurementPointService = measurementPointService;
    }

    @ApiOperation(value = "IF-GND-SP-010", notes = "계측점 상세 조회")
    @GetMapping("/measurement-points/{measurementPointId}")
    public ResponseMessage findById(@PathVariable int measurementPointId, HttpServletRequest request) {

        ResponseMessage response = null;

        MeasurementPointRdo measurementPointRdo = this.measurementPointService.findById(measurementPointId);
        if (measurementPointRdo != null) {
            response = new ResponseMessage(ResultCode.Y, measurementPointRdo);
        } else {
            String errMsg = "measurement point id [" + measurementPointId + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-011", notes = "서비스 포인트 목록 조회")
    @GetMapping("/measurement-points")
    public ResponseMessage findAllByCondition(MeasurementPoint measurementPoint, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.measurementPointService.findAllByCondition(measurementPoint));
        result.setTotalCnt(this.measurementPointService.count(measurementPoint));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-008", notes = "서비스 포인트 등록")
    @PostMapping("/measurement-points")
    public ResponseMessage insert(@RequestBody MeasurementPoint measurementPoint, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.measurementPointService.insert(measurementPoint);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-SP-009", notes = "서비스 포인트 수정")
    @PutMapping("/measurement-points")
    public ResponseMessage update(@RequestBody MeasurementPoint measurementPoint, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.measurementPointService.update(measurementPoint);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
