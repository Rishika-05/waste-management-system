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
    @Column(name = "generated_by")
    private Integer wgId;
    @Column(name = "generated_at")
    private LocalDateTime generatedAt;
    @Column(name = "collected_by")
    private Integer wcId;
    @Column(name = "collected_at")
    private LocalDateTime collectedAt;

    @Column(name = "processed_by")
    private Integer wfId;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    @Column(name = "collection_requested")
    private boolean collectionRequested;
    @Column(name = "transported")
    private boolean transported;

    @Column(name = "processed")
    private boolean processed;

}
