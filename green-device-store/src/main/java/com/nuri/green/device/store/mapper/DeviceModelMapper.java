package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceModelJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceModelMapper {

    int count(DeviceModelJpo deviceModelJpo);

    List<DeviceModelJpo> findAllByCondition(DeviceModelJpo deviceModelJpo);

    DeviceModelJpo findById(int modelSeq);

    int insert(DeviceModelJpo deviceModelJpo);

    int update(DeviceModelJpo deviceModelJpo);
}
