package spr.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spr.Service.*;
import spr.Model.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ScholarshipService scholarshipService;

    @Autowired
    private FinancialAidService financialAidService;

    @Autowired
    private ScholarshipApplicationsService scholarshipApplicationsService;

    @Autowired
    private FinancialAidApplicationService financialAidApplicationsService;

    // View all scholarships
    @GetMapping("/scholarships")
    public List<Scholarship> getAllScholarships() {
        return scholarshipService.getAllScholarships();
    }

    // View all financial aid
    @GetMapping("/financial-aid")
    public List<FinancialAid> getAllFinancialAid() {
        return financialAidService.getAllFinancialAid();
    }

    // Apply for a scholarship
    @PostMapping("/applications/scholarships")
    public ResponseEntity<ScholarshipApplications> applyForScholarship(@RequestBody ScholarshipApplications application) {
        return new ResponseEntity<>(scholarshipApplicationsService.createApplication(application), HttpStatus.CREATED);
    }

    // Apply for financial aid
    @PostMapping("/applications/financial-aid")
    public ResponseEntity<FinancialAidApplications> applyForFinancialAid(@RequestBody FinancialAidApplications application) {
        return new ResponseEntity<>(financialAidApplicationsService.createApplication(application), HttpStatus.CREATED);
    }

    // Check application status
    @GetMapping("/applications/status/{id}")
    public ResponseEntity<?> checkApplicationStatus(@PathVariable Long id) {
        ScholarshipApplications scholarshipStatus = scholarshipApplicationsService.getApplicationById(id).orElse(null);
        FinancialAidApplications financialAidStatus = financialAidApplicationsService.getApplicationById(id).orElse(null);

        if (scholarshipStatus != null) {
            return new ResponseEntity<>(scholarshipStatus, HttpStatus.OK);
        } else if (financialAidStatus != null) {
            return new ResponseEntity<>(financialAidStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Application not found", HttpStatus.NOT_FOUND);
        }
    }

    // Edit scholarship application
    @PutMapping("/applications/scholarships/{id}")
    public ResponseEntity<?> updateScholarshipApplication(@PathVariable Long id, @RequestBody ScholarshipApplications updatedApplication) {
        Optional<ScholarshipApplications> existingApplication = scholarshipApplicationsService.getApplicationById(id);

        if (existingApplication.isPresent()) {
            ScholarshipApplications application = existingApplication.get();
            application.setScholarshipId(updatedApplication.getScholarshipId());
            application.setPhase1(updatedApplication.isPhase1());
            application.setPhase2(updatedApplication.isPhase2());
            application.setPhase3(updatedApplication.isPhase3());
            // Add other fields as necessary

            ScholarshipApplications savedApplication = scholarshipApplicationsService.createApplication(application);
            return new ResponseEntity<>(savedApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Scholarship application not found", HttpStatus.NOT_FOUND);
        }
    }

    // Edit financial aid application
    @PutMapping("/applications/financial-aid/{id}")
    public ResponseEntity<?> updateFinancialAidApplication(@PathVariable Long id, @RequestBody FinancialAidApplications updatedApplication) {
        Optional<FinancialAidApplications> existingApplication = financialAidApplicationsService.getApplicationById(id);

        if (existingApplication.isPresent()) {
            FinancialAidApplications application = existingApplication.get();
            application.setApplicationId(updatedApplication.getApplicationId());
            application.setPhase1(updatedApplication.isPhase1());
            application.setPhase2(updatedApplication.isPhase2());
            application.setPhase3(updatedApplication.isPhase3());
            // Add other fields as necessary

            FinancialAidApplications savedApplication = financialAidApplicationsService.createApplication(application);
            return new ResponseEntity<>(savedApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Financial aid application not found", HttpStatus.NOT_FOUND);
        }
    }
}
