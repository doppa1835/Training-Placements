package com.erp.trainingplacements.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name="answers")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String answer;

	@Column(name="created_on")
	private Long createdOn;

	private Long exam;

	@Column(name="is_correct")
	private byte isCorrect;

	@Column(name="marks_awarded")
	private String marksAwarded;

	private Long subject;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="question")
	private Question questionBean;

	public Answer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public Long getExam() {
		return this.exam;
	}

	public void setExam(Long exam) {
		this.exam = exam;
	}

	public byte getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(byte isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getMarksAwarded() {
		return this.marksAwarded;
	}

	public void setMarksAwarded(String marksAwarded) {
		this.marksAwarded = marksAwarded;
	}

	public Long getSubject() {
		return this.subject;
	}

	public void setSubject(Long subject) {
		this.subject = subject;
	}

	public Question getQuestionBean() {
		return this.questionBean;
	}

	public void setQuestionBean(Question questionBean) {
		this.questionBean = questionBean;
	}

}