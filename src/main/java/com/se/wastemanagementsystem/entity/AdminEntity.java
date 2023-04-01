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

    @Column(name = "fk_user_id")
    private Integer userId;

}
