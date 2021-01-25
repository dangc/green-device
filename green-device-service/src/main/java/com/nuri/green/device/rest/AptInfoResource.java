package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.AptInfo;
import com.nuri.green.device.entity.AptInfoLocation;
import com.nuri.green.device.entity.AptInfoRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.AptInfoService;
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
@RequestMapping("/green/v1.0")
@RestController
public class AptInfoResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final AptInfoService aptInfoService;

    public AptInfoResource(AptInfoService aptInfoService) {
        this.aptInfoService = aptInfoService;
    }

    @ApiOperation(value = "IF-GND-SP-001", notes = "단지정보 상세조회")
    @GetMapping("/apts/{aptNo}")
    public ResponseMessage findById(@PathVariable String aptNo, HttpServletRequest request) {

        ResponseMessage response = null;

        AptInfoRdo aptInfoRdo = this.aptInfoService.findById(aptNo);
        if (aptInfoRdo != null) {
            response = new ResponseMessage(ResultCode.Y, aptInfoRdo);
        } else {
            String errMsg = "apt_no [" + aptNo + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-002", notes = "단지정보 목록 조회")
    @GetMapping("/apts")
    public ResponseMessage findAllByCondition(AptInfo aptInfo, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.aptInfoService.findAllByCondition(aptInfo));
        result.setTotalCnt(this.aptInfoService.count(aptInfo));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-003", notes = "단지별 지역정보 조회")
    @GetMapping("/apts/{aptNo}/locations")
    public ResponseMessage findLocationById(@PathVariable String aptNo, HttpServletRequest request) {

        ResponseMessage response = null;

        AptInfoLocation aptInfoLocation = this.aptInfoService.findLocationById(aptNo);
        if (aptInfoLocation != null) {
            response = new ResponseMessage(ResultCode.Y, aptInfoLocation);
        } else {
            String errMsg = "apt_no [" + aptNo + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-004", notes = "단지정보 등록")
    @PostMapping("/apts")
    public ResponseMessage insert(@RequestBody AptInfo aptInfo, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.aptInfoService.insert(aptInfo);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-SP-005", notes = "단지정보 수정")
    @PutMapping("/apts")
    public ResponseMessage update(@RequestBody AptInfo aptInfo, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.aptInfoService.update(aptInfo);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
