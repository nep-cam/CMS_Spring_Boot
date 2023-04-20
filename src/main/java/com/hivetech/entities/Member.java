package com.hivetech.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "description")
    private String description;
    @Column(name = "created_date")
    private Date CreatedDate;
    @Column(name = "update_time")
    private Date UpdateTime;
//    @OneToMany(mappedBy = "member")
//    private List<Content> contents = new ArrayList<Content>();
}
