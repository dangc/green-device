package com.nuri.green.device.store;

import com.nuri.green.device.entity.DeviceModel;
import com.nuri.green.device.entity.DeviceModelRdo;
import com.nuri.green.device.store.jpo.DeviceJpo;
import com.nuri.green.device.store.jpo.DeviceModelJpo;
import com.nuri.green.device.store.mapper.DeviceModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DeviceModelMapperStore implements DeviceModelStore {

    private final DeviceModelMapper deviceModelMapper;

    public DeviceModelMapperStore(DeviceModelMapper deviceModelMapper) {
        this.deviceModelMapper = deviceModelMapper;
    }

    @Override
    public List<DeviceModelRdo> findAllByCondition(DeviceModel deviceModel) {
        List<DeviceModelJpo> deviceModelJpos = deviceModelMapper.findAllByCondition(new DeviceModelJpo(deviceModel));
        return deviceModelJpos.stream().map(DeviceModelJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(DeviceModel deviceModel) {
        int count = deviceModelMapper.count(new DeviceModelJpo(deviceModel));
        return count;
    }

    @Override
    public DeviceModelRdo findById(int modelSeq) {
        DeviceModelJpo deviceModelJpo = deviceModelMapper.findById(modelSeq);

        if(deviceModelJpo != null) {
            return deviceModelJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(DeviceModel deviceModel) {
        DeviceModelJpo deviceModelJpo = new DeviceModelJpo(deviceModel);
        int result = deviceModelMapper.insert(deviceModelJpo);

        if(deviceModelJpo.getModelSeq() != null) {
            deviceModel.setModelSeq(deviceModelJpo.getModelSeq());
        }

        return result;
    }

    @Override
    public int update(DeviceModel deviceModel) {
        DeviceModelJpo deviceModelJpo = new DeviceModelJpo(deviceModel);
        int result = deviceModelMapper.update(deviceModelJpo);
        return result;
    }
}
