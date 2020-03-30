package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.DriverFactory;
import lombok.extern.log4j.Log4j2;
import page.AbstractPageObject;

@Log4j2
public class InscriptionPage extends AbstractPageObject{
	
	@FindBy(xpath ="//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[1]/div/div[3]/div/label")
	private WebElement titrePage;
	
	@FindBy(name = "first_name")
	private WebElement txtPrenom;
	
	@FindBy(name = "last_name")
	private WebElement txtNom;
	
	@FindBy(name = "email")
	private WebElement txtEmail;
	
	@FindBy(name = "password")
	private WebElement txtMotPasse;
	
	@FindBy(name = "password_confirmation")
	private WebElement txtConfirmezMotPasse;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[1]/div/div[3]/form/div[1]/div[6]/label[2]")
	private WebElement radioBtnAccepterConditions;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[1]/div/div[3]/form/div[1]/div[7]/button")
	private WebElement btnInscription;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[1]/div/div[3]/form/div[1]/div[3]/div/div/div[2]/div")
	private WebElement messageErreurEmail;
	
	public void remplirChampPrenom(String prenom) {
		try {
			txtPrenom.clear();
			txtPrenom.sendKeys(prenom); 
		} catch (Exception ex) {
			log.error("Le champ prenom n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public void remplirChampNom(String nom) {
		try {
			txtNom.clear();
			txtNom.sendKeys(nom); 
		} catch (Exception ex) {
			log.error("Le champ nom n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public void remplirChampEmail(String email) {
		try {
			txtEmail.clear();
			txtEmail.sendKeys(email);
		} catch (Exception ex) {
			log.error("Le champ email n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public void remplirChampMotPasse(String motPasse) {
		try {
			txtMotPasse.clear();
			txtMotPasse.sendKeys(motPasse);
		} catch (Exception ex) {
			log.error("Le champ Mot de passe n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public void remplirChampConfirmezMotPasse(String motPasse) {
		try {
			txtConfirmezMotPasse.clear();
			txtConfirmezMotPasse.sendKeys(motPasse);
		} catch (Exception ex) {
			log.error("Le champ Confirmez votre mot de passe n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public void accepterConditionsUtilisationJobslake () {
		try {
			radioBtnAccepterConditions.click();
		} catch (Exception ex) {
			log.error("Le radio boutton  Accepter les conditions d'utilisation  du jobslake n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public void cliquerSurBouttonInscription() {
		try {
			btnInscription.click();
		} catch (Exception ex) {
			log.error("Le boutton inscription n'a pas été trouvé :" + ex.getMessage());
		}
	}
	
	public boolean estOuverte() {
		try {
			return titrePage.getText().equals("Inscrivez vous sur Jobslake");
		} catch (Exception ex) {
			log.error("Erreur d'ouverture de la page Inscription :" + ex.getMessage());
			return false;
		}
	}
	
	public boolean estAfficheMessageErreurEmailInvalide() {
		try {
			return messageErreurEmail.getText().equals("Inscrivez vous sur Jobslake");
		} catch (Exception ex) {
			log.error("Problème d'affiche de message d'erreur :" + ex.getMessage());
			return false;
		}
	}
	
	
}
