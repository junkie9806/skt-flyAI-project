package com.skt.kbodot.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Converted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long convertedId;

    private String convertedPath;
    private String convertedTag;

    public String getTag() {
        return convertedTag;
    }

    @ManyToOne
    @JoinColumn(name = "image_id")
    @JsonBackReference
    private Image image;
}
