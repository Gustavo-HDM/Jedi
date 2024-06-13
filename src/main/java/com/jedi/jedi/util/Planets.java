package com.jedi.jedi.util;

public enum Planets {

	NABOO(300000, 1),
	CORUSCANT(500000, 2),
	ALDERAAN(5000, 3),
	ENDOR(60000, 4),
	KASHIIKK(80500, 5);
	
	private Integer pop;
	final private int index;
	
	Planets (Integer pop, int index) {
		this.pop = pop;
		this.index = index;
	}
	
	public Integer getPop() {
		return pop;
	}
	
	public int getIndex() {
		return index;
	}
}