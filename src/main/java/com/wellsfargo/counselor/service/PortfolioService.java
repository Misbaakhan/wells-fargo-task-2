package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> getPortfolioById(Long id) {
        return portfolioRepository.findById(id);
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolio(Long id, Portfolio updatedPortfolio) {
        return portfolioRepository.findById(id)
                .map(portfolio -> {
                    portfolio.setPortfolioName(updatedPortfolio.getPortfolioName());
                    return portfolioRepository.save(portfolio);
                }).orElse(null);
    }

    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }
}
