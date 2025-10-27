package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/securities")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public List<Security> getAllSecurities() {
        return securityService.getAllSecurities();
    }

    @GetMapping("/{id}")
    public Optional<Security> getSecurityById(@PathVariable Long id) {
        return securityService.getSecurityById(id);
    }

    @PostMapping
    public Security createSecurity(@RequestBody Security security) {
        return securityService.createSecurity(security);
    }

    @PutMapping("/{id}")
    public Security updateSecurity(@PathVariable Long id, @RequestBody Security security) {
        return securityService.updateSecurity(id, security);
    }

    @DeleteMapping("/{id}")
    public void deleteSecurity(@PathVariable Long id) {
        securityService.deleteSecurity(id);
    }
}
