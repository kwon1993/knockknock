package com.knockknock.dto.member;

public class PetDTO {

	private int petNumber;
	private int memberNumber;
	private String animal;
	private int amount;

	public int getPetNumber() {
		return petNumber;
	}

	public void setPetNumber(int petNumber) {
		this.petNumber = petNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
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
