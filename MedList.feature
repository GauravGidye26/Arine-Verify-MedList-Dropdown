@PharmacistPortal @MedListVerify
Feature: Verify Med List Feature

  @Setup @Regression @Smoke
  Scenario Outline: SETUP: Launch Browser and go to application
    Given User launched "chrome"
    Then User go to application "$pharmacist_portal_url"
    When User login with "<username>" and "<password>"
    And Verify Login message: "<message>"
    Examples:
      | username                        | password                        | message |
      | $patient-MedList.user1.username | $patient-MedList.user1.password | success |

  @Regression @Smoke
  Scenario Outline: verify_medList
    When Click on Patient Tab
    And Search patient: "<searchString>"
    And Click on tab: "Med List"
    Then Click on patient first medicine record
    And User click on "Reasons for Non-adherence" Dropdown and select option "<selectOption>"
    Then Verify "<selectOption>" option is selected in Dropdown field
    And Verify "<selectOption>" option is in SELECTED list section in Dropdown
    And Verify "<selectOption>" option is not in AVAILABLE OPTIONS list section in Dropdown
    Examples:
      | searchString                         | selectOption |
      | 3620b636-5b8e-44b3-8461-130983b7dc4e | Adherent- Billing delay (LTC or SNF) |



  @Setup @Regression @Smoke
  Scenario: SETUP: Logout and Close Browser
    When User logout from the application
    Then User close browser