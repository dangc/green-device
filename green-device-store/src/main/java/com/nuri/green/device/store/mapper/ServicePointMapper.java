package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.HouseHoldJpo;
import com.nuri.green.device.store.jpo.ServicePointJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServicePointMapper {

    int count(ServicePointJpo servicePointJpo);

    List<ServicePointJpo> findAllByCondition(ServicePointJpo servicePointJpo);

    ServicePointJpo findById(int meterId);

    int insert(ServicePointJpo servicePointJpo);

    int update(ServicePointJpo servicePointJpo);

    List<HouseHoldJpo> householdMoveLog(HouseHoldJpo houseHoldJpo);
}
