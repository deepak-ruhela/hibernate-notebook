package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notebook")
public class Notebook {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "notebook", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "note_notebook", joinColumns = @JoinColumn(name = "notebook_id"), inverseJoinColumns = @JoinColumn(name = "note_id"))
	private List<Note> notes = new ArrayList<>();

	@OneToOne
	@JoinTable(name = "notebook_cover", joinColumns = @JoinColumn(name = "notebook_id"), inverseJoinColumns = @JoinColumn(name = "cover_id"))
	private Cover cover;

	public void addNoteToNotebook(Note note) {
		note.setNotebook(this); // Set the notebook for the note
		this.notes.add(note); // Add the note to the list of notes
	}

	public void addCoverToNotebook(Cover cover) {
		cover.setNotebook(this); // Set the notebook for the note
		this.setCover(cover);
	}

	public Notebook() {
		super();
	}

	public Notebook(int id, String name, List<Note> notes, Cover cover) {
		super();
		this.id = id;
		this.name = name;
		this.notes = notes;
		this.cover = cover;
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

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

}
