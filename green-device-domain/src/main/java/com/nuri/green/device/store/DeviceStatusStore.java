package com.nuri.green.device.store;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;

import java.util.List;

public interface DeviceStatusStore {

    List<DeviceStatusRdo> findAllByCondition(DeviceStatus deviceStatus);

    int count(DeviceStatus deviceStatus);

    DeviceStatusRdo findById(int deviceId);

    int insert(DeviceStatus deviceStatus);

    int update(DeviceStatus deviceStatus);
}
