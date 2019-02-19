package com.knockknock.dto.branch;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class BranchDetailVDTO2 implements Serializable{
	
	private static final long serialVersionUID = 1L;


	private String address;
	private String theme;
	private String gender;
	private String pet;
	private String animal;
	
	private ArrayList<String> searchKeyWord;

}
