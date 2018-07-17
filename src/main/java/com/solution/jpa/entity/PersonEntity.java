package com.solution.jpa.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.solution.jpa.dto.Person;

@Entity
@Table(name = "person_native_demo")
@NamedNativeQueries({ @NamedNativeQuery(name = "fetch_person", query = "select * from person_native_demo"),
		@NamedNativeQuery(name = "fetch_person_name_code", query = "select name,code from person_native_demo"),
		@NamedNativeQuery(name = "fetch_person_name", query = "select name from person_native_demo"),
		@NamedNativeQuery(name = "fetch_person_name_dto", query = "select code, name from person_native_demo", resultSetMapping = "person_name_code_dto") })

@SqlResultSetMapping(name = "person_name_code_dto", classes = @ConstructorResult(targetClass = Person.class, columns = {
		@ColumnResult(name = "code"), @ColumnResult(name = "name") }))
public class PersonEntity {

	@Id
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + "]";
	}

}
