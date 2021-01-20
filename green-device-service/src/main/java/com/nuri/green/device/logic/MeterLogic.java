package com.nuri.green.device.logic;

import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterRdo;
import com.nuri.green.device.spec.MeterService;
import com.nuri.green.device.store.MeterStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MeterLogic implements MeterService {

    private final MeterStore meterStore;

    public MeterLogic(MeterStore meterStore) {
        this.meterStore = meterStore;
    }

    @Override
    public List<MeterRdo> findAllByCondition(Meter meter) {
        return this.meterStore.findAllByCondition(meter);
    }

    @Override
    public int count(Meter meter) {
        return this.meterStore.count(meter);
    }

    @Override
    public MeterRdo findById(int meterId) {
        return this.meterStore.findById(meterId);
    }

    @Override
    public int insert(Meter meter) {
        return this.meterStore.insert(meter);
    }

    @Override
    public int update(Meter meter) {
        return this.meterStore.update(meter);
    }

    @Override
    public boolean existById(int meterId) {
        Meter meter = new Meter();
        meter.setMeterId(meterId);

        int count = this.meterStore.count(meter);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
