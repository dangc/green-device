package com.nuri.green.device.spec;

import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointLogRdo;
import com.nuri.green.device.entity.MeasurementPointRdo;

import java.util.List;

public interface MeasurementPointService {

    List<MeasurementPointRdo> findAllByCondition(MeasurementPoint measurementPoint);

    int count(MeasurementPoint measurementPoint);

    MeasurementPointRdo findById(int measurementPointId);

    int insert(MeasurementPoint measurementPoint);

    int update(MeasurementPoint measurementPoint);

    boolean existById(int measurementPointId);

    List<MeasurementPointLogRdo> measurementPointLog(MeasurementPoint measurementPoint);
}
