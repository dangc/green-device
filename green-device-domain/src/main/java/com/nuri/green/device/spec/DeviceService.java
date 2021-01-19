package com.nuri.green.device.spec;

import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;
import com.nuri.green.device.entity.DeviceRdo;

import java.util.List;

public interface DeviceService {

    List<DeviceRdo> findAllByCondition(Device device);

    int count(Device device);

    DeviceRdo findById(int deviceId);

    int insert(Device device);

    int update(Device device);

    boolean existById(int deviceId);
}
