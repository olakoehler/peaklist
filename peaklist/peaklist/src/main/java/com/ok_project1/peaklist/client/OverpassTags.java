package com.ok_project1.peaklist.client;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
public class OverpassTags {
    private String name;

    @JsonProperty("name:pl")
    private String namePl;

    @JsonProperty("ele")
    private String elevation;

    private String natural;
}
