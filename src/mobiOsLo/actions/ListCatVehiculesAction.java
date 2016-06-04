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
@Result(name="success", location="list-catVehicules.jsp")
public class ListCatVehiculesAction extends ActionSupport {
	
	List<CategorieVehicule> catVehicules;

	public List<CategorieVehicule> getCatVehicules() {
		return catVehicules;
	}

	public void setCatVehicules(List<CategorieVehicule> catVehicules) {
		this.catVehicules = catVehicules;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("OK Arrivé");
		try {
			Context ctx = new InitialContext();
			IMobiOsLo service = (IMobiOsLo) ctx.lookup("java:global/PProgDist_EAP/PProgDist_EAPEJB/MobiOsLoService!session.IMobiOsLo");
			catVehicules = service.getCatVehicules();
		}catch (PersistException pe){ 
			pe.printStackTrace();
		}catch (NamingException ne){
			ne.printStackTrace();
		}
		return SUCCESS;
	}
	
}
