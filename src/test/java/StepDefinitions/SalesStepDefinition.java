package StepDefinitions;

import Pages.HomePage;
import Pages.SalePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManager;

public class SalesStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    SalePage salePage = new SalePage(driver);

    @When("El usuario hace click en la opcion Ventas en la barra de menu")
    public void el_usuario_hace_click_en_la_opcion_ventas_en_la_barra_de_menu() {
        homePage.clickOnMenuSales();
    }

    @And("el usuario selecciona {string} un grupo de productos")
    public void el_usuario_selecciona_un_grupo_de_productos(String productGroup) {
        salePage.setProductGroupInDropDown(productGroup);
    }

    @And("el usuario selecciona un producto")
    public void el_usuario_selecciona_un_producto() {
        salePage.clickOnAddButtonForFirstElement();
    }

    @And("el usuario busca su codigo ingresando {string} y hace click en el boton buscar")
    public void el_usuario_busca_su_codigo_ingresando_y_hace_click_en_el_boton_buscar(String clientCode) {
        salePage.setClientCodeInField(clientCode);
    }

    @When("el usuario hace click en el boton Pagar")
    public void el_usuario_hace_click_en_el_boton_pagar() {
        salePage.clickOnPayButton();
    }

    @Then("la venta ha sido registrada")
    public void la_venta_ha_sido_registrada() {
        Assert.assertTrue("Compra Registrada Satisfactoriamente",salePage.saleRegisteredSuccessfully());
        DriverManager.closeDriver();
    }
}
