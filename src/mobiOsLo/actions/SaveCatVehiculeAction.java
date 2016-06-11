package mobiOsLo.actions;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.opensymphony.xwork2.ActionSupport;
import entities.CategorieVehicule;
import session.IMobiOsLo;
import session.PersistException;

@Results({ @Result(name = "success", type = "chain", location = "list-cat-vehicules"),
	@Result(name="input", location="edit-catVehicule.jsp") })
@SuppressWarnings("serial")
public class SaveCatVehiculeAction extends ActionSupport {
	
	private CategorieVehicule categorieVehicule;

	public String execute(){
		try {
			Context ctx = new InitialContext();
			IMobiOsLo service = (IMobiOsLo) ctx.lookup("java:global/PProgDist_EAP/PProgDist_EAPEJB/MobiOsLoService!session.IMobiOsLo");
			service.addCatVehicule(categorieVehicule);
		} catch (PersistException pe) {
			pe.printStackTrace();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
		return SUCCESS;
	}
	
	public CategorieVehicule getCategorieVehicule() {
		return categorieVehicule;
	}

	public void setCategorieVehicule(CategorieVehicule categorieVehicule) {
		this.categorieVehicule = categorieVehicule;
	}
}
