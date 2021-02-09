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
}