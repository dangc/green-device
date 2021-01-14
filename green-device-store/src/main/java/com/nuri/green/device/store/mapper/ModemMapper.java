package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.ModemJpo;

import java.util.List;

public interface ModemMapper {

    int count(ModemJpo modemJpo);

    List<ModemJpo> findAllByCondition(ModemJpo modemJpo);

    ModemJpo findById(int meterId);

    int insert(ModemJpo modemJpo);

    int update(ModemJpo modemJpo);
}
