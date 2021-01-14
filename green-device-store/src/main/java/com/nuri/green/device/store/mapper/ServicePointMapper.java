package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.ServicePointJpo;

import java.util.List;

public interface ServicePointMapper {

    int count(ServicePointJpo servicePointJpo);

    List<ServicePointJpo> findAllByCondition(ServicePointJpo servicePointJpo);

    ServicePointJpo findById(int meterId);

    int insert(ServicePointJpo servicePointJpo);

    int update(ServicePointJpo servicePointJpo);
}
