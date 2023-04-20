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
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "brief")
    private String brief;
    @Column(name = "content")
    private String content;
    @Column(name = "creat_date")
    private Date createDate;
    @Column(name = "update_time")
    private Date updateTime;

    //    private String sort;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;
}
