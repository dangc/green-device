package com.nuri.green.device.logic;

import com.nuri.green.device.entity.Vendor;
import com.nuri.green.device.entity.VendorRdo;
import com.nuri.green.device.spec.VendorService;
import com.nuri.green.device.store.VendorStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class VendorLogic implements VendorService {

    private final VendorStore vendorStore;

    public VendorLogic(VendorStore vendorStore) {
        this.vendorStore = vendorStore;
    }

    @Override
    public List<VendorRdo> findAllByCondition(Vendor vendor) {
        return this.vendorStore.findAllByCondition(vendor);
    }

    @Override
    public int count(Vendor vendor) {
        return this.vendorStore.count(vendor);
    }

    @Override
    public VendorRdo findById(int vendorSeq) {
        return this.vendorStore.findById(vendorSeq);
    }

    @Override
    public int insert(Vendor vendor) {
        int result = 0;

        if(!this.existById(vendor.getVendorSeq())) {
            result = this.vendorStore.insert(vendor);
        }

        return result;
    }

    @Override
    public int update(Vendor vendor) {
        return this.vendorStore.update(vendor);
    }

    @Override
    public boolean existById(int vendorSeq) {
        Vendor vendor = new Vendor();
        vendor.setVendorSeq(vendorSeq);

        int count = this.vendorStore.count(vendor);

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
