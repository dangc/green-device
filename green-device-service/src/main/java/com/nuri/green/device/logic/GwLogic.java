package com.nuri.green.device.logic;

import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;
import com.nuri.green.device.spec.GwService;
import com.nuri.green.device.store.GwStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class GwLogic implements GwService {

    private final GwStore gwStore;

    public GwLogic(GwStore gwStore) {
        this.gwStore = gwStore;
    }

    @Override
    public List<GwRdo> findAllByCondition(Gw gw) {
        return this.gwStore.findAllByCondition(gw);
    }

    @Override
    public int count(Gw gw) {
        return this.gwStore.count(gw);
    }

    @Override
    public GwRdo findById(int deviceId) {
        return this.gwStore.findById(deviceId);
    }

    @Override
    public int insert(Gw gw) {
        int result = 0;

        if(!this.existById(gw.getDeviceId())) {
            result = this.gwStore.insert(gw);
        }

        return result;
    }

    @Override
    public int update(Gw gw) {
        int result = 0;
        result = this.gwStore.update(gw);
        return result;
    }

    @Override
    public boolean existById(int deviceId) {

        Gw gw = new Gw();
        gw.setDeviceId(deviceId);

        int count = this.gwStore.count(gw);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
