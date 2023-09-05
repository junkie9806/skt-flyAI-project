package com.skt.kbodot.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Original {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long originalId;

    private String originalPath;
    private String originalTag;

    public String getTag() {
        return originalTag;
    }

    @ManyToOne
    @JoinColumn(name = "image_id")
    @JsonBackReference
    private Image image;
}
