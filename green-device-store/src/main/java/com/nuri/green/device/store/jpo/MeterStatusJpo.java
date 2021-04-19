package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;
import com.nuri.green.device.entity.MeterStatus;
import com.nuri.green.device.entity.MeterStatusRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("meterStatusJpo")
public class MeterStatusJpo extends CommonObj {

    private Integer meterId;
    private String meterSerial;
    private String meterType;
    private String meterTypeNm;
    private String meterStatus;
    private String meterStatusNm;
    private String lastReadDt;
    private String serverId;
    private String regDt;
    private String updateDt;

    public MeterStatusJpo(MeterStatus meterStatus) {
        if(meterStatus != null) {
            BeanUtils.copyProperties(meterStatus, this);
        }

        // page
        if(meterStatus.getOffset() != null && meterStatus.getLimit() != null) {
            setPage(meterStatus.getOffset(), meterStatus.getLimit());
        }

        // order
        if(meterStatus.getOrderby() != null) {
            setOrder(meterStatus.getOrderby());
        }
    }

    public MeterStatusRdo toDomain() {
        MeterStatusRdo meterStatusRdo = new MeterStatusRdo();
        BeanUtils.copyProperties(this, meterStatusRdo);
        return meterStatusRdo;
    }

}
