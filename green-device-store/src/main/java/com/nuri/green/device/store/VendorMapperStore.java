package com.nuri.green.device.store;

import com.nuri.green.device.entity.Vendor;
import com.nuri.green.device.entity.VendorRdo;
import com.nuri.green.device.store.jpo.VendorJpo;
import com.nuri.green.device.store.mapper.VendorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class VendorMapperStore implements VendorStore {

    private final VendorMapper vendorMapper;

    public VendorMapperStore(VendorMapper vendorMapper) {
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorRdo> findAllByCondition(Vendor vendor) {
        List<VendorJpo> vendorJpos = vendorMapper.findAllByCondition(new VendorJpo(vendor));
        return vendorJpos.stream().map(VendorJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public int count(Vendor vendor) {
        int count = vendorMapper.count(new VendorJpo(vendor));
        return count;
    }

    @Override
    public VendorRdo findById(int vendorSeq) {
        VendorJpo vendorJpo = vendorMapper.findById(vendorSeq);
        if(vendorJpo != null) {
            return vendorJpo.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public int insert(Vendor vendor) {
        VendorJpo vendorJpo = new VendorJpo(vendor);
        int result = vendorMapper.insert(vendorJpo);

        if(vendorJpo.getVendorSeq() != null) {
            vendor.setVendorSeq(vendorJpo.getVendorSeq());
        }

        return result;
    }

    @Override
    public int update(Vendor vendor) {
        VendorJpo vendorJpo = new VendorJpo(vendor);
        int result = vendorMapper.update(vendorJpo);
        return result;
    }
}
