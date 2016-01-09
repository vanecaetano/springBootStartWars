package br.com.vanessa.starwars.api.model;


import java.io.Serializable;

public class People implements Serializable, Comparable<People>{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
    public String birth_year;
    public String gender;
    public String height;
    public String mass;
    private int specie;
    private int year;
    
    public People(String name, String birth_year, String gender, String height, String mass, int specie) {
		this.name = name;
		this.birth_year = birth_year;
		this.gender = gender;
		this.height = height;
		this.mass = mass;
		this.specie = specie;
		this.year = calculateBirthOrder(birth_year);
	}


	private int calculateBirthOrder(String birth_year) {
		return birth_year.contains("BBY") ? Integer.valueOf(birth_year.substring(0,2)+ "9")*-1:Integer.valueOf(birth_year.substring(0,2) + "00");
	}
	
	
	@Override
	public int compareTo(People o2) {
		if (this.year < o2.year) {
            return -1;
        }
        if (this.year > o2.year) {
            return 1;
        }
        return 0;
	}
 

	

	@Override
	public String toString() {
		return "People [name=" + name + ", birth_year=" + birth_year
				+ ", gender=" + gender + ", height=" + height + ", mass="
				+ mass + ", species=" + specie + ", year=" + year + "]";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}


	public int getSpecie() {
		return specie;
	}


	public void setSpecies(int specie) {
		this.specie = specie;
	}
    
	
}
