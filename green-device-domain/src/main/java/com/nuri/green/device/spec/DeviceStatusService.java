package com.nuri.green.device.spec;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;

import java.util.List;

public interface DeviceStatusService {

    List<DeviceStatusRdo> findAllByCondition(DeviceStatus deviceStatus);

    int count(DeviceStatus deviceStatus);

    DeviceStatusRdo findById(int deviceId);

    int insert(DeviceStatus deviceStatus);

    int update(DeviceStatus deviceStatus);

    boolean existById(int deviceId);
}
