package com.nuri.green.device.spec;

import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;

import java.util.List;

public interface GwService {

    List<GwRdo> findAllByCondition(Gw gw);

    int count(Gw gw);

    GwRdo findById(int deviceId);

    int insert(Gw gw);

    int update(Gw gw);

    boolean existById(int deviceId);
}
