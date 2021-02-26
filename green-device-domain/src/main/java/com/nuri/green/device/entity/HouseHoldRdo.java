package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "HouseHoldRdo", description = "전입전출")
public class HouseHoldRdo {

    private Integer servicePointId;
    private Integer moveSeq;
    private String moveInDate;
    private String moveOutDate;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;
}
