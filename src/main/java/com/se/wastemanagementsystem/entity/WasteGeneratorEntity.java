package com.se.wastemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waste_generator")
public class WasteGeneratorEntity extends BaseEntity {
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private Integer pincode;
    @Column(name = "fk_user_id")
    private Integer userId;
}
