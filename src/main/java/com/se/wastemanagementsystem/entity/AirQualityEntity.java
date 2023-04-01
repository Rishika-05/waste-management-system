package com.se.wastemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "air_quality")
public class AirQualityEntity extends BaseEntity {

    @Column(name = "record_date")
    private LocalDate recordedAt;

    @Column(name = "aqi")
    private Float index;

    @Column(name = "fk_facility_id")
    private Integer fkFacilityId;
}
