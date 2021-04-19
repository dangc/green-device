package com.nuri.green.device.store;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;
import com.nuri.green.device.entity.MeterStatus;
import com.nuri.green.device.entity.MeterStatusRdo;
import com.nuri.green.device.store.jpo.DeviceStatusJpo;
import com.nuri.green.device.store.jpo.MeterStatusJpo;
import com.nuri.green.device.store.mapper.DeviceStatusMapper;
import com.nuri.green.device.store.mapper.MeterStatusMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MeterStatusMapperStore implements MeterStatusStore {

    private final MeterStatusMapper meterStatusMapper;

    public MeterStatusMapperStore(MeterStatusMapper meterStatusMapper) {
        this.meterStatusMapper = meterStatusMapper;
    }


    @Override
    public List<MeterStatusRdo> findAllByCondition(MeterStatus meterStatus) {
        List<MeterStatusJpo> meterStatusJpos = meterStatusMapper.findAllByCondition(new MeterStatusJpo(meterStatus));
        return meterStatusJpos.stream().map(MeterStatusJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(MeterStatus meterStatus) {
        return meterStatusMapper.count(new MeterStatusJpo(meterStatus));
    }

}
