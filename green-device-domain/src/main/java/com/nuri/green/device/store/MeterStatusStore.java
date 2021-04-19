package com.nuri.green.device.store;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;
import com.nuri.green.device.entity.MeterStatus;
import com.nuri.green.device.entity.MeterStatusRdo;

import java.util.List;

public interface MeterStatusStore {

    List<MeterStatusRdo> findAllByCondition(MeterStatus meterStatus);

    int count(MeterStatus meterStatus);

}
