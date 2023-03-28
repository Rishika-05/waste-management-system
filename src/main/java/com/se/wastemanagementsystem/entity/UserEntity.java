package com.se.wastemanagementsystem.entity;

import com.se.wastemanagementsystem.enums.Roles;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ColumnTransformer(read = "AES_DECRYPT(UNHEX(phone_no), '4a9f3f93101b31f6b9b4' )",
            write = "HEX(AES_ENCRYPT(?, '4a9f3f93101b31f6b9b4'))")
    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;

}
