package com.nuri.green.device.logic;

import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;
import com.nuri.green.device.spec.ServicePointService;
import com.nuri.green.device.store.ServicePointStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ServicePointLogic implements ServicePointService {

    private final ServicePointStore servicePointStore;

    public ServicePointLogic(ServicePointStore servicePointStore) {
        this.servicePointStore = servicePointStore;
    }

    @Override
    public List<ServicePointRdo> findAllByCondition(ServicePoint servicePoint) {
        return this.servicePointStore.findAllByCondition(servicePoint);
    }

    @Override
    public int count(ServicePoint servicePoint) {
        return this.servicePointStore.count(servicePoint);
    }

    @Override
    public ServicePointRdo findById(int servicePointId) {
        return this.servicePointStore.findById(servicePointId);
    }

    @Override
    public int insert(ServicePoint servicePoint) {
        int result = 0;

        if(!this.existById(servicePoint.getServicePointId())) {
            result = this.servicePointStore.insert(servicePoint);
        }

        return result;
    }

    @Override
    public int update(ServicePoint servicePoint) {
        return this.servicePointStore.update(servicePoint);
    }

    @Override
    public boolean existById(int servicePointId) {
        ServicePoint servicePoint = new ServicePoint();
        servicePoint.setServicePointId(servicePointId);

        int count = this.servicePointStore.count(servicePoint);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
