package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository;

    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    public Optional<Security> getSecurityById(Long id) {
        return securityRepository.findById(id);
    }

    public Security createSecurity(Security security) {
        return securityRepository.save(security);
    }

    public Security updateSecurity(Long id, Security updatedSecurity) {
        return securityRepository.findById(id)
                .map(security -> {
                    security.setSecurityName(updatedSecurity.getSecurityName());
                    security.setSecurityType(updatedSecurity.getSecurityType());
                    security.setValue(updatedSecurity.getValue());
                    security.setPortfolio(updatedSecurity.getPortfolio());
                    return securityRepository.save(security);
                }).orElse(null);
    }

    public void deleteSecurity(Long id) {
        securityRepository.deleteById(id);
    }
}
