package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("commPointJpo")
public class CommPointJpo extends CommonObj {

    private Integer commPointId;
    private Integer servicePointId;
    private String servicePointNm;
    private Integer deviceId;
    private String deviceSerial;
    private String aptNo;
    private String aptNm;
    private String dong;
    private String ho;
    private String locationId;
    private String locationNm;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;

    public CommPointJpo(CommPoint commPoint) {
        if(commPoint != null) {
            BeanUtils.copyProperties(commPoint, this);
        }

        // page
        if(commPoint.getOffset() != null && commPoint.getLimit() != null) {
            setPage(commPoint.getOffset(), commPoint.getLimit());
        }

        // order
        if(commPoint.getOrderby() != null) {
            setOrder(commPoint.getOrderby());
        }
    }

    public CommPointRdo toDomain() {
        CommPointRdo commPointRdo = new CommPointRdo();
        BeanUtils.copyProperties(this, commPointRdo);
        return commPointRdo;
    }
}
