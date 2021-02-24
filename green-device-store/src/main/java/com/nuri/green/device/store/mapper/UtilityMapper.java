package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.MeasurementPointJpo;
import com.nuri.green.device.store.jpo.MeasurementPointLogJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UtilityMapper {
    int maxSeq(HashMap<String, Object> pointId);
}
