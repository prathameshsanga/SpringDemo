package com.prathamesh.springdemo.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<Book>();

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(String firstName, String lastName, Set<Book> books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	
	//many authors have same firstName and lastName thats why we are using
	//hashcode and equals to create unique business key to identify authors
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
