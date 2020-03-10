package com.erp.trainingplacements.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exams database table.
 * 
 */
@Entity
@Table(name="exams")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="created_on")
	private Long createdOn;

	private Long duration;

	@Column(name="exam_code")
	private String examCode;

	@Column(name="exam_date")
	private Long examDate;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="is_correct")
	private byte isCorrect;

	@Column(name="is_negative_for_wrong")
	private byte isNegativeForWrong;

	@Column(name="marks_per_question")
	private int marksPerQuestion;

	@Column(name="negative_mark_per_question")
	private int negativeMarkPerQuestion;

	@Column(name="no_of_questions")
	private int noOfQuestions;

	private Long subject;

	public Exam() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public Long getDuration() {
		return this.duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getExamCode() {
		return this.examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public Long getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Long examDate) {
		this.examDate = examDate;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(byte isCorrect) {
		this.isCorrect = isCorrect;
	}

	public byte getIsNegativeForWrong() {
		return this.isNegativeForWrong;
	}

	public void setIsNegativeForWrong(byte isNegativeForWrong) {
		this.isNegativeForWrong = isNegativeForWrong;
	}

	public int getMarksPerQuestion() {
		return this.marksPerQuestion;
	}

	public void setMarksPerQuestion(int marksPerQuestion) {
		this.marksPerQuestion = marksPerQuestion;
	}

	public int getNegativeMarkPerQuestion() {
		return this.negativeMarkPerQuestion;
	}

	public void setNegativeMarkPerQuestion(int negativeMarkPerQuestion) {
		this.negativeMarkPerQuestion = negativeMarkPerQuestion;
	}

	public int getNoOfQuestions() {
		return this.noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public Long getSubject() {
		return this.subject;
	}

	public void setSubject(Long subject) {
		this.subject = subject;
	}

}