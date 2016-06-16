package mobiOsLo.actions;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;
import session.*;
import entities.*;

@SuppressWarnings("serial")
@Result(name="success", location="list-stations.jsp")
public class ListStationsAction extends ActionSupport{
		
	List<Station> stations;

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	
	@Override
	public String execute() throws Exception {
		try {
			Context ctx = new InitialContext();
			IMobiOsLo service = (IMobiOsLo) ctx.lookup("java:global/PProgDist_EAP/PProgDist_EAPEJB/MobiOsLoService!session.IMobiOsLo");
			stations = service.getStations();
			if (stations != null) {
				for (Station station : stations) {			
					station.setNbAutosDispos(station.cptVehiculesLibres(EnumTypePlace.Voiture));
					station.setPlacesLibres(station.cptPlacesLibres(EnumTypePlace.Voiture));
				}
			}
		} catch (PersistException pe) {
			pe.printStackTrace();
		} catch (NamingException ne){
			ne.printStackTrace();
		}
		return SUCCESS;
	}
}
