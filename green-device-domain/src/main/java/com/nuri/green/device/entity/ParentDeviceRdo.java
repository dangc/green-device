package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "ParentDevice", description = "상위 디바이스정보")
public class ParentDeviceRdo {

    private Integer deviceId;
    private String deviceSerial;
}