package spr.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spr.Service.*;
import spr.Model.*;


import java.util.List;
@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ScholarshipService scholarshipService;

    @Autowired
    private FinancialAidService financialAidService;

    @Autowired
    private ScholarshipApplicationsService scholarshipApplicationsService;

    @Autowired
    private FinancialAidApplicationService financialAidApplicationsService;

    // CRUD operations for scholarships
    @PostMapping("/scholarships")
    public ResponseEntity<Scholarship> createScholarship(@RequestBody Scholarship scholarship) {
        return new ResponseEntity<>(scholarshipService.createScholarship(scholarship), HttpStatus.CREATED);
    }

    @GetMapping("/scholarships")
    public List<Scholarship> getAllScholarships() {
        return scholarshipService.getAllScholarships();
    }

    @PutMapping("/scholarships/{id}")
    public ResponseEntity<Scholarship> updateScholarship(@PathVariable Long id, @RequestBody Scholarship scholarship) {
        return new ResponseEntity<>(scholarshipService.updateScholarship(id, scholarship), HttpStatus.OK);
    }

    @DeleteMapping("/scholarships/{id}")
    public ResponseEntity<Void> deleteScholarship(@PathVariable Long id) {
        scholarshipService.deleteScholarship(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // CRUD operations for financial aid
    @PostMapping("/financial-aid")
    public ResponseEntity<FinancialAid> createFinancialAid(@RequestBody FinancialAid financialAid) {
        return new ResponseEntity<>(financialAidService.createFinancialAid(financialAid), HttpStatus.CREATED);
    }

    @GetMapping("/financial-aid")
    public List<FinancialAid> getAllFinancialAid() {
        return financialAidService.getAllFinancialAid();
    }

    @PutMapping("/financial-aid/{id}")
    public ResponseEntity<FinancialAid> updateFinancialAid(@PathVariable Long id, @RequestBody FinancialAid financialAid) {
        return new ResponseEntity<>(financialAidService.updateFinancialAid(id, financialAid), HttpStatus.OK);
    }

    @DeleteMapping("/financial-aid/{id}")
    public ResponseEntity<Void> deleteFinancialAid(@PathVariable Long id) {
        financialAidService.deleteFinancialAid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Scholarship applications management
    @GetMapping("/applications/scholarship")
    public List<ScholarshipApplications> getAllScholarshipApplications() {
        return scholarshipApplicationsService.getAllApplications();
    }

    @PutMapping("/applications/scholarship/{applicationId}")
    public ResponseEntity<ScholarshipApplications> updateScholarshipApplication(@PathVariable Long applicationId, @RequestBody ScholarshipApplications application) {
        ScholarshipApplications updatedApplication = scholarshipApplicationsService.updateApplication(applicationId, application);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    // Financial aid applications management
    @GetMapping("/applications/financial-aid")
    public List<FinancialAidApplications> getAllFinancialAidApplications() {
        return financialAidApplicationsService.getAllApplications();
    }

    @PutMapping("/applications/financial-aid/{applicationId}")
    public ResponseEntity<FinancialAidApplications> updateFinancialAidApplication(@PathVariable Long applicationId, @RequestBody FinancialAidApplications application) {
        FinancialAidApplications updatedApplication = financialAidApplicationsService.updateApplication(applicationId, application);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    //View Controllrt!!
    //landing page.
    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("welcomeMessage", "Welcome to the Student Financial Aid & Scholarships Portal!");
        return modelAndView;
    }
}
