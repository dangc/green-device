package com.nuri.green.device.store;

import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceLocation;
import com.nuri.green.device.entity.DeviceRdo;

import java.util.List;

public interface DeviceStore {

    List<DeviceRdo> findAllByCondition(Device device);

    int count(Device device);

    DeviceRdo findById(int deviceId);

    int insert(Device device);

    int update(Device device);

    DeviceLocation findLocationById(int deviceId);
}
