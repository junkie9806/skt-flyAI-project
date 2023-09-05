package com.skt.kbodot.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String teamCode;
    @Column(columnDefinition="DATE DEFAULT CURRENT_DATE")
    private Date date;

    @OneToMany(mappedBy = "image")
    @JsonManagedReference
    private List<Original> originals;

    @OneToMany(mappedBy = "image")
    @JsonManagedReference
    private List<Converted> converteds;
}
