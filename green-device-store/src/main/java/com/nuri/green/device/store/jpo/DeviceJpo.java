package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceLocation;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("deviceJpo")
public class DeviceJpo extends CommonObj {

    private Integer deviceId;
    private String deviceSerial;
    private String locationId;
    private String locationNm;
    private String regionId;
    private String deviceOid;
    private String commType;
    private String commTypeNm;
    private String deviceType;
    private String deviceTypeNm;
    private String nodeType;
    private String nodeTypeNm;
    private String ip;
    private Integer port;
    private String allowYn;
    private String remark;
    private String parentGwId;
    private String aptNo;
    private String aptNm;
    private String regId;
    private String regDt;
    private String destDt;
    private String endpoint;

    public DeviceJpo(Device device) {
        if(device != null) {
            BeanUtils.copyProperties(device, this);
        }

        // page
        if(device.getOffset() != null && device.getLimit() != null) {
            setPage(device.getOffset(), device.getLimit());
        }

        // order
        if(device.getOrderby() != null) {
            setOrder(device.getOrderby());
        }
    }

    public DeviceRdo toDomain() {
        DeviceRdo deviceRdo = new DeviceRdo();
        BeanUtils.copyProperties(this, deviceRdo);
        return deviceRdo;
    }

    public DeviceLocation toLocationDomain() {
        DeviceLocation deviceLocation = new DeviceLocation();
        BeanUtils.copyProperties(this, deviceLocation);
        return deviceLocation;
    }
}
