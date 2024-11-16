package spr.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class FinancialAid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(LocalDate applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	private String name;  // Name of the financial aid program

    private String description;  // A description of the financial aid program

    private String eligibilityCriteria;  // Eligibility criteria for the financial aid

    private Double amount;  // Amount of financial aid

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationDeadline;  // Deadline for financial aid applications

    private String status;  // Status (e.g., Available, Closed)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;  // Date the financial aid was created

    // Auto-set createdDate before persisting to the database
    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDate.now();
    }
}
