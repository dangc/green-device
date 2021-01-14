package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.MeasurementPointJpo;

import java.util.List;

public interface MeasurementPointMapper {

    int count(MeasurementPointJpo measurementPointJpo);

    List<MeasurementPointJpo> findAllByCondition(MeasurementPointJpo measurementPointJpo);

    MeasurementPointJpo findById(int measurementPointId);

    int insert(MeasurementPointJpo measurementPointJpo);

    int update(MeasurementPointJpo measurementPointJpo);
}
