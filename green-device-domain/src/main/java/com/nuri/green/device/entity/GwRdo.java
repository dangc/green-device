package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "GwRdo", description = "게이트웨이정보 조회정보")
public class GwRdo {

    private String deviceId;
    private String deviceSerial;
    private String sysName;
    private String sysLocation;
    private String sysContact;
    private String modelSeq;
    private String modelNm;
    private String sysHwVersion;
    private String sysHwBuild;
    private String sysSwVersion;
    private String sysSwRevision;
    private String sysPort;
    private String ntwType;
    private String ntwAppName;
    private String ntwState;
    private String ntwGateway;
    private String ntwEthIp;
    private String ntwEthSubnetMask;
    private String ntwEthPhy;
    private String ntwPppIp;
    private String ntwPppSubnetMask;
    private String mobileNo;
    private String regDt;
    private String updateDt;
}