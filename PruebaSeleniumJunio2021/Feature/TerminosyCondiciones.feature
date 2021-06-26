Feature:Terminos

  Scenario Outline: Terminos
    Given estar en sitio de terminos y condiciones
    When buscar enlaces
    Then validar algunos enlaces <links>

    Examples:
      | links                                       |
      |Disfrutando Spotify                          |
      |Pagos, cancelaciones y periodo de reflexión  |
      | Uso de nuestro servicio                     |