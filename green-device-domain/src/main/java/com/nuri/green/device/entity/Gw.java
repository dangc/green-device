package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Gw", description = "게이트웨이정보")
public class Gw {

    private Integer deviceId;
    private String deviceSerial;
    private String sysName;
    private String sysLocation;
    private String sysContact;
    private Integer modelSeq;
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

    @ApiModelProperty(required = false, value = "정렬 ex)orderby=field1:asc,field2:desc")
    private String orderby; // 정렬
    @ApiModelProperty(required = false, value = "pagination offset 번호")
    private Integer offset; // offset
    @ApiModelProperty(required = false, value = "pagination limit 번호")
    private Integer limit; // limit
    @ApiModelProperty(required = false, value = "pagination page 번호")
    private Integer page; // page

    String toJson() {
        return "deviceSerial="+deviceSerial+"&sysName="+sysName;
    }

}