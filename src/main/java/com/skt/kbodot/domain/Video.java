package com.skt.kbodot.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;
    private String title;
    private String teamCode;
    private String videoPath;

    @Column(columnDefinition="DATE DEFAULT CURRENT_DATE")
    private Date date;

    @OneToOne(mappedBy = "video")
    @JsonBackReference
    private Thumb thumb;
}