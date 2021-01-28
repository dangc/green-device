package com.nuri.green.device.store;

import com.nuri.green.device.entity.ModemNms;
import com.nuri.green.device.store.jpo.ModemJpo;
import com.nuri.green.device.store.jpo.ModemNmsJpo;
import com.nuri.green.device.store.mapper.ModemNmsMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ModemNmsMapperStore implements ModemNmsStore {

    private final ModemNmsMapper modemNmsMapper;

    @Override
    public int insert(ModemNms modemNms) {
        ModemNmsJpo modemNmsJpo = new ModemNmsJpo(modemNms);
        int result = modemNmsMapper.insert(modemNmsJpo);
        return result;
    }
}
