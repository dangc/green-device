package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.MeterJpo;

import java.util.List;

public interface MeterMapper {

    int count(MeterJpo meterJpo);

    List<MeterJpo> findAllByCondition(MeterJpo meterJpo);

    MeterJpo findById(int meterId);

    int insert(MeterJpo meterJpo);

    int update(MeterJpo meterJpo);
}
