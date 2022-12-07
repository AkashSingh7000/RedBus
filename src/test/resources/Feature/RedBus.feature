Feature: UI Automation of RedBus

  Scenario Outline: Validation of RedBus functionality

    Given user is inside redbus homepage
    When user enters "<From>" city
    And user enters "<To>" city"
    And user select "<Date>" for journey
    Then user click on search buses
    Then user click on view seats for "<Bus>"
    And user selected the seat

  Examples:
    |From              |To        |Date       |Bus         |
    |Esplanade, Kolkata|Jamshedpur|31-Dec-2022|Baba Travels|
