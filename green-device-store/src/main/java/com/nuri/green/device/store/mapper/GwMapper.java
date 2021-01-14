package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceJpo;
import com.nuri.green.device.store.jpo.GwJpo;

import java.util.List;

public interface GwMapper {

    int count(GwJpo gwJpo);

    List<GwJpo> findAllByCondition(GwJpo gwJpo);

    GwJpo findById(int deviceId);

    int insert(GwJpo gwJpo);

    int update(GwJpo gwJpo);
}
