package com.nuri.green.device.store;

import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;
import com.nuri.green.device.store.jpo.GwJpo;
import com.nuri.green.device.store.mapper.GwMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class GwMapperStore implements GwStore {

    private final GwMapper gwMapper;

    public GwMapperStore(GwMapper gwMapper) {
        this.gwMapper = gwMapper;
    }

    @Override
    public List<GwRdo> findAllByCondition(Gw gw) {
        List<GwJpo> gwJpos = gwMapper.findAllByCondition(new GwJpo(gw));
        return gwJpos.stream().map(GwJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(Gw gw) {
        int count = gwMapper.count(new GwJpo(gw));
        return count;
    }

    @Override
    public GwRdo findById(int deviceId) {
        GwJpo gwJpo = gwMapper.findById(deviceId);

        if(gwJpo != null) {
            return gwJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(Gw gw) {
        GwJpo gwJpo = new GwJpo(gw);
        int result = gwMapper.insert(gwJpo);
        return result;
    }

    @Override
    public int update(Gw gw) {
        GwJpo gwJpo = new GwJpo(gw);
        int result = gwMapper.update(gwJpo);
        return result;
    }
}
