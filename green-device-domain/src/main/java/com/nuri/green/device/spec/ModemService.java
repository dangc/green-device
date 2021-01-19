package com.nuri.green.device.spec;

import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;

import java.util.List;

public interface ModemService {

    List<ModemRdo> findAllByCondition(Modem modem);

    int count(Modem modem);

    ModemRdo findById(int modemId);

    int insert(Modem modem);

    int update(Modem modem);

    boolean existById(int modemId);
}
