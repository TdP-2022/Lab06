package it.polito.tdp.meteo.model;

import java.util.LinkedList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		
	
		//System.out.println(m.getUmiditaMedia("05"));
		
	  /* for(Rilevamento r: m.getAllRilevamentiLocalitaMese("02", "Milano")) {
	    	stampa += r.toString() + "\n";
	    }
	    System.out.println(stampa);*/
		
		
		/* System.out.println(m.trovaSequenza(5));
		 List<String> temp = new LinkedList<String>();
		for(Rilevamento r: m.getMeteodao().getAllRilevamenti()) {
				temp.add(String.valueOf(r.getData()));
		}
		System.out.println(temp);*/
		
	}

}
