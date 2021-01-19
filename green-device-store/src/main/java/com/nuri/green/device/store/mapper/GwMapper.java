package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceJpo;
import com.nuri.green.device.store.jpo.GwJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GwMapper {

    int count(GwJpo gwJpo);

    List<GwJpo> findAllByCondition(GwJpo gwJpo);

    GwJpo findById(int deviceId);

    int insert(GwJpo gwJpo);

    int update(GwJpo gwJpo);
}
