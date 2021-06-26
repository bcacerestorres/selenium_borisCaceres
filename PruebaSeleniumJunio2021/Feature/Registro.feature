Feature:Registro

  Scenario Outline: Registro
    Given estoy en la pagina de spotify
    When presiono en registrarme
    And ingreso correso <tag>
    Then valido mensajes <error>

    Examples:
      | tag            | error                                                                                                 |
      |                | Es necesario que introduzcas tu correo electrónico.                                                   |
      | fff            | Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com  |
      | test@test.com  | Este correo electrónico ya está conectado a una cuenta. Inicia sesión.                                |
