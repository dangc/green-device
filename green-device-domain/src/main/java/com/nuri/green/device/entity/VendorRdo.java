package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "VendorRdo", description = "제조사정보")
public class VendorRdo {

    private Integer vendorSeq;
    private String vendorCode;
    private String vendorNm;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;
}