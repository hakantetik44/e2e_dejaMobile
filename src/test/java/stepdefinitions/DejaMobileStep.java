package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.DejaMobilePage;
import utilities.ConfigReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class DejaMobileStep extends BasePage {

    DejaMobilePage dejaMobile = new DejaMobilePage();



    @Given("lutilisateur souhaite se connecter à l'application")
    public void lutilisateurSouhaiteSeConnecterALApplication() throws InterruptedException {
        //TODO Auto-generated constructor

    }

    @When("il accède à l'application DejaMobile")
    public void ilAccedeALApplicationDejaMobile() {
        assertTrue(dejaMobile.logo.isDisplayed());

    }

    @And("l'utilisateur saisit son adresse e-mail valide")
    public void lUtilisateurSaisitSonAdresseEMailValide() {
        dejaMobile.placeEmail.sendKeys(ConfigReader.getProperty("email"));
    }

    @Then("si l'utilisateur saisit un mot de passe invalide")
    public void siLUtilisateurSaisitUnMotDePasseInvalide() {
        dejaMobile.placeMotDePasse.sendKeys(ConfigReader.getProperty("invalidMotDePasse"));

    }

    @And("un message d'erreur saffiche correctement")
    public void unMessageDErreurSafficheCorrectement() throws InterruptedException {
        dejaMobile.btnSeConnecter.click();
        Thread.sleep(3000);
        String expectedMessage = "Le login ou le mot de passe saisi n’est pas correct.\n" +
                "(Code: 02-1901)";
        assertEquals(dejaMobile.textError.getText(), expectedMessage);

    }

    @And("l'utilisateur laisse le champ dadresse e-mail vide")
    public void lUtilisateurLaisseLeChampDadresseEMailVide() {
        dejaMobile.placeEmail.sendKeys("");
    }

    @Then("l'utilisateur laisse le champ du mot de passe vide")
    public void lUtilisateurLaisseLeChampDuMotDePasseVide() {
        dejaMobile.placeMotDePasse.sendKeys("");
    }

    @And("utilisateur voit les champs {string} And {string} sur la page d'accueil")
    public void utilisateurVoitLesChampsAndSurLaPageDAccueil(String expectedText1, String expectedText2) {

    }

    @Then("l'utilisateur saisit ses informations de connexion")
    public void lUtilisateurSaisitSesInformationsDeConnexion() {
    }

    @And("l'utilisateur se connecte à son compte")
    public void lUtilisateurSeConnecteASonCompte() {
    }

    @Then("si l'utilisateur saisit une adresse e-mail invalide")
    public void siLUtilisateurSaisitUneAdresseEMailInvalide() {
        dejaMobile.placeEmail.sendKeys(ConfigReader.getProperty("invalidEmail"));

    }

    @And("un message d'erreur saffiche correctement pour les champs vide")
    public void unMessageDErreurSafficheCorrectementPourLesChampsVide() {

        dejaMobile.btnSeConnecter.click();
       String expectedText= "Email invalide";
       assertTrue(dejaMobile.textErrorLesChampsVides.getText().contains(expectedText));
        System.out.println("expectedText +dejaMobile.textErrorLesChampsVides.getText() = " + expectedText +dejaMobile.textErrorLesChampsVides.getText());
    }

    @Then("si l'utilisateur saisit une mot de passe valide")
    public void siLUtilisateurSaisitUneMotDePasseValide() {
        dejaMobile.placeMotDePasse.sendKeys(ConfigReader.getProperty("motDePasse"));

    }

    @And("l'utilisateur saisit son adresse e-mail invalide")
    public void lUtilisateurSaisitSonAdresseEMailInvalide() {
        dejaMobile.placeEmail.sendKeys(ConfigReader.getProperty("invalidEmail"));
    }
}
