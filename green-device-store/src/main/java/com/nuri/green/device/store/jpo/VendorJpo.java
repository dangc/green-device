package com.nuri.green.device.store.jpo;

import com.nuri.green.device.entity.Vendor;
import com.nuri.green.device.entity.VendorRdo;
import com.nuri.green.store.CommonObj;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Alias("vendorJpo")
public class VendorJpo extends CommonObj {

    private Integer vendorSeq;
    private String vendorCode;
    private String vendorNm;
    private String remark;
    private String regId;
    private String regDt;
    private String updateId;
    private String updateDt;

    public VendorJpo(Vendor vendor) {
        if(vendor != null) {
            BeanUtils.copyProperties(vendor, this);
        }

        // page
        if(vendor.getOffset() != null && vendor.getLimit() != null) {
            setPage(vendor.getOffset(), vendor.getLimit());
        }

        // order
        if(vendor.getOrderby() != null) {
            setOrder(vendor.getOrderby());
        }
    }

    public VendorRdo toDomain() {
        VendorRdo vendorRdo = new VendorRdo();
        BeanUtils.copyProperties(this, vendorRdo);
        return vendorRdo;
    }
}
