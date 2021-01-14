package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceJpo;

import java.util.List;

public interface DeviceMapper {

    int count(DeviceJpo deviceJpo);

    List<DeviceJpo> findAllByCondition(DeviceJpo deviceJpo);

    DeviceJpo findById(int deviceId);

    int insert(DeviceJpo deviceJpo);

    int update(DeviceJpo deviceJpo);
}
