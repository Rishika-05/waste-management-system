package com.se.wastemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waste_collector")
public class WasteCollectorEntity extends BaseEntity{

    @Column(name = "vehicle_no")
    private String vehicleNo;
    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "fk_user_id")
    private Integer userId;

}
