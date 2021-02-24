package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointLogRdo;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("measurementPointLogJpo")
public class MeasurementPointLogJpo extends CommonObj {

    private Integer measurementPointId;
    private Integer seqNo;
    private Integer chgDt;
    private Integer servicePointId;
    private String servicePointNm;
    private Integer meterId;
    private String meterSerial;
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

    public MeasurementPointLogJpo(MeasurementPoint measurementPoint) {
        if(measurementPoint != null) {
            BeanUtils.copyProperties(measurementPoint, this);
        }

        // page
        if(measurementPoint.getOffset() != null && measurementPoint.getLimit() != null) {
            setPage(measurementPoint.getOffset(), measurementPoint.getLimit());
        }

        // order
        if(measurementPoint.getOrderby() != null) {
            setOrder(measurementPoint.getOrderby());
        }
    }

    public MeasurementPointLogRdo toDomain() {
        MeasurementPointLogRdo measurementPointLogRdo = new MeasurementPointLogRdo();
        BeanUtils.copyProperties(this, measurementPointLogRdo);
        return measurementPointLogRdo;
    }
}
