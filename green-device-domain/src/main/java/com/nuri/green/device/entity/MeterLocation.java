package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "MeterLocation", description = "미터지역정보")
public class MeterLocation {

    private Integer meterId;
    private String meterSerial;
    private String locationId;
    private String locationNm;
    private String regionId;
}
