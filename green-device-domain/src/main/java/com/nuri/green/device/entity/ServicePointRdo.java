package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "ServicePointRdo", description = "서비스포인트")
public class ServicePointRdo {

    private Integer servicePointId;
    private String servicePointNm;
    private String servicePointType;
    private String servicePointTypeNm;
    private String aptNo;
    private String aptNm;
    private String dong;
    private String ho;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;
}
