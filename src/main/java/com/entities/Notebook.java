package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "notebook")
public class Notebook {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "notebook", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Note> notes = new ArrayList<>();

	public void addNoteToNotebook(Note note) {
		note.setNotebook(this); // Set the notebook for the note
		this.notes.add(note); // Add the note to the list of notes
	}

	public Notebook() {
		super();
	}

	public Notebook(int id, String name, List<Note> notes) {
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

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
