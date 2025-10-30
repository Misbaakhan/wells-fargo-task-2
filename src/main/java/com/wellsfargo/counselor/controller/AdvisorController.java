package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/advisors")
public class AdvisorController {

    @Autowired
    private AdvisorService advisorService;

    
    @GetMapping
    public List<Advisor> getAllAdvisors() {
        return advisorService.getAllAdvisors();
    }

    
    @GetMapping("/{id}")
    public Optional<Advisor> getAdvisorById(@PathVariable Long id) {
        return advisorService.getAdvisorById(id);
    }

    
    @PostMapping
    public Advisor createAdvisor(@RequestBody Advisor advisor) {
        return advisorService.createAdvisor(advisor);
    }

    
    @PutMapping("/{id}")
    public Advisor updateAdvisor(@PathVariable Long id, @RequestBody Advisor updatedAdvisor) {
        return advisorService.updateAdvisor(id, updatedAdvisor);
    }

    
    @DeleteMapping("/{id}")
    public void deleteAdvisor(@PathVariable Long id) {
        advisorService.deleteAdvisor(id);
    }
}
