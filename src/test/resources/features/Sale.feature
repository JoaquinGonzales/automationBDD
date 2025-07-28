Feature: Modulo Ventas
  Como Cliente de la aplicacion
  Requiero crear una venta
  donde pueda agregar productos y ver los totales

  Scenario: Crear una venta
    Given Se abre el navegador y se abre la app
    When El usuario hace click en la opcion Ventas en la barra de menu
    And el usuario selecciona "EQUIPOS" un grupo de productos
    And el usuario selecciona un producto
    And el usuario busca su codigo ingresando "CLI001" y hace click en el boton buscar
    And el usuario seleccion "Efectivo" como condicion de pago
    And el usuario hace click en el boton Pagar
    Then la venta ha sido registrada

