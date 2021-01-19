package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.*;
import com.nuri.green.page.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("deviceStatusJpo")
public class DeviceStatusJpo extends CommonObj {

    private Integer deviceId;
    private String deviceType;
    private String deviceStatus;
    private String initCommDt;
    private String lastCommDt;
    private String lastRegDt;
    private String lastReadDt;
    private String serverId;

    public DeviceStatusJpo(DeviceStatus deviceStatus) {
        if(deviceStatus != null) {
            BeanUtils.copyProperties(deviceStatus, this);
        }

        // page
        if(deviceStatus.getOffset() != null && deviceStatus.getLimit() != null) {
            setPage(deviceStatus.getOffset(), deviceStatus.getLimit());
        }

        // order
        if(deviceStatus.getOrderby() != null) {
            setOrder(deviceStatus.getOrderby());
        }
    }

    public DeviceStatusRdo toDomain() {
        DeviceStatusRdo deviceStatusRdo = new DeviceStatusRdo();
        BeanUtils.copyProperties(this, deviceStatusRdo);
        return deviceStatusRdo;
    }

}
