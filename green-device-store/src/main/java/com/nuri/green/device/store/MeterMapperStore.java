package com.nuri.green.device.store;

import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterRdo;
import com.nuri.green.device.store.jpo.MeterJpo;
import com.nuri.green.device.store.mapper.MeterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MeterMapperStore implements MeterStore {

    private final MeterMapper meterMapper;

    public MeterMapperStore(MeterMapper meterMapper) {
        this.meterMapper = meterMapper;
    }

    @Override
    public List<MeterRdo> findAllByCondition(Meter meter) {
        List<MeterJpo> meterJpos = meterMapper.findAllByCondition(new MeterJpo(meter));
        return meterJpos.stream().map(MeterJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(Meter meter) {
        int count = meterMapper.count(new MeterJpo(meter));
        return count;
    }

    @Override
    public MeterRdo findById(int meterId) {

        MeterJpo meterJpo = meterMapper.findById(meterId);

        if(meterJpo != null) {
            return meterJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(Meter meter) {
        MeterJpo meterJpo = new MeterJpo(meter);
        int result = meterMapper.insert(meterJpo);
        return result;
    }

    @Override
    public int update(Meter meter) {
        MeterJpo meterJpo = new MeterJpo(meter);
        int result = meterMapper.update(meterJpo);
        return result;
    }
}
