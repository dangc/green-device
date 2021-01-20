package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Device", description = "디바이스정보")
public class Device {

    private Integer deviceId;
    private String deviceSerial;
    private String locationId;
    private String deviceOid;
    private String commType;
    private String deviceType;
    private String nodeType;
    private String ip;
    private Integer port;
    private String allowYn;
    private String remark;
    private String parentGwId;
    private String regId;
    private String regDt;
    private String destDt;

    @ApiModelProperty(required = false, value = "정렬 ex)orderby=field1:asc,field2:desc")
    private String orderby; // 정렬
    @ApiModelProperty(required = false, value = "pagination offset 번호")
    private Integer offset; // offset
    @ApiModelProperty(required = false, value = "pagination limit 번호")
    private Integer limit; // limit
    @ApiModelProperty(required = false, value = "pagination page 번호")
    private Integer page; // page
}