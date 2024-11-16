package spr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spr.Model.StudentUser;
import spr.Repository.*;
import spr.Model.*;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentUserService {

    private final StudentUserRepository studentUserRepository;

    @Autowired
    public StudentUserService(StudentUserRepository studentUserRepository) {
        this.studentUserRepository = studentUserRepository;
    }

    // Create a new student user
    public StudentUser createStudentUser(StudentUser studentUser) {
        studentUser.setCreatedAt(LocalDate.now());  // Set the created date
        return studentUserRepository.save(studentUser);
    }

    // Retrieve all student users
    public List<StudentUser> getAllStudentUsers() {
        return studentUserRepository.findAll();
    }

    // Retrieve a student user by ID
    public Optional<StudentUser> getStudentUserById(Long id) {
        return studentUserRepository.findById(id);
    }

    // Update student user details
    public StudentUser updateStudentUser(Long id, StudentUser updatedStudentUser) {
        Optional<StudentUser> studentUserOptional = studentUserRepository.findById(id);
        if (studentUserOptional.isPresent()) {
            StudentUser studentUser = studentUserOptional.get();
            studentUser.setName(updatedStudentUser.getName());
            studentUser.setEmail(updatedStudentUser.getEmail());
            studentUser.setPhone(updatedStudentUser.getPhone());
            studentUser.setPassword(updatedStudentUser.getPassword());
            studentUser.setDob(updatedStudentUser.getDob());
            return studentUserRepository.save(studentUser);
        }
        return null;
    }

    // Delete a student user by ID
    public void deleteStudentUser(Long id) {
        studentUserRepository.deleteById(id);
    }
}
