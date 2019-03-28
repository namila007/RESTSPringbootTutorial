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
@Table(name = "publisher")
public class Publisher implements Serializable
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

	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	//@JsonManagedReference("publisher")
	@JsonIgnore
	private List<Book> bookList = new ArrayList<>();

	public void addBook( Book book )
	{
		this.bookList.add( book );
	}
}
