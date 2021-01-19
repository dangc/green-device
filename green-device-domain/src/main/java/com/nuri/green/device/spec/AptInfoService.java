package com.nuri.green.device.spec;

import com.nuri.green.device.entity.AptInfo;
import com.nuri.green.device.entity.AptInfoLocation;
import com.nuri.green.device.entity.AptInfoRdo;

import java.util.List;

public interface AptInfoService {

    List<AptInfoRdo> findAllByCondition(AptInfo aptInfo);

    int count(AptInfo aptInfo);

    AptInfoRdo findById(String aptNo);

    int insert(AptInfo aptInfo);

    int update(AptInfo aptInfo);

    boolean existById(String aptNo);

    AptInfoLocation findLocationById(String aptNo);
}
