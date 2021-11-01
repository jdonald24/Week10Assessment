package book.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 31, 2021
 */
@Entity
@Data
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue
	private long id;
	private int pageNum;
	private String title;
	private String authorFirstName;
	private String authorLastName;
	/**
	 * @param pageNum
	 * @param title
	 * @param authorFirstName
	 * @param authorLastName
	 */
	public Book(int pageNum, String title, String authorFirstName, String authorLastName) {
		super();
		this.pageNum = pageNum;
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
	}
}
