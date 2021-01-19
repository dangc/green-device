package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.Modem;
import com.nuri.green.device.entity.ModemRdo;
import com.nuri.green.page.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("modemJpo")
public class ModemJpo extends CommonObj {

    private Integer deviceId;
    private String deviceSerial;
    private String modemType;
    private String modemTypeNm;
    private String nodeKind;
    private Integer modelSeq;
    private String fwVersion;
    private String fwBuild;
    private String hwVersion;
    private String modemMode;
    private String regDt;
    private String updateDt;

    public ModemJpo(Modem modem) {
        if(modem != null) {
            BeanUtils.copyProperties(modem, this);
        }

        // page
        if(modem.getOffset() != null && modem.getLimit() != null) {
            setPage(modem.getOffset(), modem.getLimit());
        }

        // order
        if(modem.getOrderby() != null) {
            setOrder(modem.getOrderby());
        }
    }

    public ModemRdo toDomain() {
        ModemRdo modemRdo = new ModemRdo();
        BeanUtils.copyProperties(this, modemRdo);
        return modemRdo;
    }
}
