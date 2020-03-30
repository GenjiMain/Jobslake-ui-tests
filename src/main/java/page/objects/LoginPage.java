package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.extern.log4j.Log4j2;

import page.AbstractPageObject;

@Log4j2
public class LoginPage extends AbstractPageObject {
	
	@FindBy(id = "input-10")
	private WebElement txtEmail;

	@FindBy(id = "input-13")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[3]/div/form/div[1]/div[4]/button")
	private WebElement btnSeConnecter;
	                
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[3]/div/form/div[1]/div[1]/div/div/div[2]/div/div/div")
	private WebElement messageErreurConnexion;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[1]/a")
	private WebElement btnSinscrire;
	
	public void remplirChampEmail(String email) {
		try {
			txtEmail.sendKeys(email);
		} catch (Exception ex) {
			log.error("Le champ email n'a pas été trouvé :" + ex.getMessage());
			//throw (ex);
		}
	}
	
	public void remplirChampMotDePasse(String password) {
		try {
			txtPassword.sendKeys(password);
		} catch (Exception ex) {
			log.error("Le champ mot de passe n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public void cliquerSurBoutonConnexion(){
		try {
			btnSeConnecter.click();
		} catch (Exception ex) {
			log.error("Le bouton Se Connecter n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public boolean estAfficheMessageErreur(String message) {
		try {
			 return messageErreurConnexion.getText().equals(message);
		} catch (Exception ex) {
			log.error("Le message d'erreur n'a pas été trouvé :" + ex.getMessage());
			return false;
		}
	}
	
	public void afficherPageInscription() {
		try {
			 btnSinscrire.click();
		} catch (Exception ex) {
			log.error("Le boutton s'inscrire n'a pas été trouvé :" + ex.getMessage());
			throw (ex);
		}
	}
	
}
