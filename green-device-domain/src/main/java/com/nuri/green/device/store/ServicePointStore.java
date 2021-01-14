package com.nuri.green.device.store;

import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;

import java.util.List;

public interface ServicePointStore {

    List<ServicePointRdo> findAllByCondition(ServicePoint servicePoint);

    int count(ServicePoint servicePoint);

    ServicePointRdo findById(int servicePointId);

    int insert(ServicePoint servicePoint);

    int update(ServicePoint servicePoint);
}
