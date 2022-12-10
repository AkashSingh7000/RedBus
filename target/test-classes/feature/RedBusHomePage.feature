Feature: UI Automation of RedBus

  @Test
  Scenario: Validation of RedBus functionality

    Given user is inside redbus homepage
    When user enters from city for source
    And user enters to city for destination
    And user select date for journey
    Then user click on search buses
    Then user click on view seats
    And user selected the seat
    Then user selected the boarding point of source
    And user selected the dropping point of destination
    Then user click on Proceed To Book

