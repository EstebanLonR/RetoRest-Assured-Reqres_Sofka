#author:Juan Esteban
Feature: Registro de usuario
  Yo como usuario del sistema
  Necesito validar la operacion de registro de usuario
  Para poder tener control de los usuarios

  @RegisterSuccesfully
  Scenario: Registro Exitoso
    Given el usario se encuentra en la pagina de registro con el correo "eve.holt@reqres.in" y password "pistol"
    When el usuario hace una peticion de respuesta
    Then el sistema debera mostrarle un codigo de respuesta exitoso junto un id y un token