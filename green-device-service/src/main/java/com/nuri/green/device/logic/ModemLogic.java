package com.nuri.green.device.logic;

import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.spec.ModemService;
import com.nuri.green.device.store.ModemStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ModemLogic implements ModemService {

    private final ModemStore modemStore;

    public ModemLogic(ModemStore modemStore) {
        this.modemStore = modemStore;
    }

    @Override
    public List<ModemRdo> findAllByCondition(Modem modem) {
        return this.modemStore.findAllByCondition(modem);
    }

    @Override
    public int count(Modem modem) {
        return this.modemStore.count(modem);
    }

    @Override
    public ModemRdo findById(int modemId) {
        return this.modemStore.findById(modemId);
    }

    @Override
    public int insert(Modem modem) {
        return this.modemStore.insert(modem);
    }

    @Override
    public int update(Modem modem) {
        return this.modemStore.update(modem);
    }

    @Override
    public boolean existById(int modemId) {
        Modem modem = new Modem();
        modem.setDeviceId(modemId);

        int count = this.modemStore.count(modem);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
