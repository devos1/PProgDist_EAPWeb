package mobiOsLo.actions;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import entities.*;
import session.IMobiOsLo;

@SuppressWarnings("serial")
@Result(name="success", type = "chain", location="list-stations")
public class GererLocationAction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;
	private Station station;
	private CategorieVehicule cv;
	private Vehicule v;
	
	@Override
	public String execute() throws Exception {
		try {
			Context ctx = new InitialContext();
			IMobiOsLo service = (IMobiOsLo) ctx.lookup("java:global/PProgDist_EAP/PProgDist_EAPEJB/MobiOsLoService!session.IMobiOsLo");
			
			// Récupération des paramètres passés dans l'URL
			String action = request.getParameter("action");
			String stationId = request.getParameter("stationId");
			
			// On détermine en dur que l'on veut louer une auto			
			if (action.equals("louer")) {
				// On récupère la bonne station
				station = service.getStation(Integer.parseInt(stationId)); 			
				
				// Récupération d'une catégorie chosie -> dans ce cas la catégore A
				service.removeVehicule(1);			// Ok, Sauf que ID en dur
				cv = service.getCatVehicule(1);				
				v = station.louer(cv);
				
				// Pour debug
				System.out.println("LOUER" + v.toString());
			}else if (action.equals("rendre")) {
				// On récupère la bonne station
				station = service.getStation(Integer.parseInt(stationId)); 	
				
				// Récupération du véhicule
				// Ici on choisit manuellement le numéro 1
				v = service.getVehicule(1);
				Place p = station.rendre(v);
				service.attributePlaceToVehicule(v,p);
				
				// Pour debug
				System.out.println("RENDRE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	
	
}
