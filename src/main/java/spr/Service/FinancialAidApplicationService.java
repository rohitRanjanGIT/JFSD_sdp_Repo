package spr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spr.Repository.*;
import spr.Model.*;


import java.util.List;
import java.util.Optional;

@Service
public class FinancialAidApplicationService {

    private final FinancialAidApplicationsRepository financialAidApplicationsRepository;

    @Autowired
    public FinancialAidApplicationService(FinancialAidApplicationsRepository financialAidApplicationsRepository) {
        this.financialAidApplicationsRepository = financialAidApplicationsRepository;
    }

    // Create a new financial aid application
    public FinancialAidApplications createApplication(FinancialAidApplications application) {
        return financialAidApplicationsRepository.save(application);
    }

    // Retrieve all financial aid applications
    public List<FinancialAidApplications> getAllApplications() {
        return financialAidApplicationsRepository.findAll();
    }

    // Retrieve a financial aid application by ID
    public Optional<FinancialAidApplications> getApplicationById(Long applicationId) {
        return financialAidApplicationsRepository.findById(applicationId);
    }

    public FinancialAidApplications updateApplication(Long applicationId, FinancialAidApplications updatedApplication) {
        Optional<FinancialAidApplications> applicationOptional = financialAidApplicationsRepository.findById(applicationId);
        if (applicationOptional.isPresent()) {
            FinancialAidApplications existingApplication = applicationOptional.get();

            // Update fields
            existingApplication.setStudentId(updatedApplication.getStudentId());
            existingApplication.setScholarshipId(updatedApplication.getScholarshipId());
            existingApplication.setPhase1(updatedApplication.isPhase1());
            existingApplication.setPhase2(updatedApplication.isPhase2());
            existingApplication.setPhase3(updatedApplication.isPhase3());

            return financialAidApplicationsRepository.save(existingApplication);
        }
        return null;
    }

    // Delete a financial aid application by ID
    public void deleteApplication(Long applicationId) {
        financialAidApplicationsRepository.deleteById(applicationId);
    }
}
