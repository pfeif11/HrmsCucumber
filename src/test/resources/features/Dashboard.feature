#Author: pfeif11@vt.edu
Feature: Dashboard menu view for Admin

  Scenario: 
    Given user is logged into HRMS with Admin Credentials
    Then user should see dashboard menu is displayed
      | Admin | PIM | Leave | Time | Recruitment | Performance | Dashboard | Directory |
