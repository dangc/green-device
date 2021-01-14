package com.nuri.green.device.store;

import com.nuri.green.device.entity.Vendor;
import com.nuri.green.device.entity.VendorRdo;

import java.util.List;

public interface VendorStore {

    List<VendorRdo> findAllByCondition(Vendor vendor);

    int count(Vendor vendor);

    VendorRdo findById(int vendorSeq);

    int insert(Vendor vendor);

    int update(Vendor vendor);
}
