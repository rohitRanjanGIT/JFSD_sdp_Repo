package spr.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spr.Service.*;
import spr.Model.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }


 // Admin login
    @PostMapping("/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminUser adminUser) {
        AdminUser authenticatedAdmin = authService.authenticateAdmin(adminUser);

        if (authenticatedAdmin != null) {
            // Return the authenticated AdminUser object with a 200 status
            return new ResponseEntity<>(authenticatedAdmin, HttpStatus.OK);
        } else {
            // Return an error message with a 401 status
            return new ResponseEntity<>("Invalid Admin Credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/student/login")
    public ResponseEntity<?> loginStudent(@RequestBody StudentUser studentUser) {
        StudentUser authenticatedUser = authService.authenticateStudent(studentUser);
        if (authenticatedUser != null) {
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK); // Return user details
        }
        return new ResponseEntity<>("Invalid Student Credentials", HttpStatus.UNAUTHORIZED);
    }

    // Register student
        @PostMapping("/student/register")
    public ResponseEntity<StudentUser> registerStudent(@RequestBody StudentUser studentUser) {
        return new ResponseEntity<>(authService.registerStudent(studentUser), HttpStatus.CREATED);
    }

    // Register admin
    @PostMapping("/admin/register")
    public ResponseEntity<AdminUser> registerAdmin(@RequestBody AdminUser adminUser) {
        return new ResponseEntity<>(authService.registerAdmin(adminUser), HttpStatus.CREATED);
    }
}

// Student login
//    @PostMapping("/student/login")
//    public ResponseEntity<String> loginStudent(@RequestBody StudentUser studentUser) {
//        boolean isAuthenticated = authService.authenticateStudent(studentUser);
//        return isAuthenticated ? new ResponseEntity<>("Student Login Successful", HttpStatus.OK) : new ResponseEntity<>("Invalid Student Credentials", HttpStatus.UNAUTHORIZED);
//    }
//    // Admin login
//    @PostMapping("/admin/login")
//    public ResponseEntity<String> loginAdmin(@RequestBody AdminUser adminUser) {
//        boolean isAuthenticated = authService.authenticateAdmin(adminUser);
//        return isAuthenticated ? new ResponseEntity<>("Admin Login Successful", HttpStatus.OK) : new ResponseEntity<>("Invalid Admin Credentials", HttpStatus.UNAUTHORIZED);
//    }