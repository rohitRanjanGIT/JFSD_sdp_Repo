package spr.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FinancialAidApplications {
    @Id
    private Long applicationId;

    private Integer studentId;

    private Integer scholarshipId;

    private boolean phase1; // 1

    private boolean phase2; // reject

    private boolean phase3; // accept

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(Integer scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public boolean isPhase1() {
		return phase1;
	}

	public void setPhase1(boolean phase1) {
		this.phase1 = phase1;
	}

	public boolean isPhase2() {
		return phase2;
	}

	public void setPhase2(boolean phase2) {
		this.phase2 = phase2;
	}

	public boolean isPhase3() {
		return phase3;
	}

	public void setPhase3(boolean phase3) {
		this.phase3 = phase3;
	}

}