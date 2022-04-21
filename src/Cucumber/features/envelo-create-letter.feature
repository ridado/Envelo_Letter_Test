Feature: Create letter

  Scenario Outline: User can create a letter
    Given user is on main page and click on zaloguj się button and input "<email>" and "<password>"
    When user clicks on incoming box, choose nowa przesyłka, Neolist
    When user fills recipient data, list tile and add file
    And  check is file name correct and clicks send button
    Then clicks add to cart button and chcecks is price correct

    Examples:
    |email                 |password     |
    |ttesterski10@gmail.com|Testing!@#456|
