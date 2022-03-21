#author:Juan Esteban

Feature:Actualizacion de usuario
  Yo como usuario del portal
  Necesito verificar la posibilidad de acutualizar mis atributos de usuario
  Para poder realizar cambios dentro de mi perfil cuando sea necesario

@JobActualization
  Scenario: Actualizacion job
    Given el usuario se encuentra en el apartado de actualizacion con el nombre "morpheus" y el job "zion resident"
    When el usuario envia una peticion de respuesta
    Then el sistema debera mostrarle un codigo de respuesta exitoso junto a sus atributos actualizados