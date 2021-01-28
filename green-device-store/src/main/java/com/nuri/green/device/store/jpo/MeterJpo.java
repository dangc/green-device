package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.MeasurementPoint;
import com.nuri.green.device.entity.MeasurementPointRdo;
import com.nuri.green.device.entity.Meter;
import com.nuri.green.device.entity.MeterRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("meterJpo")
public class MeterJpo extends CommonObj {

    private Integer meterId;
    private String meterSerial;
    private Integer deviceId;
    private String deviceSerial;
    private String deviceType;
    private String deviceTypeNm;
    private String meterType;
    private String meterTypeNm;
    private String energyType;
    private String energyTypeNm;
    private String meterPhase;
    private String meterPhaseNm;
    private Integer modelSeq;
    private String modelNm;
    private String ip;
    private Integer port;
    private String cosemDeviceName;
    private String progId;
    private String progVersion;
    private Integer acon;
    private Integer rcon;
    private Integer pcon;
    private String billingDay;
    private Integer lpInterval;
    private Integer avgVolCurInterval;
    private Integer instVolCurInterval;
    private Integer netMetering;
    private String locationId;
    private String locationNm;
    private String mtime;
    private String itime;
    private String installDt;
    private String regDt;
    private String destDt;
    private String mfgDt;
    private Integer drUploadInterval;
    private Integer drMeterReadingInterval;

    public MeterJpo(Meter meter) {
        if(meter != null) {
            BeanUtils.copyProperties(meter, this);
        }

        // page
        if(meter.getOffset() != null && meter.getLimit() != null) {
            setPage(meter.getOffset(), meter.getLimit());
        }

        // order
        if(meter.getOrderby() != null) {
            setOrder(meter.getOrderby());
        }
    }

    public MeterRdo toDomain() {
        MeterRdo meterRdo = new MeterRdo();
        BeanUtils.copyProperties(this, meterRdo);
        return meterRdo;
    }
}
