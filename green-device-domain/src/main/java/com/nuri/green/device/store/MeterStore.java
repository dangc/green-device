package com.nuri.green.device.store;

import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterLocation;
import com.nuri.green.device.entity.MeterRdo;

import java.util.List;

public interface MeterStore {

    List<MeterRdo> findAllByCondition(Meter meter);

    int count(Meter meter);

    MeterRdo findById(int meterId);

    int insert(Meter meter);

    int update(Meter meter);

    MeterLocation findLocationById(int meterId);
}
