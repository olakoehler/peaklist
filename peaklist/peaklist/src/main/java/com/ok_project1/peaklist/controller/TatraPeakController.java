package com.ok_project1.peaklist.controller;

import com.ok_project1.peaklist.model.TatraPeak;
import com.ok_project1.peaklist.repository.TatraPeaksRepository;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping ("/peaks")
@RequiredArgsConstructor
public class TatraPeakController {

    private final TatraPeaksRepository repo;

    @GetMapping
    public List<TatraPeak> getAllPeaks() {
        return repo.findAll();
    }
}
