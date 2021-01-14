package com.nuri.green.device.store.mapper;

import com.nuri.green.device.store.jpo.VendorJpo;

import java.util.List;

public interface VendorMapper {

    int count(VendorJpo vendorJpo);

    List<VendorJpo> findAllByCondition(VendorJpo vendorJpo);

    VendorJpo findById(int meterId);

    int insert(VendorJpo vendorJpo);

    int update(VendorJpo vendorJpo);
}
