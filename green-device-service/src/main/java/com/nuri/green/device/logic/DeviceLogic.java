package com.nuri.green.device.logic;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.Device;
import com.nuri.green.device.entity.DeviceRdo;
import com.nuri.green.device.spec.DeviceService;
import com.nuri.green.device.store.DeviceStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DeviceLogic implements DeviceService {

    private final DeviceStore deviceStore;

    public DeviceLogic(DeviceStore deviceStore) {
        this.deviceStore = deviceStore;
    }

    @Override
    public List<DeviceRdo> findAllByCondition(Device device) {
        return this.deviceStore.findAllByCondition(device);
    }

    @Override
    public int count(Device device) {
        return this.deviceStore.count(device);
    }

    @Override
    public DeviceRdo findById(int deviceId) {
        return this.deviceStore.findById(deviceId);
    }

    @Override
    public int insert(Device device) {
        int result = 0;

        if(!this.existById(device.getDeviceId())) {
            result = this.deviceStore.insert(device);
        }

        return result;
    }

    @Override
    public int update(Device device) {
        return this.deviceStore.update(device);
    }

    @Override
    public boolean existById(int deviceId) {
        Device device = new Device();
        device.setDeviceId(deviceId);

        int count = this.deviceStore.count(device);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
