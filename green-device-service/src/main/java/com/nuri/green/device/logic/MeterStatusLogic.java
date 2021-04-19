package com.nuri.green.device.logic;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;
import com.nuri.green.device.entity.MeterStatus;
import com.nuri.green.device.entity.MeterStatusRdo;
import com.nuri.green.device.spec.DeviceStatusService;
import com.nuri.green.device.spec.MeterStatusService;
import com.nuri.green.device.store.DeviceStatusStore;
import com.nuri.green.device.store.MeterStatusStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MeterStatusLogic implements MeterStatusService {

    private final MeterStatusStore meterStatusStore;
    public MeterStatusLogic(MeterStatusStore meterStatusStore) {
        this.meterStatusStore = meterStatusStore;
    }

    @Override
    public List<MeterStatusRdo> findAllByCondition(MeterStatus meterStatus) {
        return this.meterStatusStore.findAllByCondition(meterStatus);
    }

    @Override
    public int count(MeterStatus meterStatus) {
        return this.meterStatusStore.count(meterStatus);
    }

}
