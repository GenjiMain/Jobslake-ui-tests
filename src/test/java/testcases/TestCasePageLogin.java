package testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lombok.extern.log4j.Log4j2;
import page.objects.DashboardPage;
import page.objects.LoginPage;
import testutil.BaseTest;

@Log4j2
public class TestCasePageLogin {
	BaseTest baseTest;
	LoginPage pageLogin ;
	DashboardPage pageDashboard;

	@BeforeClass
	public void setConfig() {
        baseTest = new  BaseTest();
		baseTest.setConfiguration("dev");
		log.debug("@BeforeClass TestCasePageLogin");
	}
	
	@BeforeMethod
	public void setUp() {
		baseTest.preCondition("chrome");
		pageLogin = new LoginPage();
		pageDashboard = new DashboardPage();
		log.debug("@BeforeMethod TestCasePageLogin");
	}
	
	@Test
	public void tc1_varifier_login_identifiants_valides() {
		pageLogin.remplirChampEmail("Lansrode@mail.com");
		pageLogin.remplirChampMotDePasse("secret");
		pageLogin.cliquerSurBoutonConnexion();
		
		//pageDashboard.fermerAlertDashboard();
		
		assertTrue(pageDashboard.estOuverte());
	}
	
	@Test
	public void tc2_varifier_login_utilisateur_invalide() {
		pageLogin.remplirChampEmail("test");
		pageLogin.remplirChampMotDePasse("test");
		pageLogin.cliquerSurBoutonConnexion();
		
		assertTrue(pageLogin.estAfficheMessageErreur("Email invalide"));
	}
	
	@Test
	public void tc3_varifier_mot_de_passe_invalide() {
		pageLogin.remplirChampEmail("Lansrode@mail.com");
		pageLogin.remplirChampMotDePasse("test");
		pageLogin.cliquerSurBoutonConnexion();
		
		assertTrue(pageLogin.estAfficheMessageErreur("Ces informations d'identification ne correspondent pas à nos enregistrements."));
	}
	
	@AfterMethod
	public void tearDown() {
		baseTest.postCondition();
	}

}
