package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.ParentDeviceRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("parentDeviceJpo")
public class ParentDeviceJpo extends CommonObj {

    private Integer deviceId;
    private String deviceSerial;

    public ParentDeviceRdo toDomain() {
        ParentDeviceRdo parentDeviceRdo = new ParentDeviceRdo();
        BeanUtils.copyProperties(this, parentDeviceRdo);
        return parentDeviceRdo;
    }

}
