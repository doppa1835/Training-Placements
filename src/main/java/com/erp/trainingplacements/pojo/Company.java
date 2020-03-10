package com.erp.trainingplacements.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Long address;

	private String code;

	@Column(name="created_on")
	private Long createdOn;

	@Column(name="ctc_offered")
	private double ctcOffered;

	@Column(name="fax_number")
	private String faxNumber;

	@Column(name="is_active")
	private byte isActive;

	private String name;

	@Column(name="phone_number")
	private String phoneNumber;

	private String type;

	//bi-directional many-to-one association to CriteriaDetail
	@OneToMany(mappedBy="companyBean")
	private List<CriteriaDetail> criteriaDetails;

	public Company() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAddress() {
		return this.address;
	}

	public void setAddress(Long address) {
		this.address = address;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public double getCtcOffered() {
		return this.ctcOffered;
	}

	public void setCtcOffered(double ctcOffered) {
		this.ctcOffered = ctcOffered;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CriteriaDetail> getCriteriaDetails() {
		return this.criteriaDetails;
	}

	public void setCriteriaDetails(List<CriteriaDetail> criteriaDetails) {
		this.criteriaDetails = criteriaDetails;
	}

	public CriteriaDetail addCriteriaDetail(CriteriaDetail criteriaDetail) {
		getCriteriaDetails().add(criteriaDetail);
		criteriaDetail.setCompanyBean(this);

		return criteriaDetail;
	}

	public CriteriaDetail removeCriteriaDetail(CriteriaDetail criteriaDetail) {
		getCriteriaDetails().remove(criteriaDetail);
		criteriaDetail.setCompanyBean(null);

		return criteriaDetail;
	}

}