package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "DeviceStatus", description = "디바이스 상태정보")
public class DeviceStatus {

    private Integer deviceId;
    private String deviceSerial;
    private String deviceType;
    private String deviceStatus;
    private String serverId;
    private String lastCommDt;
    private String regDt;
    private String updateDt;

    //삭제된 필드로 추정. 확인 필요
    private String lastReadDt;
    private String initCommDt;
    private String lastRegDt;

    @ApiModelProperty(required = false, value = "정렬 ex)orderby=field1:asc,field2:desc")
    private String orderby; // 정렬
    @ApiModelProperty(required = false, value = "pagination offset 번호")
    private Integer offset; // offset
    @ApiModelProperty(required = false, value = "pagination limit 번호")
    private Integer limit; // limit
    @ApiModelProperty(required = false, value = "pagination page 번호")
    private Integer page; // page
}