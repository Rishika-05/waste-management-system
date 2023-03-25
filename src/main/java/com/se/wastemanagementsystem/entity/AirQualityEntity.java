package com.se.wastemanagementsystem.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "air_quality")
public class AirQualityEntity extends BaseEntity {
    @Column(name = "fk_facility_id")
    private String fkFacilityId;

    @Column(name = "record_date")
    private LocalDateTime recordedAt;

    @Column(name = "index")
    private Double index;
}
