package com.invent.invetntarization.repository;

import com.invent.invetntarization.entity.InventoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<InventoryEntity, String> {

}
