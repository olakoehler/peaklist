package com.ok_project1.peaklist.client;
import lombok.*;

@Data
@NoArgsConstructor
public class OverpassElement {

    private Double lat;
    private Double lon;
    private OverpassTags tags;
}
