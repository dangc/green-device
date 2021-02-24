package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.MeasurementPointJpo;
import com.nuri.green.device.store.jpo.MeasurementPointLogJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MeasurementPointMapper {

    int count(MeasurementPointJpo measurementPointJpo);

    List<MeasurementPointJpo> findAllByCondition(MeasurementPointJpo measurementPointJpo);

    MeasurementPointJpo findById(int measurementPointId);

    int insert(MeasurementPointJpo measurementPointJpo);

    int update(MeasurementPointJpo measurementPointJpo);

    List<MeasurementPointLogJpo> measurementPointLog(MeasurementPointJpo measurementPointJpo);

    int addMeasurementPointLog(MeasurementPointLogJpo measurementPointLogJpo);
}
