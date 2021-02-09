package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.DeviceLocation;
import com.nuri.green.device.entity.MeterLocation;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "deviceLocationJpo", description = "디바이스 지역정보")
public class DeviceLocationJpo {

    private Integer deviceId;
    private String deviceSerial;
    private String locationId;
    private String locationNm;
    private String regionId;

    public DeviceLocation toDomain() {
        DeviceLocation deviceLocation = new DeviceLocation();
        BeanUtils.copyProperties(this, deviceLocation);
        return deviceLocation;
    }
}