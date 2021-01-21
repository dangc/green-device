package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("deviceModelJpo")
public class DeviceModelJpo extends CommonObj {

    private Integer modelSeq;
    private String modelNm;
    private String deviceType;
    private String deviceTypeNm;
    private String vendorSeq;
    private String vendorNm;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;

    public DeviceModelJpo(DeviceModel deviceModel) {
        if(deviceModel != null) {
            BeanUtils.copyProperties(deviceModel, this);
        }

        // page
        if(deviceModel.getOffset() != null && deviceModel.getLimit() != null) {
            setPage(deviceModel.getOffset(), deviceModel.getLimit());
        }

        // order
        if(deviceModel.getOrderby() != null) {
            setOrder(deviceModel.getOrderby());
        }
    }

    public DeviceModelRdo toDomain() {
        DeviceModelRdo deviceModelRdo = new DeviceModelRdo();
        BeanUtils.copyProperties(this, deviceModelRdo);
        return deviceModelRdo;
    }
}
