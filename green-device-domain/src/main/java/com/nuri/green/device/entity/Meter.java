package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Meter", description = "미터정보")
public class Meter {

    private Integer meterId;
    private String meterSerial;
    private Integer deviceId;
    private String meterType;
    private String energyType;
    private String meterPhase;
    private Integer modelSeq;
    private String ip;
    private Integer port;
    private String cosemDeviceName;
    private String progId;
    private String progVersion;
    private Integer acon;
    private Integer rcon;
    private Integer pcon;
    private String billingDay;
    private Integer lpInterval;
    private Integer avgVolCurInterval;
    private Integer instVolCurInterval;
    private Integer netMetering;
    private String locationId;
    private String mtime;
    private String itime;
    private String installDt;
    private String regDt;
    private String destDt;
    private String mfgDt;
    private Integer drUploadInterval;
    private Integer drMeterReadingInterval;

    @ApiModelProperty(required = false, value = "정렬 ex)orderby=field1:asc,field2:desc")
    private String orderby; // 정렬
    @ApiModelProperty(required = false, value = "pagination offset 번호")
    private Integer offset; // offset
    @ApiModelProperty(required = false, value = "pagination limit 번호")
    private Integer limit; // limit
    @ApiModelProperty(required = false, value = "pagination page 번호")
    private Integer page; // page
}
