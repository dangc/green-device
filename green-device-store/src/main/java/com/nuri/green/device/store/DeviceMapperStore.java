package com.nuri.green.device.store;

import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceLocation;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.store.jpo.DeviceJpo;
import com.nuri.green.device.store.jpo.DeviceLocationJpo;
import com.nuri.green.device.store.mapper.DeviceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DeviceMapperStore implements DeviceStore {

    private final DeviceMapper deviceMapper;

    public DeviceMapperStore(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    @Override
    public List<DeviceRdo> findAllByCondition(Device device) {
        List<DeviceJpo> deviceJpos = deviceMapper.findAllByCondition(new DeviceJpo(device));
        return deviceJpos.stream().map(DeviceJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(Device device) {
        int count = deviceMapper.count(new DeviceJpo(device));
        return count;
    }

    @Override
    public DeviceRdo findById(int deviceId) {
        DeviceJpo deviceJpo = deviceMapper.findById(deviceId);

        if(deviceJpo != null) {
            return deviceJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(Device device) {
        DeviceJpo deviceJpo = new DeviceJpo(device);
        int result = deviceMapper.insert(deviceJpo);

        if(deviceJpo.getDeviceId() != null) {
            device.setDeviceId(deviceJpo.getDeviceId());
        }

        return result;
    }

    @Override
    public int update(Device device) {

        DeviceJpo deviceJpo = new DeviceJpo(device);
        int result = deviceMapper.update(deviceJpo);

        return result;
    }

    @Override
    public DeviceLocation findLocationById(int deviceId) {
        DeviceLocationJpo deviceLocationJpo = deviceMapper.findLocationById(deviceId);

        if(deviceLocationJpo != null) {
            return deviceLocationJpo.toDomain();
        } else {
            return null;
        }
    }
}
