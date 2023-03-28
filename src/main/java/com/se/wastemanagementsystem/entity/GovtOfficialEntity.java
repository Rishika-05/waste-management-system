package com.se.wastemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "govt_official")
public class GovtOfficialEntity extends BaseEntity{
    @Column(name = "department")
    private String department;
    @Column(name = "pincode_csv")
    private Integer pincodeCsv;
    @OneToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity user;

    @Column(name = "fk_user_id", nullable = false, updatable = false, insertable = false)
    private Integer userId;

}
