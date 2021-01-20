package com.nuri.green.device.logic;

import com.nuri.green.device.entity.DeviceStatus;
import com.nuri.green.device.entity.DeviceStatusRdo;
import com.nuri.green.device.spec.DeviceStatusService;
import com.nuri.green.device.store.DeviceStatusStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DeviceStatusLogic implements DeviceStatusService {

    private final DeviceStatusStore deviceStatusStore;

    public DeviceStatusLogic(DeviceStatusStore deviceStatusStore) {
        this.deviceStatusStore = deviceStatusStore;
    }
    @Override
    public List<DeviceStatusRdo> findAllByCondition(DeviceStatus deviceStatus) {
        return this.deviceStatusStore.findAllByCondition(deviceStatus);
    }

    @Override
    public int count(DeviceStatus device) {
        return this.deviceStatusStore.count(device);
    }

    @Override
    public DeviceStatusRdo findById(int deviceId) {
        return this.deviceStatusStore.findById(deviceId);
    }

    @Override
    public int insert(DeviceStatus deviceStatus) {
        if(!existById(deviceStatus.getDeviceId())) {
            return this.deviceStatusStore.insert(deviceStatus);
        }
        return 0;
    }

    @Override
    public int update(DeviceStatus deviceStatus) {
        return this.deviceStatusStore.update(deviceStatus);
    }

    @Override
    public boolean existById(int deviceId) {
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setDeviceId(deviceId);

        int count = this.deviceStatusStore.count(deviceStatus);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
