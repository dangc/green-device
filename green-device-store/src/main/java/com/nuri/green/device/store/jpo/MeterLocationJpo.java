package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.MeterLocation;
import com.nuri.green.device.entity.MeterRdo;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "meterLocationJpo", description = "미터지역정보")
public class MeterLocationJpo {

    private Integer meterId;
    private String meterSerial;
    private String locationId;
    private String locationNm;
    private String regionId;

    public MeterLocation toDomain() {
        MeterLocation meterLocation = new MeterLocation();
        BeanUtils.copyProperties(this, meterLocation);
        return meterLocation;
    }
}
