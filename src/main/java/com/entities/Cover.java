package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cover")
public class Cover {

	@Id
	private int id;

	private String name;
	private String description;

    @OneToOne(mappedBy = "cover", cascade = CascadeType.ALL)
    @JoinColumn(name = "notebook_id") // Define the foreign key column in Cover entity
    private Notebook notebook;

	public Cover() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cover(int id, String name, String description, Notebook notebook) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.notebook = notebook;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

}
