package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "DeviceLocation", description = "디바이스 지역정보")
public class DeviceLocation {

    private Integer deviceId;
    private String deviceSerial;
    private String locationId;
    private String locationNm;
    private String regionId;
}