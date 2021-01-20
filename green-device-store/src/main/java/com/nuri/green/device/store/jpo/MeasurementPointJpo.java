package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;
import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.page.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("measurementPointJpo")
public class MeasurementPointJpo extends CommonObj {

    private Integer measurementPointId;
    private Integer servicePointId;
    private String servicePointNm;
    private Integer meterId;
    private String meterSerial;
    private String aptNo;
    private String aptNm;
    private String locationId;
    private String locationNm;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;

    public MeasurementPointJpo(MeasurementPoint measurementPoint) {
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

    public MeasurementPointRdo toDomain() {
        MeasurementPointRdo measurementPointRdo = new MeasurementPointRdo();
        BeanUtils.copyProperties(this, measurementPointRdo);
        return measurementPointRdo;
    }
}
