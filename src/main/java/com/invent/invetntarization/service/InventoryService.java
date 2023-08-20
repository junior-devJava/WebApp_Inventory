package com.invent.invetntarization.service;

import com.invent.invetntarization.entity.InventoryEntity;
import com.invent.invetntarization.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    private final Repository repository;

    public InventoryService(Repository repository) {
        this.repository = repository;
    }

    public synchronized void addInventoryObject(InventoryEntity inventoryEntity) {
        int id = inventoryEntity.getId();
        if (!repository.existsById(String.valueOf(id))) {
            repository.save(inventoryEntity);
        } else {
            throw new RuntimeException("This id: " + id + " this object has already added");
        }
    }

    public List<InventoryEntity> getAllArticles(){
        final List<InventoryEntity> inventoryEntities = (List<InventoryEntity>) repository.findAll();
        return inventoryEntities.stream()
                .map(list -> new InventoryEntity(list.getId(), list.getArticleName(), list.getSerialNumber(), list.getLocation(), list.getResponsible(), list.getGroupName()))
                .collect(Collectors.toList());

    }
    public synchronized void deleteById(InventoryEntity inventoryEntity){
        int id = inventoryEntity.getId();
        if(repository.existsById(String.valueOf(id))){
            repository.deleteById(String.valueOf(id));
        }else{
            throw new RuntimeException("This id: " + id + " this object not added");
        }
    }
}
