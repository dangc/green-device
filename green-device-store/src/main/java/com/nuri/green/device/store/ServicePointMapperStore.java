package com.nuri.green.device.store;

import com.nuri.green.device.entity.ServicePoint;
import com.nuri.green.device.entity.ServicePointRdo;
import com.nuri.green.device.store.jpo.ServicePointJpo;
import com.nuri.green.device.store.mapper.ServicePointMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ServicePointMapperStore implements ServicePointStore {

    private final ServicePointMapper servicePointMapper;

    public ServicePointMapperStore(ServicePointMapper servicePointMapper) {
        this.servicePointMapper = servicePointMapper;
    }

    @Override
    public List<ServicePointRdo> findAllByCondition(ServicePoint servicePoint) {
        List<ServicePointJpo> servicePointJpos = servicePointMapper.findAllByCondition(new ServicePointJpo(servicePoint));
        return servicePointJpos.stream().map(ServicePointJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(ServicePoint servicePoint) {
        int count = servicePointMapper.count(new ServicePointJpo(servicePoint));
        return count;
    }

    @Override
    public ServicePointRdo findById(int servicePointId) {
        ServicePointJpo servicePointJpo = servicePointMapper.findById(servicePointId);

        if(servicePointJpo != null) {
            return servicePointJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(ServicePoint servicePoint) {
        ServicePointJpo servicePointJpo = new ServicePointJpo(servicePoint);
        int result = servicePointMapper.insert(servicePointJpo);

        if(servicePointJpo.getServicePointId() != null) {
            servicePoint.setServicePointId(servicePointJpo.getServicePointId());
        }

        return result;
    }

    @Override
    public int update(ServicePoint servicePoint) {
        ServicePointJpo servicePointJpo = new ServicePointJpo(servicePoint);
        int result = servicePointMapper.update(servicePointJpo);
        return result;
    }
}
