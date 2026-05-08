package com.ok_project1.peaklist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "tatra_peaks")
@Data
@NoArgsConstructor

public class TatraPeak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column (name = "name_pl")
    private String namePL;

    private Double height;

    @Column (name = "peak_type")
    private String peakType;

    private Double lat;



    private Double lon;


}
