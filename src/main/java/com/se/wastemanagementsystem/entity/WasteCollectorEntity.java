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
    @OneToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity user;

    @Column(name = "fk_user_id", nullable = false, updatable = false, insertable = false)
    private Integer userId;

}
