package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.AbstractPageObject;

public class Menu extends AbstractPageObject{

	@FindBy(linkText = "/dashboard")
	private WebElement dashboard;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div/aside[1]/div[1]/div[2]/a[2]") //"//a[@href()='/consultants']")
	private WebElement consultants;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/aside[1]/div[1]/div[2]/a[2]/div")
	private WebElement gestionContrat;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/aside[1]/div[1]/div[2]/div[2]")
	private WebElement gestionOffres; //sous-menu
	
	@FindBy(linkText = "/received-applications")
	private WebElement  candidatures;
	
	@FindBy(linkText = "/esn-settings/layouts/resume")
	private WebElement  miseEnPageCV;
  
	@FindBy(linkText = "/messaging/messages")
	private WebElement  messagerie;
	
	@FindBy(linkText = "/search")
	private WebElement  recherche;
	
	public void dashboard() {
		dashboard.click();
	}
	
	public void consultants() {
		consultants.click();
	}
	
	public void candidatures() {
		candidatures.click();
	}
	
	public void miseEnPageCV() {
		miseEnPageCV.click();
	}
	
	public void messagerie() {
		messagerie.click();
	}
	
	public void recherche() {
		recherche.click();
	}
}
