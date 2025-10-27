package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Holding;
import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.HoldingRepository;
import com.wellsfargo.counselor.repository.PortfolioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holdings")
public class HoldingController {

    @Autowired
    private HoldingRepository holdingRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    // ✅ Create a new Holding linked to a Portfolio
    @PostMapping
    public Holding createHolding(@RequestBody Holding holding) {
        Long portfolioId = holding.getPortfolio().getId();  // changed here
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        holding.setPortfolio(portfolio);
        return holdingRepository.save(holding);
    }

    // ✅ Get all Holdings
    @GetMapping
    public List<Holding> getAllHoldings() {
        return holdingRepository.findAll();
    }
}
