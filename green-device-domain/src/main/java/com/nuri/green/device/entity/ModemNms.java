package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "ModemNms", description = "모뎀 NMS")
public class ModemNms {

    private Integer deviceId;
    private String nmsDt;
    private String deviceSerial;
    private String parentDeviceId;
    private String parentDeviceSerial;
    private Integer networkChannel;
    private String networkKey;
    private Integer rssi;
    private Integer lqi;
    private Integer etx;
    private Integer hopCount;
    private String networkConnectionTime;
    private Integer txPower;
    private String regDt;

    @ApiModelProperty(required = false, value = "정렬 ex)orderby=field1:asc,field2:desc")
    private String orderby; // 정렬
    @ApiModelProperty(required = false, value = "pagination offset 번호")
    private Integer offset; // offset
    @ApiModelProperty(required = false, value = "pagination limit 번호")
    private Integer limit; // limit
    @ApiModelProperty(required = false, value = "pagination page 번호")
    private Integer page; // page
}