package com.se.wastemanagementsystem.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
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
    private LocalDateTime recordedAt;

    @Column(name = "index")
    private Double index;

    @OneToOne
    @JoinColumn(name = "fk_facility_id", nullable = false)
    private WasteFacilityEntity wasteFacility;

    @Column(name = "fk_facility_id", nullable = false, updatable = false, insertable = false)
    private Integer fkFacilityId;
}
