package com.nuri.green.device.spec;

import com.nuri.green.device.entity.HouseHold;
import com.nuri.green.device.entity.HouseHoldRdo;
import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;

import java.util.List;

public interface ServicePointService {

    List<ServicePointRdo> findAllByCondition(ServicePoint servicePoint);

    int count(ServicePoint servicePoint);

    ServicePointRdo findById(int servicePointId);

    int insert(ServicePoint servicePoint);

    int update(ServicePoint servicePoint);

    boolean existById(int servicePointId);

    List<HouseHoldRdo> householdMoveLog(HouseHold houseHold);
}
