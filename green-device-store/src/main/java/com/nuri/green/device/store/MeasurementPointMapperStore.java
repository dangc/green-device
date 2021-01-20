package com.nuri.green.device.store;

import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.device.store.jpo.MeasurementPointJpo;
import com.nuri.green.device.store.mapper.MeasurementPointMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MeasurementPointMapperStore implements MeasurementPointStore {

    private final MeasurementPointMapper measurementPointMapper;

    public MeasurementPointMapperStore(MeasurementPointMapper measurementPointMapper) {
        this.measurementPointMapper = measurementPointMapper;
    }

    @Override
    public List<MeasurementPointRdo> findAllByCondition(MeasurementPoint measurementPoint) {
        List<MeasurementPointJpo> measurementPointJpos = measurementPointMapper.findAllByCondition(new MeasurementPointJpo(measurementPoint));
        return measurementPointJpos.stream().map(MeasurementPointJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(MeasurementPoint measurementPoint) {
        int count = measurementPointMapper.count(new MeasurementPointJpo(measurementPoint));
        return count;
    }

    @Override
    public MeasurementPointRdo findById(int measurementPointId) {
        MeasurementPointJpo measurementPointJpo = measurementPointMapper.findById(measurementPointId);

        if(measurementPointJpo != null) {
            return measurementPointJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(MeasurementPoint measurementPoint) {
        MeasurementPointJpo measurementPointJpo = new MeasurementPointJpo(measurementPoint);
        int result = measurementPointMapper.insert(measurementPointJpo);
        if(measurementPointJpo.getMeasurementPointId() != null) {
            measurementPoint.setMeasurementPointId(measurementPointJpo.getMeasurementPointId());
        }
        return result;
    }

    @Override
    public int update(MeasurementPoint measurementPoint) {
        MeasurementPointJpo measurementPointJpo = new MeasurementPointJpo(measurementPoint);
        int result = measurementPointMapper.update(measurementPointJpo);
        return result;
    }
}
