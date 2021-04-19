package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "MeterStatusRdo", description = "미터 상태정보")
public class MeterStatusRdo {

    private Integer meterId;
    private String meterSerial;
    private String meterType;
    private String meterTypeNm;
    private String meterStatus;
    private String meterStatusNm;
    private String lastReadDt;
    private String serverId;
    private String regDt;
    private String updateDt;

}