package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterLocation;
import com.nuri.green.device.entity.MeterRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.MeterService;
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
public class MeterResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final MeterService meterService;

    public MeterResource(MeterService meterService) {
        this.meterService = meterService;
    }

    @ApiOperation(value = "IF-GND-DEVICE-013", notes = "미터 상세정보 조회")
    @GetMapping("/meters/{meterId}")
    public ResponseMessage findById(@PathVariable int meterId, HttpServletRequest request) {

        ResponseMessage response = null;

        MeterRdo meterRdo = this.meterService.findById(meterId);
        if (meterRdo != null) {
            response = new ResponseMessage(ResultCode.Y, meterRdo);
        } else {
            String errMsg = "meter id [" + meterId + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-014", notes = "미터 목록 조회")
    @GetMapping("/meters")
    public ResponseMessage findAllByCondition(Meter meter, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.meterService.findAllByCondition(meter));
        result.setTotalCnt(this.meterService.count(meter));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-015", notes = "미터 등록")
    @PostMapping("/meters")
    public ResponseMessage insert(@RequestBody Meter meter, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.meterService.insert(meter);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E5000, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-016", notes = "미터 수정")
    @PutMapping("/meters")
    public ResponseMessage update(@RequestBody Meter meter, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.meterService.update(meter);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-DEVICE-018", notes = "미터별 지역코드 + Region 조회")
    @GetMapping("/meters/{meterId}/locations")
    public ResponseMessage locations(@PathVariable int meterId, HttpServletRequest request) {

        ResponseMessage response = null;
        MeterLocation meterLocation = this.meterService.findByLocation(meterId);

        if (meterLocation != null) {
            response = new ResponseMessage(ResultCode.Y, meterLocation);
        }

        return response;
    }
}
