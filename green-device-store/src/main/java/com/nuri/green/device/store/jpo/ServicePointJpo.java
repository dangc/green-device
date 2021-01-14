package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;
import com.nuri.green.page.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("servicePointJpo")
public class ServicePointJpo extends CommonObj {

    private Integer servicePointId;
    private String servicePointNm;
    private String servicePointType;
    private String servicePointTypeNm;
    private String aptNo;
    private String aptNm;
    private String dong;
    private String ho;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;

    public ServicePointJpo(ServicePoint servicePoint) {
        if(servicePoint != null) {
            BeanUtils.copyProperties(servicePoint, this);
        }

        // page
        if(servicePoint.getOffset() != null && servicePoint.getLimit() != null) {
            setPage(servicePoint.getOffset(), servicePoint.getLimit());
        }

        // order
        if(servicePoint.getOrderby() != null) {
            setOrder(servicePoint.getOrderby());
        }
    }

    public ServicePointRdo toDomain() {
        ServicePointRdo servicePointRdo = new ServicePointRdo();
        BeanUtils.copyProperties(this, servicePointRdo);
        return servicePointRdo;
    }
}
