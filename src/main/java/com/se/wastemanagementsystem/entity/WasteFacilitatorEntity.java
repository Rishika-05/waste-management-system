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

    @Column(name = "fk_user_id")
    private Integer userId;

    @Column(name = "fk_facility_id")
    private Integer fkFacilityId;
}
