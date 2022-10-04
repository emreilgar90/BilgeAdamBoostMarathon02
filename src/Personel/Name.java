package Personel;

import java.io.Serializable;

public class Name implements Serializable {

	private static final long serialVersionUID = -1024812218875971542L;

	private String name;
	private String surName;

	public Name(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	@Override
	public String toString() {
		return "[" + name + "," + surName ;
	}


}
