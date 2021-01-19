package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "AptInfoLocation", description = "단지의 지역정보")
public class AptInfoLocation {

    private String aptNo;
    private String aptNm;
    private String locationId;
    private String locationIdNm;
    private String regionId;
}
