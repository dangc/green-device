package com.nuri.green.device.store;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointLogRdo;
import com.nuri.green.device.entity.CommPointRdo;
import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.store.jpo.*;
import com.nuri.green.device.store.mapper.CommPointMapper;
import com.nuri.green.device.store.mapper.ServicePointMapper;
import com.nuri.green.device.store.mapper.UtilityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Component
public class CommPointMapperStore implements CommPointStore {

    private final CommPointMapper commPointMapper;
    private final ServicePointMapper servicePointMapper;
    private final UtilityMapper utilityMapper;

    public CommPointMapperStore(CommPointMapper commPointMapper, ServicePointMapper servicePointMapper, UtilityMapper utilityMapper) {
        this.commPointMapper = commPointMapper;
        this.servicePointMapper = servicePointMapper;
        this.utilityMapper = utilityMapper;
    }


    @Override
    public List<CommPointRdo> findAllByCondition(CommPoint commPoint) {
        List<CommPointJpo> commPointJpos = commPointMapper.findAllByCondition(new CommPointJpo(commPoint));
        return commPointJpos.stream().map(CommPointJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(CommPoint commPoint) {
        int count = commPointMapper.count(new CommPointJpo(commPoint));
        return count;
    }

    @Override
    public CommPointRdo findById(int commPointId) {
        CommPointJpo commPointJpo = commPointMapper.findById(commPointId);

        if(commPointJpo != null) {
            return commPointJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(CommPoint commPoint) {
        CommPointJpo commPointJpo = new CommPointJpo(commPoint);
        int result = commPointMapper.insert(commPointJpo);
        if(commPointJpo.getCommPointId() != null){
            commPoint.setCommPointId(commPointJpo.getCommPointId());
        }
        if(result != 0){
            addMeasurementPointLog(commPoint);
        }
        return result;
    }

    @Override
    public int update(CommPoint commPoint) {
        CommPointJpo commPointJpo = new CommPointJpo(commPoint);
        int result = commPointMapper.update(commPointJpo);
        if(result != 0){
            addMeasurementPointLog(commPoint);
        }
        return result;
    }

    @Override
    public List<CommPointLogRdo> commPointLog(CommPoint commPoint) {
        List<CommPointLogJpo> commPointLogJpos = commPointMapper.commPointLog(new CommPointLogJpo(commPoint));
        return commPointLogJpos.stream().map(CommPointLogJpo::toDomain).collect(Collectors.toList());
    }

    // 통신서비스 변경 이력 저장
    public int addMeasurementPointLog(CommPoint commPoint) {
        CommPointLogJpo commPointLogJpo = new CommPointLogJpo(commPoint);
        ServicePointJpo servicePointJpo = servicePointMapper.findById(commPoint.getServicePointId());
        commPointLogJpo.setAptNo(servicePointJpo.getAptNo());
        commPointLogJpo.setDong(servicePointJpo.getDong());
        commPointLogJpo.setHo(servicePointJpo.getHo());
        commPointLogJpo.setSeqNo(maxSeq("commPointId", commPointLogJpo.getCommPointId())); // Max SEQ_NO 조회

        int result = commPointMapper.addCommPointLog(commPointLogJpo);
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
