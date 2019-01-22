package com.vipul.test.bookstore.service.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_STORE")
public class BookStore implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Integer bookId;
	private String bookTitle;
	//private String BookAuthor;
	@OneToOne
	@JoinColumn(name = "authorId")
	private BookAuthor bookAuthor;
	
	private String bookSubject;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public BookAuthor getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(BookAuthor bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((bookSubject == null) ? 0 : bookSubject.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
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
		BookStore other = (BookStore) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookSubject == null) {
			if (other.bookSubject != null)
				return false;
		} else if (!bookSubject.equals(other.bookSubject))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookStore [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookSubject=" + bookSubject + "]";
	}
	
	
}
