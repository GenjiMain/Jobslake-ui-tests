package testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.DataFactory;
import model.Consultant;
import page.objects.InscriptionPage;
import page.objects.LoginPage;
import page.objects.VerificationEmailPage;
import testutil.BaseTest;

public class TestCaseInscription extends BaseTest{
	LoginPage pageLogin ;
	InscriptionPage pageInscription;
	VerificationEmailPage pageVerificationEmail;
	
	Consultant consultantInformation;

	@BeforeTest
	public void setUp() {
		pageLogin = new LoginPage();
		pageInscription = new InscriptionPage();
		pageVerificationEmail = new VerificationEmailPage();
		
		consultantInformation = new DataFactory().createConsultantData();
	}
	
	@Test
	public void tc1_verifier_affichage_page_inscriptions() {
		pageLogin.afficherPageInscription();
		
		assertTrue(pageInscription.estOuverte());
	}
	
	
}
