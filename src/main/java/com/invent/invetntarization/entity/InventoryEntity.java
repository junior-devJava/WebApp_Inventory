package com.invent.invetntarization.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    private int id;

    private String articleName;
    private String serialNumber;
    private String location;
    private String responsible;
    private String groupName;
}
