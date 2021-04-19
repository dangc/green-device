package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.DeviceStatusJpo;
import com.nuri.green.device.store.jpo.MeterStatusJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeterStatusMapper {

    int count(MeterStatusJpo meterStatusJpo);

    List<MeterStatusJpo> findAllByCondition(MeterStatusJpo meterStatusJpo);
}
