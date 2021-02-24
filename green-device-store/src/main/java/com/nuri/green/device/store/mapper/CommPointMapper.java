package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.CommPointJpo;
import com.nuri.green.device.store.jpo.CommPointLogJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommPointMapper {

    int count(CommPointJpo commPointJpo);

    List<CommPointJpo> findAllByCondition(CommPointJpo commPointJpo);

    CommPointJpo findById(int commPointId);

    int insert(CommPointJpo commPointJpo);

    int update(CommPointJpo commPointJpo);

    List<CommPointLogJpo> commPointLog(CommPointLogJpo commPointLogJpo);

    int addCommPointLog(CommPointLogJpo commPointLogJpo);
}
