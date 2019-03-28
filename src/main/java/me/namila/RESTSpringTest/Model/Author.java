package me.namila.RESTSpringTest.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "address")
	@NotNull
	private String address;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	//@JsonManagedReference("author")
	@JsonIgnore
	private List<Book> bookList = new ArrayList<>();

	public void addBook( Book book )
	{
		this.bookList.add( book );
	}
}
