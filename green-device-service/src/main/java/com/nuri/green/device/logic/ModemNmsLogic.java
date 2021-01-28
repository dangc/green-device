package com.nuri.green.device.logic;

import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemNms;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.device.spec.ModemNmsService;
import com.nuri.green.device.spec.ModemService;
import com.nuri.green.device.store.ModemNmsStore;
import com.nuri.green.device.store.ModemStore;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class ModemNmsLogic implements ModemNmsService {

    private final ModemNmsStore modemNmsStore;

    @Override
    public int insert(ModemNms modemNms) {
        return this.modemNmsStore.insert(modemNms);
    }

}
