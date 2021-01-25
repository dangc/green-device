package com.nuri.green.device.rest;

import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.CommPointService;
import com.nuri.green.store.page.PagingGridResult;
import com.nuri.green.api.response.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(value = "CommPointResource", tags = "GREEN-DEVICE-SERVICE")
@CrossOrigin("*")
@RequestMapping("/green/v1.0")
@RestController
public class CommPointResource extends AbstractBaseResource {

    // TODO - ERROR 코드 변경

    private final CommPointService commPointService;

    public CommPointResource(CommPointService commPointService) {
        this.commPointService = commPointService;
    }

    @ApiOperation(value = "IF-GND-SP-014", notes = "통신서비스 상세 조회")
    @GetMapping("/comm-points/{commPointId}")
    public ResponseMessage findById(@PathVariable int commPointId, HttpServletRequest request) {

        ResponseMessage response = null;

        CommPointRdo commPointRdo = this.commPointService.findById(commPointId);
        if (commPointRdo != null) {
            response = new ResponseMessage(ResultCode.Y, commPointRdo);
        } else {
            String errMsg = "comm point [" + commPointId + "] does not exist.";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-015", notes = "통신서비스 목록")
    @GetMapping("/comm-points")
    public ResponseMessage findAllByCondition(CommPoint commPoint, HttpServletRequest request) {

        ResponseMessage response = null;

        PagingGridResult result = new PagingGridResult();
        result.setDatas(this.commPointService.findAllByCondition(commPoint));
        result.setTotalCnt(this.commPointService.count(commPoint));

        if (result != null) {
            response = new ResponseMessage(ResultCode.Y, result);
        } else {
            String errMsg = ErrorCode.E2001.getMsg();
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }

        return response;
    }

    @ApiOperation(value = "IF-GND-SP-016", notes = "통신서비스 등록")
    @PostMapping("/comm-points")
    public ResponseMessage insert(@RequestBody CommPoint commPoint, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.commPointService.insert(commPoint);
        if(result > 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        } else {
            String errMsg = "insert failed";
            response = new ResponseMessage(ResultCode.N, ErrorCode.E2001, errMsg);
        }
        return response;
    }

    @ApiOperation(value = "IF-GND-SP-017", notes = "통신서비스 수정")
    @PutMapping("/comm-points")
    public ResponseMessage update(@RequestBody CommPoint commPoint, HttpServletRequest request) {

        ResponseMessage response = null;
        int result = this.commPointService.update(commPoint);
        if(result >= 0) {
            response = new ResponseMessage(ResultCode.Y, null);
        }
        return response;
    }
}
