package com.nuri.green.device.rest;

import com.nuri.green.api.response.ResponseMessage;
import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemNms;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.exception.AbstractBaseResource;
import com.nuri.green.device.spec.ModemNmsService;
import com.nuri.green.device.spec.ModemService;
import com.nuri.green.store.page.PagingGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/green/${rest.version}/devices")
@Api(value = "AptInfoResource", tags = "GREEN-DEVICE-SERVICE")
public class ModemNmsResource extends AbstractBaseResource {

    private final ModemNmsService modemNmsService;

    @ApiOperation(value = "IF-GND-DEVICE-011", notes = "모뎀 등록")
    @PostMapping("/modem-nms")
    public ResponseMessage insert(@RequestBody ModemNms modemNms, HttpServletRequest request) {

        int result = this.modemNmsService.insert(modemNms);
        if(result > 0) {
            return new ResponseMessage(ResultCode.Y, null);
        } else {
            return new ResponseMessage(ResultCode.N, ErrorCode.E5000, "insert failed");
        }
    }

}
