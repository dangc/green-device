package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.Gw;
import com.nuri.green.device.entity.GwRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("gwJpo")
public class GwJpo extends CommonObj {

    private Integer deviceId;
    private String deviceSerial;
    private String sysName;
    private String sysLocation;
    private String sysContact;
    private Integer modelSeq;
    private String modelNm;
    private String sysHwVersion;
    private String sysHwBuild;
    private String sysSwVersion;
    private String sysSwRevision;
    private String sysPort;
    private String ntwType;
    private String ntwAppName;
    private String ntwState;
    private String ntwGateway;
    private String ntwEthIp;
    private String ntwEthSubnetMask;
    private String ntwEthPhy;
    private String ntwPppIp;
    private String ntwPppSubnetMask;
    private String mobileNo;
    private String regDt;
    private String updateDt;

    public GwJpo(Gw gw) {
        if(gw != null) {
            BeanUtils.copyProperties(gw, this);
        }

        // page
        if(gw.getOffset() != null && gw.getLimit() != null) {
            setPage(gw.getOffset(), gw.getLimit());
        }

        // order
        if(gw.getOrderby() != null) {
            setOrder(gw.getOrderby());
        }
    }

    public GwRdo toDomain() {
        GwRdo gwRdo = new GwRdo();
        BeanUtils.copyProperties(this, gwRdo);
        return gwRdo;
    }
}
