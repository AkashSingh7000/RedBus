Feature: UI Automation of RedBus

  @Test
  Scenario Outline: Validation of RedBus functionality

    Given user is inside redbus homepage
    When user enters "<From>" city for source
    And user enters "<To>" city for destination
    And user select "<Date>" for journey
    Then user click on search buses
    Then user click on view seats for "<Bus>"
    And user selected the seat
    Then user selected the "<Boarding Point>" of source
    And user selected the "<Dropping Point>" of destination
    Then user click on Proceed To Book


  Examples:
    |From              |To        |Date       |Bus         |Boarding Point                  |Dropping Point       |
    |Esplanade, Kolkata|Jamshedpur|31-Dec-2022|Baba Travels|Babughat,Kolkatta (BABA COUNTER)|Jamshedpur Pardichouk|
