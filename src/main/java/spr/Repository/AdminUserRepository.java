package spr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spr.Model.AdminUser;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, String> {

    AdminUser findByUsername(String username);

}
