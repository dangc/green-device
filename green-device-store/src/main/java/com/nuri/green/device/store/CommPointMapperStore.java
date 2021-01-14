package com.nuri.green.device.store;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointRdo;
import com.nuri.green.device.store.jpo.CommPointJpo;
import com.nuri.green.device.store.mapper.CommPointMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CommPointMapperStore implements CommPointStore {

    private final CommPointMapper commPointMapper;

    public CommPointMapperStore(CommPointMapper commPointMapper) {
        this.commPointMapper = commPointMapper;
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
        return result;
    }

    @Override
    public int update(CommPoint commPoint) {
        CommPointJpo commPointJpo = new CommPointJpo(commPoint);
        int result = commPointMapper.update(commPointJpo);
        return result;
    }
}
