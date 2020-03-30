package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.extern.log4j.Log4j2;
import page.AbstractPageObject;

@Log4j2
public class VerificationEmailPage extends AbstractPageObject{

	@FindBy(xpath ="//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div/div/div[2]/h3")
	private WebElement titrePage;
	
	public boolean estOuverte() {
		try {
			log.debug(titrePage.getText());
			return titrePage.getText().contains("Nous vous avons envoyé un mail de vérification de votre adresse email, veuillez valider votre adresse pour continuer.");
		} catch (Exception ex) {
			log.error("Erreur d'ouverture de la page Verification d'email :" + ex.getMessage());
			return false;
		}
	}
}
