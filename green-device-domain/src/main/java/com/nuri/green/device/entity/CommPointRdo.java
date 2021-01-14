package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "CommPointRdo", description = "통신포인트")
public class CommPointRdo {

    private Integer commPointId;
    private Integer servicePointId;
    private String servicePointNm;
    private Integer deviceId;
    private String deviceSerial;
    private String aptNo;
    private String aptNm;
    private String dong;
    private String ho;
    private String locationId;
    private String locationNm;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;
}
