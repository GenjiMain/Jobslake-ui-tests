package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.Browser;
import driver.DriverFactory;
import lombok.extern.log4j.Log4j2;
import page.AbstractPageObject;

@Log4j2
public class DashboardPage extends AbstractPageObject{

	@FindBy(xpath ="//*[@id=\"app\"]/div/div[1]/header/div/div[1]")
	private WebElement titrePage;
	
	@FindBy(xpath = " //*[@id='app']/div[3]/div/div/div[2]/button") // "//button[contains(.,'J'AI COMPRIS')]" 
	private WebElement btnJaiCompris;									  
	
	private Menu menu;
	
	public DashboardPage() {
		menu = new Menu();
	}

	public Menu menu() {
		return menu;
	}

	public void fermerAlertDashboard(){
		try {
			Browser.waitForElementToBeVisible(btnJaiCompris, 10);
			btnJaiCompris.click();
		} catch (Exception ex) {
			log.error("Le bouton j'ai compris n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public boolean estOuverte() {
		try {
			return titrePage.getText().equals("Dashboard");
		} catch (Exception ex) {
			log.error("Erreur d'ouverture de la page Dashboard :" + ex.getMessage());
			throw(ex);
		}
	}
}
