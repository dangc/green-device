package com.nuri.green.device.store;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointRdo;

import java.util.List;

public interface CommPointStore {

    List<CommPointRdo> findAllByCondition(CommPoint commPoint);

    int count(CommPoint commPoint);

    CommPointRdo findById(int commPointId);

    int insert(CommPoint commPoint);

    int update(CommPoint commPoint);
}
