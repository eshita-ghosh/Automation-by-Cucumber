Feature: github.com website automation with cucumber

  Scenario Outline: user search a repo named "create-react-app"
    Given user visits the website
    When user input the search "<keyword>"
    Then search result display and verify with "<repoName>"
    And user click on about page
    Then user verify the about page
    Examples:
    | keyword          | repoName                  |
    | create-react-app | facebook/create-react-app |