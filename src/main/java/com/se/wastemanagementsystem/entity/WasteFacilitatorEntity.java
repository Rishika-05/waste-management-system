package com.se.wastemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waste_facilitator")
public class WasteFacilitatorEntity extends BaseEntity{
    @Column(name = "joining_date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity user;

    @Column(name = "fk_user_id", nullable = false, updatable = false, insertable = false)
    private Integer userId;

    @OneToOne
    @JoinColumn(name = "fk_facility_id", nullable = false)
    private WasteFacilityEntity wasteFacility;

    @Column(name = "fk_facility_id", nullable = false, updatable = false, insertable = false)
    private Integer fkFacilityId;
}
