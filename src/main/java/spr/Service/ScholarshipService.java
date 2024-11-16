package spr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spr.Repository.*;
import spr.Model.*;


import java.util.List;
import java.util.Optional;

@Service
public class ScholarshipService {

    private final ScholarshipRepository scholarshipRepository;

    @Autowired
    public ScholarshipService(ScholarshipRepository scholarshipRepository) {
        this.scholarshipRepository = scholarshipRepository;
    }

    // Create a new scholarship
    public Scholarship createScholarship(Scholarship scholarship) {
        return scholarshipRepository.save(scholarship);
    }

    // Retrieve all scholarships
    public List<Scholarship> getAllScholarships() {
        return scholarshipRepository.findAll();
    }

    // Retrieve a scholarship by ID
    public Optional<Scholarship> getScholarshipById(Long id) {
        return scholarshipRepository.findById(id);
    }

    // Update scholarship details
    public Scholarship updateScholarship(Long id, Scholarship updatedScholarship) {
        Optional<Scholarship> scholarshipOptional = scholarshipRepository.findById(id);
        if (scholarshipOptional.isPresent()) {
            Scholarship scholarship = scholarshipOptional.get();
            scholarship.setName(updatedScholarship.getName());
            scholarship.setDescription(updatedScholarship.getDescription());
            scholarship.setAmount(updatedScholarship.getAmount());
            return scholarshipRepository.save(scholarship);
        }
        return null;
    }

    // Delete a scholarship by ID
    public void deleteScholarship(Long id) {
        scholarshipRepository.deleteById(id);
    }
}