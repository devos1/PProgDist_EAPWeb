package mobiOsLo.actions;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import entities.CategorieVehicule;
import session.IMobiOsLo;
import session.PersistException;

@SuppressWarnings("serial")
@Result(name="success", type = "chain", location="list-cat-vehicules")
public class DeleteCatVehiculeAction extends ActionSupport implements ServletRequestAware {
	
	private CategorieVehicule categorieVehicule;
	private HttpServletRequest request;
	
	@Override
	public String execute() {
		try {
			Context ctx = new InitialContext();
			IMobiOsLo service = (IMobiOsLo) ctx.lookup("java:global/PProgDist_EAP/PProgDist_EAPEJB/MobiOsLoService!session.IMobiOsLo");
			String cvId = request.getParameter("catVehiculeId");
			if (cvId != null) {
				service.delCatVehicule(Integer.parseInt(cvId));
			}else {
				return ERROR;
			}
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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;	
	}
}
