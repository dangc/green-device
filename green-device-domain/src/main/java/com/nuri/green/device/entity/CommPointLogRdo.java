package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "CommPointLogRdo", description = "통신서비스 로그")
public class CommPointLogRdo {

    private Integer commPointId;
    private Integer seqNo;
    private Integer chgDt;
    private Integer servicePointId;
    private Integer deviceId;
    private String deviceSerial;
    private String aptNo;
    private String dong;
    private String ho;
    private String remark;
    private String regId;
    private String regDt;
}
