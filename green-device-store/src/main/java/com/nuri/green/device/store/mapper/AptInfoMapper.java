package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.AptInfoJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AptInfoMapper {

    int count(AptInfoJpo aptInfoJpo);

    List<AptInfoJpo> findAllByCondition(AptInfoJpo aptInfoJpo);

    AptInfoJpo findById(String aptNo);

    int insert(AptInfoJpo aptInfoJpo);

    int update(AptInfoJpo aptInfoJpo);

    AptInfoJpo findLocationById(String aptNo);
}
