package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Modem", description = "모뎀")
public class Modem {

    private Integer deviceId;
    private String deviceSerial;
    private String modemType;
    private String nodeKind;
    private Integer modelSeq;
    private String fwVersion;
    private String fwBuild;
    private String hwVersion;
    private String modemMode;
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
}