package com.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note {
	@Id
	private int id;
	private String title;
	@Column(length = 1500)
	private String content;
	private Date addedDate;

	@ManyToOne
	@JoinColumn(name = "notebook_id")
	private Notebook notebook;

	@ManyToMany
	@JoinTable(name = "note_label", joinColumns = @JoinColumn(name = "note_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
	private Set<Label> labels = new HashSet<>();

	public Note() {
		super();
	}

	public Note(int id, String title, String content, Date addedDate, Notebook notebook, Set<Label> labels) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
		this.notebook = notebook;
		this.labels = labels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

}
