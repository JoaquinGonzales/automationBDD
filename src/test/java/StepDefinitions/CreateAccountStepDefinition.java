package StepDefinitions;

import Pages.HomePage;
import Pages.ClientPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class CreateAccountStepDefinition {

    WebDriver driver = DriverManager.getDriver();
    private HomePage homePage = new HomePage(driver);
    private ClientPage clientPage = new ClientPage(driver);
    @Given("Se abre el navegador y se abre la app")
    public void se_abre_el_navegador_y_se_abre_la_app() {
        homePage.goToHome();
    }

    @When("el Usuario hace click en la Opcion Cliente en el menu")
    public void el_Usuario_hace_Click_en_la_Opcion_Cliente_en_el_menu() {
        homePage.clickOnMenuClient();
    }

    @And("el usuario hace click en el boton Crear nueva cuenta")
    public void el_usuario_hace_click_en_el_boton_crear_nueva_cuenta() {
        clientPage.clickOnCreateNewClientButton();
    }

    @And("el usuario llena el formulario con {string} como nombre y {string} CI")
    public void el_usuario_llena_el_formulario_con_como_nombre_y_ci(String name, String ci) {
        clientPage.fillForm(name,ci);
    }

    @And("el usuario selecciona {string} como Grupo Cliente")
    public void el_usuario_selecciona_como_grupo_cliente(String clientGroup) {
        clientPage.selectValueInDropDown(clientGroup);
    }

    @And("el usuario hace click en el boton Guardar")
    public void el_usuario_hace_click_en_el_boton_guardar() {
        clientPage.clickSaveButton();
    }

    @Then("un nuevo cliente {string} ha sido creado")
    public void un_nuevo_cliente_ha_sido_creado(String clientName) {
        Assert.assertTrue("Cliente creado", clientPage.userAddedToTheTable(clientName));
        DriverManager.closeDriver();
    }

    @And("el Usuario hace click en el boton eliminar del cliente {string}")
    public void el_usuario_hace_click_en_el_boton_eliminar_del_cliente(String string) {
        clientPage.clickDeleteButtonLastRecord();
    }

    @And("el Usuario confirma en el popup de confirmacion")
    public void el_usuario_confirma_en_el_popup_de_confirmacion() {
        clientPage.clickAcceptAlert();
    }

    @Then("el usuario {string} ha sido eliminado")
    public void el_usuario_ha_sido_eliminado(String clientName) {
        Assert.assertTrue("cliente Elimindao",clientPage.clientIsNotLongerPresent(clientName));
        DriverManager.closeDriver();
    }
}
