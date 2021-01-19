package com.nuri.green.device.spec;

import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;

import java.util.List;

public interface DeviceModelService {

    List<DeviceModelRdo> findAllByCondition(DeviceModel deviceModel);

    int count(DeviceModel deviceModel);

    DeviceModelRdo findById(int modelSeq);

    int insert(DeviceModel deviceModel);

    int update(DeviceModel deviceModel);

    boolean existById(int modelSeq);
}
