package com.se.wastemanagementsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class AdminEntity extends BaseEntity{
}
