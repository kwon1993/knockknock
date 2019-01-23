package com.knockknock.dto.member;

import java.sql.Date;

public class ProfileVDTO {

	private int memberNumber;
	private String favorite1;
	private String favorite2;
	private String favorite3;
	private String name;
	private String nockname;
	private Date birth;
	private String ImageProfile;
	private String grade;
	private int petNumber;
	private String animal;
	private int amount;

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getFavorite1() {
		return favorite1;
	}

	public void setFavorite1(String favorite1) {
		this.favorite1 = favorite1;
	}

	public String getFavorite2() {
		return favorite2;
	}

	public void setFavorite2(String favorite2) {
		this.favorite2 = favorite2;
	}

	public String getFavorite3() {
		return favorite3;
	}

	public void setFavorite3(String favorite3) {
		this.favorite3 = favorite3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNockname() {
		return nockname;
	}

	public void setNockname(String nockname) {
		this.nockname = nockname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getImageProfile() {
		return ImageProfile;
	}

	public void setImageProfile(String imageProfile) {
		ImageProfile = imageProfile;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPetNumber() {
		return petNumber;
	}

	public void setPetNumber(int petNumber) {
		this.petNumber = petNumber;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
