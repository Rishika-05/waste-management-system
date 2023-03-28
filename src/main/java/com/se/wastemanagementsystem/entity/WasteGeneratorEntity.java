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
    @OneToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity user;

    @Column(name = "fk_user_id", nullable = false, updatable = false, insertable = false)
    private Integer userId;
}
