package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "MeasurementPointRdo", description = "계측점")
public class MeasurementPointRdo {

    private Integer mesurementPointId;
    private Integer servicePointId;
    private String servicePointNm;
    private Integer meterId;
    private String meterSerial;
    private String aptNo;
    private String aptNm;
    private String locationId;
    private String locationNm;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;
}
