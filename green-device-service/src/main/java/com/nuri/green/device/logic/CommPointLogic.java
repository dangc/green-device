package com.nuri.green.device.logic;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointRdo;
import com.nuri.green.device.spec.CommPointService;
import com.nuri.green.device.store.CommPointStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CommPointLogic implements CommPointService {

    private final CommPointStore commPointStore;

    public CommPointLogic(CommPointStore commPointStore) {
        this.commPointStore = commPointStore;
    }

    @Override
    public List<CommPointRdo> findAllByCondition(CommPoint commPoint) {
        return this.commPointStore.findAllByCondition(commPoint);
    }

    @Override
    public int count(CommPoint commPoint) {
        return this.commPointStore.count(commPoint);
    }

    @Override
    public CommPointRdo findById(int commPointId) {
        return this.commPointStore.findById(commPointId);
    }

    @Override
    public int insert(CommPoint commPoint) {
        return this.commPointStore.insert(commPoint);
    }

    @Override
    public int update(CommPoint commPoint) {
        return this.commPointStore.update(commPoint);
    }

    @Override
    public boolean existById(int commPointId) {
        CommPoint commPoint = new CommPoint();
        commPoint.setCommPointId(commPointId);

        int count = this.commPointStore.count(commPoint);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
