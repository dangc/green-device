package com.nuri.green.device.spec;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;

import java.util.List;

public interface DeviceStatusService {

    List<DeviceStatusRdo> findAllByCondition(DeviceStatus deviceStatus);

    int count(DeviceStatus device);

    DeviceStatusRdo findById(int deviceId);

    int insert(DeviceStatus device);

    int update(DeviceStatus device);

    boolean existById(int deviceId);
}
