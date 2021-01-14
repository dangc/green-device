package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.CommPointJpo;

import java.util.List;

public interface CommPointMapper {

    int count(CommPointJpo commPointJpo);

    List<CommPointJpo> findAllByCondition(CommPointJpo commPointJpo);

    CommPointJpo findById(int commPointId);

    int insert(CommPointJpo commPointJpo);

    int update(CommPointJpo commPointJpo);
}
