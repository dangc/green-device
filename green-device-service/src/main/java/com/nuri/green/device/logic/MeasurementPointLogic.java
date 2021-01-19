package com.nuri.green.device.logic;

import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.device.spec.MeasurementPointService;
import com.nuri.green.device.store.MeasurementPointStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MeasurementPointLogic implements MeasurementPointService {

    private final MeasurementPointStore measurementPointStore;

    public MeasurementPointLogic(MeasurementPointStore measurementPointStore) {
        this.measurementPointStore = measurementPointStore;
    }

    @Override
    public List<MeasurementPointRdo> findAllByCondition(MeasurementPoint measurementPoint) {
        return this.measurementPointStore.findAllByCondition(measurementPoint);
    }

    @Override
    public int count(MeasurementPoint measurementPoint) {
        return this.measurementPointStore.count(measurementPoint);
    }

    @Override
    public MeasurementPointRdo findById(int measurementPointId) {
        return this.measurementPointStore.findById(measurementPointId);
    }

    @Override
    public int insert(MeasurementPoint measurementPoint) {
        int result = 0;

        if(!this.existById(measurementPoint.getMesurementPointId())) {
            result = this.measurementPointStore.insert(measurementPoint);
        }

        return result;
    }

    @Override
    public int update(MeasurementPoint measurementPoint) {
        return this.measurementPointStore.update(measurementPoint);
    }

    @Override
    public boolean existById(int measurementPointId) {
        MeasurementPoint measurementPoint = new MeasurementPoint();
        measurementPoint.setMesurementPointId(measurementPointId);

        int count = this.measurementPointStore.count(measurementPoint);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
