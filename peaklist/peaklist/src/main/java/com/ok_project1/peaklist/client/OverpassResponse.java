package com.ok_project1.peaklist.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class OverpassResponse {

    private List<OverpassElement> elements;
}
