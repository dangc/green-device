package com.nuri.green.device.store;

import com.nuri.green.device.entity.AptInfo;
import com.nuri.green.device.entity.AptInfoRdo;
import com.nuri.green.device.store.jpo.AptInfoJpo;
import com.nuri.green.device.store.mapper.AptInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AptInfoMapperStore implements AptInfoStore {

    private final AptInfoMapper aptInfoMapper;

    public AptInfoMapperStore(AptInfoMapper aptInfoMapper) {
        this.aptInfoMapper = aptInfoMapper;
    }

    @Override
    public List<AptInfoRdo> findAllByCondition(AptInfo aptInfo) {
        List<AptInfoJpo> allCodeJpos = aptInfoMapper.findAllByCondition(new AptInfoJpo(aptInfo));
        return allCodeJpos.stream().map(AptInfoJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(AptInfo aptInfo) {
        int count = aptInfoMapper.count(new AptInfoJpo(aptInfo));
        return count;
    }

    @Override
    public AptInfoRdo findById(String aptNo) {
        AptInfoJpo aptInfoJpo = aptInfoMapper.findById(aptNo);

        if(aptInfoJpo != null) {
            return aptInfoJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(AptInfo aptInfo) {

        AptInfoJpo aptInfoJpo = new AptInfoJpo(aptInfo);
        int result = aptInfoMapper.insert(aptInfoJpo);

        return result;
    }

    @Override
    public int update(AptInfo aptInfo) {
        AptInfoJpo aptInfoJpo = new AptInfoJpo(aptInfo);
        int result = aptInfoMapper.update(aptInfoJpo);

        return result;
    }
}
