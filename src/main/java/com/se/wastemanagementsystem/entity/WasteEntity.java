package com.se.wastemanagementsystem.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waste")
public class WasteEntity extends BaseEntity{
    @Column(name = "type")
    private String type;
    @Column(name = "amount_in_gms")
    private double amountInGms;
    @Column(name = "generated_by", nullable = false, updatable = false, insertable = false)
    private Integer wgId;
    @Column(name = "generated_at")
    private LocalDateTime generatedAt;
    @Column(name = "collected_by", nullable = false, updatable = false, insertable = false)
    private Integer wcId;

    @Column(name = "collected_at")
    private LocalDateTime collectedAt;

    @Column(name = "processed_by", nullable = false, updatable = false, insertable = false)
    private Integer wfId;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

}
