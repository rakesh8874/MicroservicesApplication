package com.userservicedemo.UserService.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_table")
public class User {
    @Id
    @Column(name="user_id")
    private String  userId;
    private String name;
    private String email;
    private String password;

    @Transient
    List<Rating> userRating = new ArrayList<>();
}
