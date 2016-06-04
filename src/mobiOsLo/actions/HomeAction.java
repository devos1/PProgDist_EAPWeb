package mobiOsLo.actions;
import com.opensymphony.xwork2.Action;

public class HomeAction implements Action {

	private String mainTitle;

	@Override
	public String execute() throws Exception {
		
		setMainTitle("Accueil Stations");	
		return SUCCESS;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
}
