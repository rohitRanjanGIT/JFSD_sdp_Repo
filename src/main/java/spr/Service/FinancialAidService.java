package spr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spr.Repository.*;
import spr.Model.*;


import java.util.List;
import java.util.Optional;

@Service
    public class FinancialAidService {

    private final FinancialAidRepository financialAidRepository;

    @Autowired
    public FinancialAidService(FinancialAidRepository financialAidRepository) {
        this.financialAidRepository = financialAidRepository;
    }

    // Create a new financial aid record
    public FinancialAid createFinancialAid(FinancialAid financialAid) {
        return financialAidRepository.save(financialAid);
    }

    // Retrieve all financial aid records
    public List<FinancialAid> getAllFinancialAid() {
        return financialAidRepository.findAll();
    }

    // Retrieve a financial aid record by ID
    public Optional<FinancialAid> getFinancialAidById(Long id) {
        return financialAidRepository.findById(id);
    }

    // Update financial aid details
    public FinancialAid updateFinancialAid(Long id, FinancialAid updatedFinancialAid) {
        Optional<FinancialAid> financialAidOptional = financialAidRepository.findById(id);
        if (financialAidOptional.isPresent()) {
            FinancialAid financialAid = financialAidOptional.get();
            financialAid.setName(updatedFinancialAid.getName());
            financialAid.setDescription(updatedFinancialAid.getDescription());
            financialAid.setEligibilityCriteria(updatedFinancialAid.getEligibilityCriteria());
            financialAid.setAmount(updatedFinancialAid.getAmount());
            financialAid.setApplicationDeadline(updatedFinancialAid.getApplicationDeadline());
            financialAid.setStatus(updatedFinancialAid.getStatus());
            return financialAidRepository.save(financialAid);
        }
        return null;
    }

    // Delete a financial aid record by ID
    public void deleteFinancialAid(Long id) {
        financialAidRepository.deleteById(id);
    }
}
