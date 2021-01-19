package com.nuri.green.device.logic;

import com.nuri.green.device.entity.AptInfo;
import com.nuri.green.device.entity.AptInfoLocation;
import com.nuri.green.device.entity.AptInfoRdo;
import com.nuri.green.device.spec.AptInfoService;
import com.nuri.green.device.store.AptInfoStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class AptInfoLogic implements AptInfoService {
    private final AptInfoStore aptInfoStore;

    public AptInfoLogic(AptInfoStore aptInfoStore) {
        this.aptInfoStore = aptInfoStore;
    }

    @Override
    public List<AptInfoRdo> findAllByCondition(AptInfo aptInfo) {
        return this.aptInfoStore.findAllByCondition(aptInfo);
    }

    @Override
    public int count(AptInfo aptInfo) {
        return this.aptInfoStore.count(aptInfo);
    }

    @Override
    public AptInfoRdo findById(String aptNo) {
        return this.aptInfoStore.findById(aptNo);
    }

    @Override
    public int insert(AptInfo aptInfo) {
        int result = 0;

        if(!this.existById(aptInfo.getAptNo())) {
            result = this.aptInfoStore.insert(aptInfo);
        }

        return result;
    }

    @Override
    public int update(AptInfo aptInfo) {
        return this.aptInfoStore.update(aptInfo);
    }

    @Override
    public boolean existById(String aptNo) {
        AptInfo aptInfo = new AptInfo();
        aptInfo.setAptNo(aptNo);

        int count = this.aptInfoStore.count(aptInfo);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AptInfoLocation findLocationById(String aptNo) {
        return this.aptInfoStore.findLocationById(aptNo);
    }
}
