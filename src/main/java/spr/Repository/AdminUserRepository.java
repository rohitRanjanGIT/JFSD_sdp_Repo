package spr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spr.Model.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, String> {

    AdminUser findByUsername(String username);

}
