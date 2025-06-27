package com.we.tournament.backend.controller;

import com.we.tournament.backend.dto.RankingDTO;
import com.we.tournament.backend.service.RankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private final RankingService service;

    public RankingController(RankingService service) {
        this.service = service;
    }

    @GetMapping("/global")
    public List<RankingDTO> global() {
        return service.globalRanking();
    }

    @GetMapping("/tournament/{id}")
    public List<RankingDTO> tournament(@PathVariable Long id) {
        return service.tournamentRanking(id);
    }
}
