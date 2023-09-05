package com.skt.kbodot.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Thumb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thumbId;
    private String thumbPath;

    @OneToOne
    @JoinColumn(name = "video_id")
    @JsonManagedReference
    private Video video;
}