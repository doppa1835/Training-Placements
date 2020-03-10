package com.erp.trainingplacements.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the companies_students database table.
 * 
 */
@Entity
@Table(name="companies_students")
@NamedQuery(name="CompaniesStudent.findAll", query="SELECT c FROM CompaniesStudent c")
public class CompaniesStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="is_selected")
	private byte isSelected;

	private Long student;

	@Column(name="updated_on")
	private Long updatedOn;

	//bi-directional many-to-one association to CriteriaDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="criteria")
	private CriteriaDetail criteriaDetail;

	public CompaniesStudent() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte getIsSelected() {
		return this.isSelected;
	}

	public void setIsSelected(byte isSelected) {
		this.isSelected = isSelected;
	}

	public Long getStudent() {
		return this.student;
	}

	public void setStudent(Long student) {
		this.student = student;
	}

	public Long getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Long updatedOn) {
		this.updatedOn = updatedOn;
	}

	public CriteriaDetail getCriteriaDetail() {
		return this.criteriaDetail;
	}

	public void setCriteriaDetail(CriteriaDetail criteriaDetail) {
		this.criteriaDetail = criteriaDetail;
	}

}