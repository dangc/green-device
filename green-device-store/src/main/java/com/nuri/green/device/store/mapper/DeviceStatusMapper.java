package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceStatusJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceStatusMapper {

    int count(DeviceStatusJpo deviceStatusJpo);

    List<DeviceStatusJpo> findAllByCondition(DeviceStatusJpo deviceStatusJpo);

    DeviceStatusJpo findById(int deviceId);

    int insert(DeviceStatusJpo deviceStatusJpo);

    int update(DeviceStatusJpo deviceStatusJpo);
}
