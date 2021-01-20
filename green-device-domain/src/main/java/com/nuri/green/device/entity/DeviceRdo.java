package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "DeviceRdo", description = "디바이스정보 조회 모델")
public class DeviceRdo {

    private Integer deviceId;
    private String deviceSerial;
    private String locationId;
    private String locationNm;
    private String deviceOid;
    private String commType;
    private String commTypeNm;
    private String deviceType;
    private String deviceTypeNm;
    private String nodeType;
    private String nodeTypeNm;
    private String ip;
    private Integer port;
    private String allowYn;
    private String remark;
    private String parentGwId;
    private String aptNo;
    private String aptNm;
    private String regId;
    private String regDt;
    private String destDt;
}