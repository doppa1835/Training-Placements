package com.erp.trainingplacements.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the criteria_details database table.
 * 
 */
@Entity
@Table(name="criteria_details")
@NamedQuery(name="CriteriaDetail.findAll", query="SELECT c FROM CriteriaDetail c")
public class CriteriaDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String degree;

	@Column(name="hsc_disploma")
	private String hscDisploma;

	@Column(name="is_active")
	private byte isActive;

	private String others;

	@Column(name="skill_set")
	private String skillSet;

	private String ssc;

	@Column(name="updated_on")
	private Long updatedOn;

	//bi-directional many-to-one association to CompaniesStudent
	@OneToMany(mappedBy="criteriaDetail")
	private List<CompaniesStudent> companiesStudents;

	//bi-directional many-to-one association to Company
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company")
	private Company companyBean;

	public CriteriaDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getHscDisploma() {
		return this.hscDisploma;
	}

	public void setHscDisploma(String hscDisploma) {
		this.hscDisploma = hscDisploma;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getSkillSet() {
		return this.skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getSsc() {
		return this.ssc;
	}

	public void setSsc(String ssc) {
		this.ssc = ssc;
	}

	public Long getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Long updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<CompaniesStudent> getCompaniesStudents() {
		return this.companiesStudents;
	}

	public void setCompaniesStudents(List<CompaniesStudent> companiesStudents) {
		this.companiesStudents = companiesStudents;
	}

	public CompaniesStudent addCompaniesStudent(CompaniesStudent companiesStudent) {
		getCompaniesStudents().add(companiesStudent);
		companiesStudent.setCriteriaDetail(this);

		return companiesStudent;
	}

	public CompaniesStudent removeCompaniesStudent(CompaniesStudent companiesStudent) {
		getCompaniesStudents().remove(companiesStudent);
		companiesStudent.setCriteriaDetail(null);

		return companiesStudent;
	}

	public Company getCompanyBean() {
		return this.companyBean;
	}

	public void setCompanyBean(Company companyBean) {
		this.companyBean = companyBean;
	}

}