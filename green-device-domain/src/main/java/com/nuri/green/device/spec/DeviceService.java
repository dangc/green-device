package com.nuri.green.device.spec;

import com.nuri.green.device.entity.*;

import java.util.List;

public interface DeviceService {

    List<DeviceRdo> findAllByCondition(Device device);

    int count(Device device);

    DeviceRdo findById(int deviceId);

    int insert(Device device);

    int update(Device device);

    boolean existById(int deviceId);

    DeviceLocation findLocationById(int deviceId);
}
