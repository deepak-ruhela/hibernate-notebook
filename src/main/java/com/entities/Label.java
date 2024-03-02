package com.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "label")
public class Label {

	@Id
	private int id;
	private String name;
	@ManyToMany(mappedBy = "labels") // 'mappedBy' indicates the owning side
	private Set<Note> notes = new HashSet<>();

	public Label() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Label(int id, String name, Set<Note> notes) {
		super();
		this.id = id;
		this.name = name;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

}
