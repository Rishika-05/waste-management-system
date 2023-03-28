package com.se.wastemanagementsystem.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class AdminEntity extends BaseEntity{
    @Column(name = "level")
    private Integer level;
    @OneToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private UserEntity user;

    @Column(name = "fk_user_id", nullable = false, updatable = false, insertable = false)
    private Integer userId;

}
