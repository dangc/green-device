package com.nuri.green.device.logic;

import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;
import com.nuri.green.device.spec.DeviceModelService;
import com.nuri.green.device.store.DeviceModelStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DeviceModelLogic implements DeviceModelService {

    private final DeviceModelStore deviceModelStore;

    public DeviceModelLogic(DeviceModelStore deviceModelStore) {
        this.deviceModelStore = deviceModelStore;
    }

    @Override
    public List<DeviceModelRdo> findAllByCondition(DeviceModel deviceModel) {
        return this.deviceModelStore.findAllByCondition(deviceModel);
    }

    @Override
    public int count(DeviceModel deviceModel) {
        return this.deviceModelStore.count(deviceModel);
    }

    @Override
    public DeviceModelRdo findById(int modelSeq) {
        return this.deviceModelStore.findById(modelSeq);
    }

    @Override
    public int insert(DeviceModel deviceModel) {
        return this.deviceModelStore.insert(deviceModel);
    }

    @Override
    public int update(DeviceModel deviceModel) {
        return this.deviceModelStore.update(deviceModel);
    }

    @Override
    public boolean existById(int modelSeq) {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setModelSeq(modelSeq);

        int count = this.deviceModelStore.count(deviceModel);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
