package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "DeviceModelRdo", description = "디바이스모델 조회정보")
public class DeviceModelRdo {

    private Integer modelSeq;
    private String modelNm;
    private String deviceType;
    private String deviceTypeNm;
    private Integer vendorSeq;
    private String vendorNm;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;

    @ApiModelProperty(required = false, value = "정렬 ex)orderby=field1:asc,field2:desc")
    private String orderby; // 정렬
    @ApiModelProperty(required = false, value = "pagination offset 번호")
    private Integer offset; // offset
    @ApiModelProperty(required = false, value = "pagination limit 번호")
    private Integer limit; // limit
    @ApiModelProperty(required = false, value = "pagination page 번호")
    private Integer page; // page
}