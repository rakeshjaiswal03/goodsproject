 @ACS_BIAL @Import
Feature: Import1
  
Background: Launch application & login Bial application for e-Booking screen
Given forImport Launch Browser and Bial application link
When forImport Login in Bial application
Then forImport Verify Navigated to Home screen

# added by anita
@import1
Scenario: To verify whether user is able to create Direct Shipment from Add MAWB_HAWB screen
Given forImport Navigate to Create AWB for eAWB screen
Then forImport Verify that balance amount message is displayed for eAWB screen
Then forImport Click in Ok button of message for eAWB screen
When forImport Enter AWB prefix and AWB number for eAWB screen
When forImport Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When forImport Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
When forImport Click on Save eAWB button for eAWB screen
Then forImport Verify Success message is displayed for eAWB screen
When forImport Click on "Imports" mode.
Then forImport Click on "Add MAWB/HAWB"  button
When forImport Enter all the MAWB Details and click on Save button.
When forImport Click on "OK" button of Shipment details saved successfully message dialogue.



