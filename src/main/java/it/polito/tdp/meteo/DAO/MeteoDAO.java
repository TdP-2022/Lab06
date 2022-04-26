package it.polito.tdp.meteo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.meteo.model.Rilevamento;

public class MeteoDAO {
	
	public List<Rilevamento> getAllRilevamenti() {

		final String sql = "SELECT Localita, Data, Umidita "
				+ "FROM situazione "
				+ "GROUP BY Localita,Data,Umidita";

		List<Rilevamento> rilevamenti = new ArrayList<Rilevamento>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Rilevamento r = new Rilevamento(rs.getString("Localita"), rs.getDate("Data"), rs.getInt("Umidita"));
				rilevamenti.add(r);
			}

			conn.close();
			st.close();
			rs.close();
			return rilevamenti;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Rilevamento> getAllRilevamentiLocalitaMese(String mese, String localita) {

		final String sql = "SELECT Localita,Umidita,Data "
				+ "FROM situazione "
				+"WHERE Data >= '2013' ? '01' AND Data <= '2013' ? ? "
				+"ORDER BY Data ASC";
	
		
		List<Rilevamento> rilevamenti = new LinkedList<Rilevamento>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
            st.setString(1, mese);
            st.setString(2,mese);
            
            if(mese.compareTo("04")==0 || mese.compareTo("06")==0 || mese.compareTo("09")==0 || mese.compareTo("11")==0) 
            	st.setString(3, "30");
            
            else
            	st.setString(3, "31");
            
            if(mese.compareTo("02")==0) 
            	st.setString(3,"28");
            
            
           
			ResultSet rs = st.executeQuery();

			
			while (rs.next()) {

				Rilevamento r = new Rilevamento(rs.getString("Localita"), rs.getDate("Data"), rs.getInt("Umidita"));
				if(rs.getString("Localita").compareTo(localita)==0 ) 
					//if(r.transformDate(r.getData()).substring(5,7).compareTo(String.valueOf(mese))==0) 
						rilevamenti.add(r);
				
			}

			conn.close();
			
			return rilevamenti;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}


}
