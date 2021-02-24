package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointLogRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("commPointLogJpo")
public class CommPointLogJpo extends CommonObj {

    private Integer commPointId;
    private Integer seqNo;
    private Integer chgDt;
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

    public CommPointLogJpo(CommPoint commPoint) {
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

    public CommPointLogRdo toDomain() {
        CommPointLogRdo commPointLogRdo = new CommPointLogRdo();
        BeanUtils.copyProperties(this, commPointLogRdo);
        return commPointLogRdo;
    }
}
