package com.nuri.green.device.store;

import com.nuri.green.device.entity.AptInfo;
import com.nuri.green.device.entity.AptInfoLocation;
import com.nuri.green.device.entity.AptInfoRdo;

import java.util.List;

public interface AptInfoStore {

    List<AptInfoRdo> findAllByCondition(AptInfo aptInfo);

    int count(AptInfo aptInfo);

    AptInfoRdo findById(String aptNo);

    int insert(AptInfo aptInfo);

    int update(AptInfo aptInfo);

    AptInfoLocation findLocationById(String aptNo);
}
