package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.MeterJpo;
import com.nuri.green.device.store.jpo.MeterLocationJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeterMapper {

    int count(MeterJpo meterJpo);

    List<MeterJpo> findAllByCondition(MeterJpo meterJpo);

    MeterJpo findById(int meterId);

    int insert(MeterJpo meterJpo);

    int update(MeterJpo meterJpo);

    MeterLocationJpo findLocationById(int meterId);
}
