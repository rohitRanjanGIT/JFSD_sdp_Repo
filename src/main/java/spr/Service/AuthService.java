package spr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spr.Repository.*;
import spr.Model.*;


@Service
public class AuthService {

    private final AdminUserRepository adminUserRepository;
    private final StudentUserRepository studentUserRepository;

    @Autowired
    public AuthService(AdminUserRepository adminUserRepository, StudentUserRepository studentUserRepository) {
        this.adminUserRepository = adminUserRepository;
        this.studentUserRepository = studentUserRepository;
    }

    // Authenticate admin
    public AdminUser authenticateAdmin(AdminUser adminUser) {
        AdminUser foundAdmin = adminUserRepository.findByUsername(adminUser.getUsername());
        if (foundAdmin != null && foundAdmin.getPassword().equals(adminUser.getPassword())) {
            return foundAdmin; 
        }
        return null;
    }


    // Authenticate student
    public StudentUser authenticateStudent(StudentUser studentUser) {
        StudentUser foundStudent = studentUserRepository.findByEmail(studentUser.getEmail());
        if (foundStudent != null && foundStudent.getPassword().equals(studentUser.getPassword())) {
            return foundStudent; // Return the authenticated student object
        }
        return null; 
    }


    // Register student
    public StudentUser registerStudent(StudentUser studentUser) {
        return studentUserRepository.save(studentUser);
    }

    // Register admin
    public AdminUser registerAdmin(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }
}
