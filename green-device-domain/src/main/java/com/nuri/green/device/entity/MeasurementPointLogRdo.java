package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "MeasurementPointLogRdo", description = "계측점 로그")
public class MeasurementPointLogRdo {

    private Integer measurementPointId;
    private Integer seqNo;
    private Integer chgDt;
    private Integer servicePointId;
    private Integer meterId;
    private String meterSerial;
    private String aptNo;
    private String dong;
    private String ho;
    private String remark;
    private String regId;
    private String regDt;
}
