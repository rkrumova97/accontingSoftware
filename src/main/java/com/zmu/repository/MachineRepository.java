package com.zmu.repository;

import com.zmu.model.Machine;

public interface MachineRepository extends GoodRepository<Machine,Long> {
    Machine findByNameAndNumberOfInvoice(String name, Integer numberOfInvoice);
}
