package com.ustglobal.jpawithhibernateapp.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "courses")
public class Courses {
	
	@Id
	@Column
	private int cid;
	
	@Column
	private String cname;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
	private List<Student> students;

}
