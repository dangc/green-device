package com.nuri.green.device.store;

import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointLogRdo;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.device.store.jpo.MeasurementPointJpo;
import com.nuri.green.device.store.jpo.MeasurementPointLogJpo;
import com.nuri.green.device.store.jpo.ServicePointJpo;
import com.nuri.green.device.store.mapper.MeasurementPointMapper;
import com.nuri.green.device.store.mapper.ServicePointMapper;
import com.nuri.green.device.store.mapper.UtilityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MeasurementPointMapperStore implements MeasurementPointStore {

    private final MeasurementPointMapper measurementPointMapper;
    private final ServicePointMapper servicePointMapper;
    private final UtilityMapper utilityMapper;

    public MeasurementPointMapperStore(MeasurementPointMapper measurementPointMapper, ServicePointMapper servicePointMapper, UtilityMapper utilityMapper) {
        this.measurementPointMapper = measurementPointMapper;
        this.servicePointMapper = servicePointMapper;
        this.utilityMapper = utilityMapper;
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
        if(result != 0){
            addMeasurementPointLog(measurementPoint);
        }
        return result;
    }

    @Override
    public int update(MeasurementPoint measurementPoint) {
        MeasurementPointJpo measurementPointJpo = new MeasurementPointJpo(measurementPoint);
        int result = measurementPointMapper.update(measurementPointJpo);
        if(result != 0){
            addMeasurementPointLog(measurementPoint);
        }
        return result;
    }

    @Override
    public List<MeasurementPointLogRdo> measurementPointLog(MeasurementPoint measurementPoint) {
        List<MeasurementPointLogJpo> measurementPointLogJpos = measurementPointMapper.measurementPointLog(new MeasurementPointJpo(measurementPoint));
        return measurementPointLogJpos.stream().map(MeasurementPointLogJpo::toDomain).collect(Collectors.toList());
    }

    // 계측점 변경 이력 저장
    public int addMeasurementPointLog(MeasurementPoint measurementPoint) {
        MeasurementPointLogJpo measurementPointLogJpo = new MeasurementPointLogJpo(measurementPoint);
        ServicePointJpo servicePointJpo = servicePointMapper.findById(measurementPoint.getServicePointId());
        measurementPointLogJpo.setAptNo(servicePointJpo.getAptNo());
        measurementPointLogJpo.setDong(servicePointJpo.getDong());
        measurementPointLogJpo.setHo(servicePointJpo.getHo());
        measurementPointLogJpo.setSeqNo(maxSeq("measurementPointId", measurementPointLogJpo.getMeasurementPointId())); // Max SEQ_NO 조회

        int result = measurementPointMapper.addMeasurementPointLog(measurementPointLogJpo);
        return result;
    }

    // SEQ_NO Max값 조회
    public int maxSeq(String serviceNm, int pointId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(serviceNm, pointId);
        int maxSeq = utilityMapper.maxSeq(map);
        return maxSeq;
    }
}
