package spr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spr.Model.*;


import java.util.List;

public interface FinancialAidRepository extends JpaRepository<FinancialAid, Long> {
    // Custom query method to find financial aids by status
    List<FinancialAid> findByStatus(String status);
}
