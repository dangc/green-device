package com.nuri.green.device.store;

import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;

import java.util.List;

public interface ModemStore {

    List<ModemRdo> findAllByCondition(Modem modem);

    int count(Modem modem);

    ModemRdo findById(int modemId);

    int insert(Modem modem);

    int update(Modem modem);
}
