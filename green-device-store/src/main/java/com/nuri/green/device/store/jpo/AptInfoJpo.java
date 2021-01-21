package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.AptInfo;
import com.nuri.green.device.entity.AptInfoLocation;
import com.nuri.green.device.entity.AptInfoRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("aptInfoJpo")
public class AptInfoJpo extends CommonObj {

    private String aptNo;
    private String aptNm;
    private String buildingType;
    private String buildingTypeNm;
    private String aptType;
    private String locationId;
    private String locationIdNm;
    private String regionId;
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

    public AptInfoJpo(AptInfo aptInfo) {
        if(aptInfo != null) {
            BeanUtils.copyProperties(aptInfo, this);
        }

        // page
        if(aptInfo.getOffset() != null && aptInfo.getLimit() != null) {
            setPage(aptInfo.getOffset(), aptInfo.getLimit());
        }

        // order
        if(aptInfo.getOrderby() != null) {
            setOrder(aptInfo.getOrderby());
        }
    }

    public AptInfoRdo toDomain() {
        AptInfoRdo aptInfoRdo = new AptInfoRdo();
        BeanUtils.copyProperties(this, aptInfoRdo);
        return aptInfoRdo;
    }

    public AptInfoLocation toLocationDomain() {
        AptInfoLocation aptInfoLocation = new AptInfoLocation();
        BeanUtils.copyProperties(this, aptInfoLocation);
        return aptInfoLocation;
    }
}
