package com.nuri.green.device.store;

import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.store.jpo.ModemJpo;
import com.nuri.green.device.store.mapper.ModemMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ModemMapperStore implements ModemStore {

    private final ModemMapper modemMapper;

    public ModemMapperStore(ModemMapper modemMapper) {
        this.modemMapper = modemMapper;
    }

    @Override
    public List<ModemRdo> findAllByCondition(Modem modem) {
        List<ModemJpo> modemJpos = modemMapper.findAllByCondition(new ModemJpo(modem));
        return modemJpos.stream().map(ModemJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(Modem modem) {
        int count = modemMapper.count(new ModemJpo(modem));
        return count;
    }

    @Override
    public ModemRdo findById(int modemId) {
        ModemJpo meterJpo = modemMapper.findById(modemId);

        if(meterJpo != null) {
            return meterJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(Modem modem) {
        ModemJpo modemJpo = new ModemJpo(modem);
        int result = modemMapper.insert(modemJpo);
        return result;
    }

    @Override
    public int update(Modem modem) {
        ModemJpo modemJpo = new ModemJpo(modem);
        int result = modemMapper.update(modemJpo);
        return result;
    }
}
