Feature: Cuenta
    Como Usuario de la aplicacion
    Requiero crear una nueva cuenta en la aplicacion
    Para poder usar el usuario para realizar compras
  Scenario: Crear una nueva cuenta
    Given Se abre el navegador y se abre la app
    When el Usuario hace click en la Opcion Cliente en el menu
    And el usuario hace click en el boton Crear nueva cuenta
    And el usuario llena el formulario con "Joaquin Gonzales" como nombre y "12345" CI
    And el usuario selecciona "CONSTRUCTORAS" como Grupo Cliente
    And el usuario hace click en el boton Guardar
    Then un nuevo cliente "Joaquin Gonzales" ha sido creado

  Scenario: Eliminacion de una cuenta
    Given Se abre el navegador y se abre la app
    When el Usuario hace click en la Opcion Cliente en el menu
    And el Usuario hace click en el boton eliminar del cliente "Joaquin Gonzales"
    And el Usuario confirma en el popup de confirmacion
    Then el usuario "Joaquin Gonzales" ha sido eliminado

