package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceModelJpo;

import java.util.List;

public interface DeviceModelMapper {

    int count(DeviceModelJpo deviceModelJpo);

    List<DeviceModelJpo> findAllByCondition(DeviceModelJpo deviceModelJpo);

    DeviceModelJpo findById(int modelSeq);

    int insert(DeviceModelJpo deviceModelJpo);

    int update(DeviceModelJpo deviceModelJpo);
}
