package spr.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spr.Service.*;
import spr.Model.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    // Admin login
    @PostMapping("/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminUser adminUser, HttpSession session) {
        AdminUser authenticatedAdmin = authService.authenticateAdmin(adminUser);

        if (authenticatedAdmin != null) {
            session.setAttribute("admin", authenticatedAdmin); // Store in session
            return new ResponseEntity<>(authenticatedAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Admin Credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    // Student login
    @PostMapping("/student/login")
    public ResponseEntity<?> loginStudent(@RequestBody StudentUser studentUser, HttpSession session) {
        StudentUser authenticatedUser = authService.authenticateStudent(studentUser);

        if (authenticatedUser != null) {
            session.setAttribute("student", authenticatedUser); // Store in session
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Student Credentials", HttpStatus.UNAUTHORIZED);
        }
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

    // Logout
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Invalidate session
        return new ResponseEntity<>("Logged out successfully", HttpStatus.OK);
    }
}
