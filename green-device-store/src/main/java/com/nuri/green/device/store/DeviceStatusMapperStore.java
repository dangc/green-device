package com.nuri.green.device.store;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;
import com.nuri.green.device.store.jpo.DeviceStatusJpo;
import com.nuri.green.device.store.mapper.DeviceStatusMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DeviceStatusMapperStore implements DeviceStatusStore {

    private final DeviceStatusMapper deviceStatusMapper;

    public DeviceStatusMapperStore(DeviceStatusMapper deviceStatusMapper) {
        this.deviceStatusMapper = deviceStatusMapper;
    }


    @Override
    public List<DeviceStatusRdo> findAllByCondition(DeviceStatus deviceStatus) {
        List<DeviceStatusJpo> deviceStatusJpos = deviceStatusMapper.findAllByCondition(new DeviceStatusJpo(deviceStatus));

        return deviceStatusJpos.stream().map(DeviceStatusJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(DeviceStatus deviceStatus) {
        return deviceStatusMapper.count(new DeviceStatusJpo(deviceStatus));
    }

    @Override
    public DeviceStatusRdo findById(int deviceId) {
        DeviceStatusJpo deviceStatusJpo = deviceStatusMapper.findById(deviceId);

        if(deviceStatusJpo != null) {
            return deviceStatusJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(DeviceStatus deviceStatus) {
        DeviceStatusJpo deviceStatusJpo = new DeviceStatusJpo(deviceStatus);
        int result = deviceStatusMapper.insert(deviceStatusJpo);

        if(deviceStatusJpo.getDeviceId() != null) {
            deviceStatus.setDeviceId(deviceStatusJpo.getDeviceId());
        }

        return result;
    }

    @Override
    public int update(DeviceStatus deviceStatus) {
        DeviceStatusJpo deviceStatusJpo = new DeviceStatusJpo(deviceStatus);
        int result = deviceStatusMapper.update(deviceStatusJpo);

        return result;
    }
}
