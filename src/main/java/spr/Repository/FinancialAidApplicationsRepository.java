package spr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spr.Model.*;


public interface FinancialAidApplicationsRepository extends JpaRepository<FinancialAidApplications, Long> {
}
