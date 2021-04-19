package com.nuri.green.device.spec;

import com.nuri.green.device.entity.MeterStatus;
import com.nuri.green.device.entity.MeterStatusRdo;
import java.util.List;


public interface MeterStatusService {

    List<MeterStatusRdo> findAllByCondition(MeterStatus meterStatus);

    int count(MeterStatus meterStatus);

}
