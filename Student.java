package com.tech.hibernatedemo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student implements Serializable {
   
	@Id
private int  RollNo ;
private String Name ;
private long PhoneNo;
private  String Section;

	


}
