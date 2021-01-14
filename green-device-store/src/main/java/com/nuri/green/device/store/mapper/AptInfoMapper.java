package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.AptInfoJpo;

import java.util.List;

public interface AptInfoMapper {

    int count(AptInfoJpo aptInfoJpo);

    List<AptInfoJpo> findAllByCondition(AptInfoJpo aptInfoJpo);

    AptInfoJpo findById(String aptNo);

    int insert(AptInfoJpo aptInfoJpo);

    int update(AptInfoJpo aptInfoJpo);
}
