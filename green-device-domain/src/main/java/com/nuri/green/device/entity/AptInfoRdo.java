package com.nuri.green.device.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "AptInfoRdo", description = "단지정보 조회 모델")
public class AptInfoRdo {

    private String aptNo;
    private String aptNm;
    private String buildingType;
    private String buildingTypeNm;
    private String aptType;
    private String locationId;
    private String locationIdNm;
    private String zipcode;
    private String jibunAddr;
    private String roadAddr;
    private Integer dongCnt;
    private Integer hoCnt;
    private String telNo;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;
}
