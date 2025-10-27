package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvisorService {

    @Autowired
    private AdvisorRepository advisorRepository;

    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    public Optional<Advisor> getAdvisorById(Long id) {
        return advisorRepository.findById(id);
    }

    public Advisor createAdvisor(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    public Advisor updateAdvisor(Long id, Advisor updatedAdvisor) {
        return advisorRepository.findById(id)
                .map(advisor -> {
                    advisor.setFirstName(updatedAdvisor.getFirstName());
                    advisor.setLastName(updatedAdvisor.getLastName());
                    advisor.setAddress(updatedAdvisor.getAddress());
                    advisor.setPhone(updatedAdvisor.getPhone());
                    advisor.setEmail(updatedAdvisor.getEmail());
                    return advisorRepository.save(advisor);
                }).orElse(null);
    }

    public void deleteAdvisor(Long id) {
        advisorRepository.deleteById(id);
    }
}
