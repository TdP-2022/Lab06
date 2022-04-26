package it.polito.tdp.meteo.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.meteo.DAO.MeteoDAO;


public class Model {
	
	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;
	private MeteoDAO meteodao;

	public Model() {
		this.meteodao =  new MeteoDAO();
		
	}
	
	// of course you can change the String output with what you think works best
	
	public Map<String, Double> getUmiditaMedia(String mese) {
		
		//List<String> temp = new LinkedList<String>();
		Map<String, Double> umidita = new HashMap<String,Double>();
		
		for(Rilevamento r: this.meteodao.getAllRilevamenti()) {
			
			int sommaUmidita = 0; 
			double averageUmi = 0;
			
				for(Rilevamento rr: this.meteodao.getAllRilevamentiLocalitaMese(mese, r.getLocalita())) {
					sommaUmidita += rr.getUmidita();
				}
			
			averageUmi = sommaUmidita / this.meteodao.getAllRilevamentiLocalitaMese(mese, r.getLocalita()).size();
			umidita.put(r.getLocalita(), averageUmi);
			
		}
		
		return umidita;
	}
	
	// of course you can change the String output with what you think works best
	public String trovaSequenza(int mese) {
		return "TODO!";
	}
	
	

}
