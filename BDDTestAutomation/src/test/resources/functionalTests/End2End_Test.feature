@demo
Feature: Login Action

  @demo
  Scenario Outline: Validating the Gumtree links in Google Search Page
    Given user is on Google Home Page
    When he search for as <SearchInput>
    And validate how many Gumtree links there are available <Links>
    And navigate to each Gumtree link <Links>
    And verify the number of results <Links>
    And Close the application

    Examples:
      | SearchInput|Links|
      | Cars in London|gumtree|
