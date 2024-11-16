package spr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spr.Repository.*;
import spr.Model.*;


import java.util.List;
import java.util.Optional;

@Service
public class ScholarshipApplicationsService {

    private final ScholarshipApplicationsRepository scholarshipApplicationsRepository;

    @Autowired
    public ScholarshipApplicationsService(ScholarshipApplicationsRepository scholarshipApplicationsRepository) {
        this.scholarshipApplicationsRepository = scholarshipApplicationsRepository;
    }

    // Create a new scholarship application
    public ScholarshipApplications createApplication(ScholarshipApplications application) {
        return scholarshipApplicationsRepository.save(application);
    }

    // Retrieve all scholarship applications
    public List<ScholarshipApplications> getAllApplications() {
        return scholarshipApplicationsRepository.findAll();
    }

    // Retrieve a scholarship application by ID
    public Optional<ScholarshipApplications> getApplicationById(Long applicationId) {
        return scholarshipApplicationsRepository.findById(applicationId);
    }

    // Update phases of a scholarship application
    public ScholarshipApplications updateApplication(Long applicationId, ScholarshipApplications updatedApplication) {
        Optional<ScholarshipApplications> applicationOptional = scholarshipApplicationsRepository.findById(applicationId);
        if (applicationOptional.isPresent()) {
            ScholarshipApplications existingApplication = applicationOptional.get();

            // Update all relevant fields
            existingApplication.setStudentId(updatedApplication.getStudentId());
            existingApplication.setScholarshipId(updatedApplication.getScholarshipId());
            existingApplication.setPhase1(updatedApplication.isPhase1());
            existingApplication.setPhase2(updatedApplication.isPhase2());
            existingApplication.setPhase3(updatedApplication.isPhase3());

            return scholarshipApplicationsRepository.save(existingApplication);
        }
        return null;
    }


    // Delete a scholarship application by ID
    public void deleteApplication(Long applicationId) {
        scholarshipApplicationsRepository.deleteById(applicationId);
    }
}
