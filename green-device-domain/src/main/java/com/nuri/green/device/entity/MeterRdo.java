package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "MeterRdo", description = "미터정보")
public class MeterRdo {
    private Integer meterId;
    private String meterSerial;
    private Integer deviceId;
    private String deviceSerial;
    private String deviceType;
    private String deviceTypeNm;
    private String meterType;
    private String meterTypeNm;
    private String energyType;
    private String energyTypeNm;
    private String meterPhase;
    private String meterPhaseNm;
    private Integer modelSeq;
    private String modelNm;
    private String ip;
    private int port;
    private String cosemDeviceName;
    private String progId;
    private String progVersion;
    private int acon;
    private int rcon;
    private int pcon;
    private String billingDay;
    private int lpInterval;
    private int avgVolCurInterval;
    private int instVolCurInterval;
    private int netMetering;
    private String locationId;
    private String locationNm;
    private String mtime;
    private String itime;
    private String installDt;
    private String regDt;
    private String destDt;
    private String mfgDt;
}