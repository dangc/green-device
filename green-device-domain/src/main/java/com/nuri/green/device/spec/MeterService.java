package com.nuri.green.device.spec;

import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterRdo;

import java.util.List;

public interface MeterService {

    List<MeterRdo> findAllByCondition(Meter meter);

    int count(Meter meter);

    MeterRdo findById(int meterId);

    int insert(Meter meter);

    int update(Meter meter);

    boolean existById(int meterId);
}
