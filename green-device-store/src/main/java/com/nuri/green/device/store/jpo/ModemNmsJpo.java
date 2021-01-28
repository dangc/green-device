package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.ModemNms;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("modemNmsJpo")
public class ModemNmsJpo extends CommonObj {

    private Integer deviceId;
    private String nmsDt;
    private String deviceSerial;
    private String parentDeviceId;
    private String parentDeviceSerial;
    private Integer networkChannel;
    private String networkKey;
    private Integer rssi;
    private Integer lqi;
    private Integer etx;
    private Integer hopCount;
    private String networkConnectionTime;
    private Integer txPower;
    private String regDt;

    public ModemNmsJpo(ModemNms modemNms) {
        if(modemNms != null) {
            BeanUtils.copyProperties(modemNms, this);
        }

        // page
        if(modemNms.getOffset() != null && modemNms.getLimit() != null) {
            setPage(modemNms.getOffset(), modemNms.getLimit());
        }

        // order
        if(modemNms.getOrderby() != null) {
            setOrder(modemNms.getOrderby());
        }
    }

    public ModemRdo toDomain() {
        ModemRdo modemRdo = new ModemRdo();
        BeanUtils.copyProperties(this, modemRdo);
        return modemRdo;
    }
}
