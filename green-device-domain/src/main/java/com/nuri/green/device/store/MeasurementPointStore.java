package com.nuri.green.device.store;

import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointRdo;

import java.util.List;

public interface MeasurementPointStore {

    List<MeasurementPointRdo> findAllByCondition(MeasurementPoint measurementPoint);

    int count(MeasurementPoint measurementPoint);

    MeasurementPointRdo findById(int measurementPointId);

    int insert(MeasurementPoint measurementPoint);

    int update(MeasurementPoint measurementPoint);
}
