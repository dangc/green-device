package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.ModemJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModemMapper {

    int count(ModemJpo modemJpo);

    List<ModemJpo> findAllByCondition(ModemJpo modemJpo);

    ModemJpo findById(int meterId);

    int insert(ModemJpo modemJpo);

    int update(ModemJpo modemJpo);
}
