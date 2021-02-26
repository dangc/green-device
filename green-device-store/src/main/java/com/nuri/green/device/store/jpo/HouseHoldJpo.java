package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.HouseHold;
import com.nuri.green.device.entity.HouseHoldRdo;
import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;
import com.nuri.green.store.CommonObj;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "houseHoldJpo", description = "전입전출")
public class HouseHoldJpo extends CommonObj{

    private Integer servicePointId;
    private Integer moveSeq;
    private String moveInDate;
    private String moveOutDate;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;

    public HouseHoldJpo(HouseHold houseHold) {
        if(houseHold != null) {
            BeanUtils.copyProperties(houseHold, this);
        }

        // page
        if(houseHold.getOffset() != null && houseHold.getLimit() != null) {
            setPage(houseHold.getOffset(), houseHold.getLimit());
        }

        // order
        if(houseHold.getOrderby() != null) {
            setOrder(houseHold.getOrderby());
        }
    }

    public HouseHoldRdo toDomain() {
        HouseHoldRdo houseHoldRdo = new HouseHoldRdo();
        BeanUtils.copyProperties(this, houseHoldRdo);
        return houseHoldRdo;
    }
}
