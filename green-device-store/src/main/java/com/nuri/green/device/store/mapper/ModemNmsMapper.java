package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.ModemNmsJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModemNmsMapper {
    int insert(ModemNmsJpo modemNmsJpo);

}
