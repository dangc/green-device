package com.nuri.green.device.logic;

import com.nuri.green.device.entity.*;
import com.nuri.green.device.spec.DeviceService;
import com.nuri.green.device.store.DeviceStore;
import com.nuri.green.device.store.MeterStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DeviceLogic implements DeviceService {

    private final DeviceStore deviceStore;
    private final MeterStore meterStore;

    public DeviceLogic(DeviceStore deviceStore, MeterStore meterStore) {
        this.deviceStore = deviceStore;
        this.meterStore = meterStore;
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
        return this.deviceStore.insert(device);
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

    @Override
    public DeviceLocation findLocationById(int deviceId) {
        return this.deviceStore.findLocationById(deviceId);
    }

    @Override
    public ParentDeviceRdo getParentInfo(String deviceSerial, String meterSerial) {
        ParentDeviceRdo parentDeviceRdo = null;

        if(meterSerial != null && !meterSerial.isEmpty()){
            Meter meter = new Meter();
            meter.setMeterSerial(meterSerial);
            List<MeterRdo> list = meterStore.findAllByCondition(meter);

            if(list.size() > 0){
                MeterRdo rdo = list.get(0);
                deviceSerial = rdo.getDeviceSerial();
            }
        }

        if(deviceSerial != null && !deviceSerial.isEmpty()){
            Device device = new Device();
            device.setDeviceSerial(deviceSerial);
            List<DeviceRdo> list = deviceStore.findAllByCondition(device);

            if(list.size() > 0){
                DeviceRdo rdo = list.get(0);
                String parentId = rdo.getParentGwId();

                if(parentId != null && rdo.getDeviceId() != Integer.parseInt(parentId)){
                    parentDeviceRdo = deviceStore.getParentInfo(rdo.getDeviceId());
                } else {
                    parentDeviceRdo = new ParentDeviceRdo();
                    parentDeviceRdo.setDeviceId(rdo.getDeviceId());
                    parentDeviceRdo.setDeviceSerial(rdo.getDeviceSerial());
                }
            }
        }

        return parentDeviceRdo;
    }
}
