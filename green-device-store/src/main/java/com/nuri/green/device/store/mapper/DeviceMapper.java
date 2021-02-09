package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceJpo;
import com.nuri.green.device.store.jpo.DeviceLocationJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper {

    int count(DeviceJpo deviceJpo);

    List<DeviceJpo> findAllByCondition(DeviceJpo deviceJpo);

    DeviceJpo findById(int deviceId);

    int insert(DeviceJpo deviceJpo);

    int update(DeviceJpo deviceJpo);

    DeviceLocationJpo findLocationById(int deviceId);
}
