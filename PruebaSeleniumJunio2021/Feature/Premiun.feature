Feature:Premiun

  Scenario Outline:Premiun
    Given estoy en la pagina de spotify
    When Presiono en premiun
    Then validos planes <tipos>

    Examples:
      | tipos      |
      | Individual |
      | premium    |
      | familiar   |
