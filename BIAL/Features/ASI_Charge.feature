@ASI_Charge @ACS_BIAL @Export
Feature: ASI & Charge
  
Background: Launch application & login Bial application for ASI and Charge
Given Launch Browser and Bial application link for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge


@TS14090901 @Verify_ASI_CO_SingleSB_forDirectShipment
Scenario Outline: TS14090901 To verify whether user is able to perform ASI submission and charge collection for direct shipment with one SB 
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
#When Select "Rates as agreed" checkbox for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
#----
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs |length|width |height|grWt  |rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS 			 |10    |10    |10    |10    |100   |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
@TS14090902 @Verify_ASI_CO_SingleSB_forUpdatedDirectShipmentAndUpdatedSB
Scenario Outline: TS14090902 To verify whether user is able to perform ASI submission and charge collection for direct shipment with one or more SB with the updated MAWB and SB details 
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge

When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "Edit" icon of 1 mawb for ASI and Charge
Then Naviaged to Create AWB screen for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Edit "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
#When Edit "<chargeCode>" "Charge Code" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And  CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge

Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Edit SB date of 1 SB details row for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details updated successfully." message for ASI and Charge

When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker  |noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS         |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
 
 
 @TS14090903
Scenario Outline: TS14090903 To verify whether once the MAWB is deleted, the attached SB is removed and the paid ACS charge is reverted back to the customers PD Account
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Edit" icon of 1 mawb for ASI and Charge
Then Naviaged to Create AWB screen for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Edit "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
#When Edit "<chargeCode>" "Charge Code" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
And The attached SB should be removed and the MAWB should be deleted

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS|10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
 
 
  
  @TS14090904 @VerifySingleSB_forDirectShipmentWithoutMawbASI
Scenario Outline: TS14090904 To verify whether user is not allowed to do SB ASI before MAWB ASI
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
And Unable SB ASI submit without MAWB ASI submit and 1 SB ASI icon is disabled for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Manual|
  
  
  @TS14090905 @Verify_CO_forDirectShipmentWithoutMawbASI
Scenario Outline: TS14090905 To verify whether user is not allowed to do CO for the shipment of which the MAWB ASI is not done
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Unable send carting order request without MAWB ASI submit and 1 CO icon is disabled for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |
  
  
  
  @TS14090906 @Verify_ASI_CO_MultipleSB_forDirectShipment
Scenario Outline: TS14090906 To verify whether user is able to perform ASI submission and charge collection for direct shipment with multiple SB
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
# added by Rakesh
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge

When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcsSB1>" and "<length>" and "<width>" and "<height>" and "<grWtSB1>" for ASI and Charge
When Click on "Add Row" icon of shipping bill details screen for ASI and Charge 
When Add 2 shipping bill details with "<sbType>" and "<noPcsSB2>" and "<length>" and "<width>" and "<height>" and "<grWtSB2>" for ASI and Charge
When Click on "Add Row" icon of shipping bill details screen for ASI and Charge 
When Add 3 shipping bill details with "<sbType>" and "<noPcsSB3>" and "<length>" and "<width>" and "<height>" and "<grWtSB3>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Select "Select All" checkbox of SB ASI Submission grid for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|noPcsSB1|grWtSB1|noPcsSB2|grWtSB2|noPcsSB3|grWtSB3|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|3       |30     |4       |40     |3       |30     |
  
  
  @TS14090907 @Verify_ASI_CO_SingleSB_forConsolShipment
Scenario Outline: TS14090907 To verify whether user is able to perform ASI submission and charge collection for direct shipment with one SB
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Select "Consol" radio button for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
Then Consol Message popup opened with "Do you want to create House Air Waybill first?" message for ASI and Charge
When Click on "Yes" button of Consol Message popup for ASI and Charge
Then House Manifest popup opened for ASI and Charge
When Add 1 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH1>" and "<chargeCode>" and "<cargoDesctiionH1>" for ASI and Charge
When HouserManifestPopupAddRowIcon
When Add 2 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH2>" and "<chargeCode>" and "<cargoDesctiionH2>" for ASI and Charge
When Click on "Save" button of House Manifest popup for ASI and Charge
Then Hawb detils get saved and able to see "HAWB Details saved successfully" message for ASI and Charge
When Click on "Close" button of House Manifest popup for ASI and Charge
Then Houser manifest popup closed and HAWB grid displayed on Create AWB screen for ASI and Charge
#When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" for ASI and Charge
#When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge

When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "Edit" icon of 1 mawb for ASI and Charge
Then Naviaged to Create AWB screen for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Edit "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Edit "<chargeCode>" "Charge Code" for ASI and Charge
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" for ASI and Charge
Then Add chargeble weight as"200"
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge

When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<nopH1>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Add Row" icon of shipping bill details screen for ASI and Charge 
When Add 2 shipping bill details with "<sbType>" and "<nopH2>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Select "Select All" checkbox of SB ASI Submission grid for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|originCode|destCode|nopH1|grwtH1|chargeCode|cargoDesctiionH1|nopH2|grwtH2|cargoDesctiionH2   |flightCode|customBroker								 |noPcs|length|width|height|grWt|rateClass|rate|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|BLR       |ATL     |4    |50    |PP        |Auto Parts      |4    |50    |Electrical Material|ZZ        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |AWC           |100             |Kale Airline 1|Manual|
  
  
  @TS14090908 @Verify_ASI_CO_SingleSB_forConsolShipmentWithUpdatedSB
Scenario Outline: TS14090908 To verify whether user is able to perform ASI submission and charge collection for consol shipment with one or more SB with the updated HAWB and SB details
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Select "Consol" radio button for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
Then Consol Message popup opened with "Do you want to create House Air Waybill first?" message for ASI and Charge
When Click on "Yes" button of Consol Message popup for ASI and Charge
Then House Manifest popup opened for ASI and Charge
When Add 1 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH1>" and "<chargeCode>" and "<cargoDesctiionH1>" for ASI and Charge
When HouserManifestPopupAddRowIcon
When Add 2 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH2>" and "<chargeCode>" and "<cargoDesctiionH2>" for ASI and Charge
When Click on "Save" button of House Manifest popup for ASI and Charge
Then Hawb detils get saved and able to see "HAWB Details saved successfully" message for ASI and Charge
When Click on "Close" button of House Manifest popup for ASI and Charge
Then Houser manifest popup closed and HAWB grid displayed on Create AWB screen for ASI and Charge
#When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
# added by Rakesh
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge

When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<nopH1>" and "<length>" and "<width>" and "<height>" for ASI and Charge__
When Click on "Add Row" icon of shipping bill details screen for ASI and Charge 
When Add 2 shipping bill details with "<sbType>" and "<nopH2>" and "<length>" and "<width>" and "<height>" for ASI and Charge__
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge

Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Edit SB date of 1 SB details row for ASI and Charge_
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details updated successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge

Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Select "Select All" checkbox of SB ASI Submission grid for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|originCode|destCode|nopH1|grwtH1|chargeCode|cargoDesctiionH1|nopH2|grwtH2|cargoDesctiionH2   |flightCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|BLR       |ATL     |2    |50    |PP        |Auto Parts      |2    |50    |Electrical Material|ZZ        |JEENA N CO GLOBAL LOGISTICS  |10   |10    |10   |10    |100 |Q        |20  |AWC           |100             |Kale Airline 1|Manual|
  
  
  @TS14090909 @Verify_ASI_CO_SingleSB_forConsolShipment
Scenario Outline: TS14090909 To verify whether user is able to perform ASI submission and charge collection for direct shipment with one SB
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Select "Consol" radio button for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
Then Consol Message popup opened with "Do you want to create House Air Waybill first?" message for ASI and Charge
When Click on "Yes" button of Consol Message popup for ASI and Charge
Then House Manifest popup opened for ASI and Charge
When Add 1 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH1>" and "<chargeCode>" and "<cargoDesctiionH1>" for ASI and Charge
When HouserManifestPopupAddRowIcon
When Add 2 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH2>" and "<chargeCode>" and "<cargoDesctiionH2>" for ASI and Charge
When Click on "Save" button of House Manifest popup for ASI and Charge
Then Hawb detils get saved and able to see "HAWB Details saved successfully" message for ASI and Charge
When Click on "Close" button of House Manifest popup for ASI and Charge
Then Houser manifest popup closed and HAWB grid displayed on Create AWB screen for ASI and Charge
#When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
#Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
#When Click on "Edit" icon of 1 mawb for ASI and Charge
#Then Naviaged to Create AWB screen for ASI and Charge
#Then Verify that balance amount message popup is displayed for ASI and Charge
#When Click on "Ok" button of message popup for ASI and Charge
#When Click on "Routing Info" icon to add rounting details for ASI and Charge
#Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
#When Edit "<destCode>" "Destination Code" for ASI and Charge
#When Click on "Ok" button of Routing Details popup for ASI and Charge
#Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
#When Edit "<chargeCode>" "Charge Code" for ASI and Charge
#When Click on "Save" button for ASI and Charge
#Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
#When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<nopH1>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Add Row" icon of shipping bill details screen for ASI and Charge 
When Add 2 shipping bill details with "<sbType>" and "<nopH2>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Select "Select All" checkbox of SB ASI Submission grid for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add HAWB" icon of 1 mawb for ASI and Charge
Then Navigated to House Manifest screen for ASI and Charge
When Click on "Delete" icon of 2 hawb row for ASI and Charge
Then HAWB Deletion popup is opened with "Deleting HAWB will delete Shipping Bills attached to the HAWB." message for ASI and Charge
When Click on "Yes" button of HAWB Deletion popup for ASI and Charge
Then HAWB Message popup is opened with "HAWB deleted successfully." message for ASI and Charge
When Click on "Ok" button of HAWB Message popup for ASI and Charge
Then HAWB details get deleted successfully for ASI and Charge
When Click on "Save" button of House Manifest screen for ASI and Charge
Then House Manifest Status popup opened for ASI and Charge
When Click on "Ok" button of House Manifest Status popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
And SB details get deleted of a hawb for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|originCode|destCode|nopH1|grwtH1|chargeCode|cargoDesctiionH1|nopH2|grwtH2|cargoDesctiionH2   |flightCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|BLR       |ATL     |2    |50    |PP        |Auto Parts      |2    |50    |Electrical Material|ZZ        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |AWC           |100             |Kale Airline 1|Manual|
  
 @TS14090910 @Verify_ASI_CO_SingleSB_forConsolShipmentWithMutlipleSB
Scenario Outline: TS14090910 To verify whether user is able to perform ASI submission and charge collection for consol shipment with multiple SB's and multiple HAWBs
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Select "Consol" radio button for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
Then Consol Message popup opened with "Do you want to create House Air Waybill first?" message for ASI and Charge
When Click on "Yes" button of Consol Message popup for ASI and Charge
Then House Manifest popup opened for ASI and Charge
When Add 1 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH1>" and "<chargeCode>" and "<cargoDesctiionH1>" for ASI and Charge
When HouserManifestPopupAddRowIcon
When Add 2 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH2>" and "<chargeCode>" and "<cargoDesctiionH2>" for ASI and Charge
When Click on "Save" button of House Manifest popup for ASI and Charge
Then Hawb detils get saved and able to see "HAWB Details saved successfully" message for ASI and Charge
When Click on "Close" button of House Manifest popup for ASI and Charge
Then Houser manifest popup closed and HAWB grid displayed on Create AWB screen for ASI and Charge
#When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge

When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "Edit" icon of 1 mawb for ASI and Charge
Then Naviaged to Create AWB screen for ASI and Charge

Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Edit "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
#When Edit "<chargeCode>" "Charge Code" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<nopH1>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Add Row" icon of shipping bill details screen for ASI and Charge 
When Add 2 shipping bill details with "<sbType>" and "<nopH2>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Select "Select All" checkbox of SB ASI Submission grid for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|originCode|destCode|nopH1|grwtH1|chargeCode|cargoDesctiionH1|nopH2|grwtH2|cargoDesctiionH2   |flightCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|BLR       |ATL     |4    |50    |PP        |Auto Parts      |4    |50    |Electrical Material|ZZ        |JEENA N CO GLOBAL LOGISTICS   |10   |10    |10   |10    |100 |Q        |20  |AWC           |100             |Kale Airline 1|Manual|
  
@TS14090911 @Verify_ASI_CO_SingleSB_forDirectShipment_ReSubmitSB_ASI
Scenario Outline: TS14090911 To verify whether when submitted ASI, the status marked as Submitted and “Re-submit Advance Shipment Info.” icon is displayed on MAWB saved screen
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
# added by Rakesh
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge

When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
And SB ASI already submited and Resubmit icon instead of submit icon with "Resubmit" title for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS   |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
 @TS14090912 
 Scenario Outline: TS14090912 To verify whether error message is displayed while submitting ASI when theres no balance available in PD Account
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with username "KLTesting"and password"Kl12345678" in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
#####----loggin 
When Login with username "KLTesting"and password"Kl12345678" in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI confirmation popup opened with "Amount is still not deposited in ACS PD account. Please deposit the amount in ACS PD account and Create request to proceed further." message for ASI and Charge


Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker |noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS 			 |ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS|10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
  
  
  
  
  
  @TS14090913 @Verify_ASI_CO_SingleSB_forDirectShipment_UpdateAndDeleteSB
Scenario Outline: TS14090913 To verify whether user is able to update or delete the SB details for MAWB or HAWB shipment by clicking on SB No hyperlink
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
# added by Rakesh
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge

When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB No" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
Then Edit 1 shipping bill details with "120" chargebel weight for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." and "Please Resubmit SB ASI." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS   |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
  
  
  
  @TS14090914 @Verify_ASI_CO_SingleSB_forDirectShipment
Scenario Outline: TS14090914 To verify whether user is able to delete the direct shipment
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge

When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge

When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
# added by Rakesh
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge

When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Delete" icon of 1 mawb for ASI and Charge
Then MAWB Deletion popup opened with "Deleting MAWB will delete Shipping Bills attached to the MAWB." message for ASI and Charge
When Click on "Yes" button of MAWB Deletion popup for ASI and Charge
Then MAWB Deletion Message opened with "deleted successfully." message for ASI and Charge
When Click on "Ok" button of MAWB Deletion Message popup for ASI and Charge
Then MAWB get successfully deleted for ASI and Charge


Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
  
    @TS14090915 @Verify_ASI_CO_SingleSB_forConsolShipment
Scenario Outline: TS14090915 To verify whether user is able to delete the consol shipment
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Select "Consol" radio button for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
Then Consol Message popup opened with "Do you want to create House Air Waybill first?" message for ASI and Charge
When Click on "Yes" button of Consol Message popup for ASI and Charge
Then House Manifest popup opened for ASI and Charge
When Add 1 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH1>" and "<chargeCode>" and "<cargoDesctiionH1>" for ASI and Charge
When HouserManifestPopupAddRowIcon
When Add 2 house details with hawb no and "<shipperName>" and "<consgineeName>" and "<originCode>" and "<destCode>" and "5" and "<grwtH2>" and "<chargeCode>" and "<cargoDesctiionH2>" for ASI and Charge
When Click on "Save" button of House Manifest popup for ASI and Charge
Then Hawb detils get saved and able to see "HAWB Details saved successfully" message for ASI and Charge
When Click on "Close" button of House Manifest popup for ASI and Charge
Then Houser manifest popup closed and HAWB grid displayed on Create AWB screen for ASI and Charge
#When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge

When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
# added by Rakesh
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge

When Click on "Edit" icon of 1 mawb for ASI and Charge
Then Naviaged to Create AWB screen for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Edit "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
#When Edit "<chargeCode>" "Charge Code" for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<nopH1>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Add Row" icon of shipping bill details screen for ASI and Charge 
When Add 2 shipping bill details with "<sbType>" and "<nopH2>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Expand" icon of 1 mawb for ASI and Charge
Then SB details grid displayed for ASI and Charge
When Click on "SB ASI" icon of 1 mawb for ASI and Charge
Then SB ASI Submission popup opened for ASI and Charge
When Select "Select All" checkbox of SB ASI Submission grid for ASI and Charge
When Click on "Proceed" button of SB ASI Submission popup for ASI and Charge
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for ASI and Charge
When Click on "Yes" button of SB ASI Confirmation popup for ASI and Charge
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for ASI and Charge
When Click on "Ok" button of SB Advance Shipment Information popup for ASI and Charge
Then SB ASI successfully submited for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add HAWB" icon of 1 mawb for ASI and Charge
Then Navigated to House Manifest screen for ASI and Charge
When Click on "Delete" icon of 2 hawb row for ASI and Charge
Then HAWB Deletion popup is opened with "Deleting HAWB will delete Shipping Bills attached to the HAWB." message for ASI and Charge
When Click on "Yes" button of HAWB Deletion popup for ASI and Charge
Then HAWB Message popup is opened with "HAWB deleted successfully." message for ASI and Charge
When Click on "Ok" button of HAWB Message popup for ASI and Charge
Then HAWB details get deleted successfully for ASI and Charge
When Click on "Save" button of House Manifest screen for ASI and Charge
Then House Manifest Status popup opened for ASI and Charge
When Click on "Ok" button of House Manifest Status popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
And SB details get deleted of a hawb for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|originCode|destCode|nopH1|grwtH1|chargeCode|cargoDesctiionH1|nopH2|grwtH2|cargoDesctiionH2   |flightCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|BLR       |ATL     |4    |50    |PP        |Auto Parts      |4    |50    |Electrical Material|ZZ        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |AWC           |100             |Kale Airline 1|Manual|
  
  
  
   @TS14090916 @Verify_ASI_CO_SingleSB_forDirectShipment_CO
Scenario Outline: TS14090916 To verify whether user is able to send the Carting order approval request at MAWB Level
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge

When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge


When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
Then Flight no link displayed in the mawb grid against the flitered mawb for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|
  
  
 @TS14090917 @Verify_ASI_CO_SingleSB_forDirectShipment
Scenario Outline: TS14090917 To verify whether user is able to perform ASI submission and charge collection for direct shipment with one SB
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge

When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge

When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
  
   @TS14090918 @Verify_to_addupdate_select_CHA_for_the_AWB_for_which_the_TSP_Payment_is_done
Scenario Outline: TS14090918 To verify whether user is able to add or update select CHA for the AWB for which the TSP Payment is done
Given Navigate to Create AWB for ASI and Charge
Then Verify that balance amount message popup is displayed for ASI and Charge
When Click on "Ok" button of message popup for ASI and Charge
When Enter "<prefix>" "Awb Prefix" and "Awb No" for ASI and Charge
When Select "<shipperName>" "Shipper Name" for ASI and Charge
When Select "<consgineeName>" "Consignee Name" for ASI and Charge
When Click on "Routing Info" icon to add rounting details for ASI and Charge
Then Routing details popup opened and "BLR" origin alreday selected for ASI and Charge
When Select "<destCode>" "Destination Code" for ASI and Charge
When Click on "Ok" button of Routing Details popup for ASI and Charge
Then Destinaiton filed get populated with "<destCode>" for ASI and Charge
When Add 1 flight details with "<flightCode>" flight code for ASI and Charge
When Select "<chargeCode>" "Charge Code" for ASI and Charge
When Select "<customBroker>" "Custom Broker" for ASI and Charge
When Click on "Dimensions" icon of 1 rate line for ASI and Charge
Then Dimensions popup opened for ASI and Charge
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for ASI and Charge
When Click on "Ok" button of Dimesnsions for ASI and Charge
Then No of pcs will get populated with "<noPcs>" of 1 rate line
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for ASI and Charge
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for ASI and Charge
When Select "Rates as agreed" checkbox for ASI and Charge
When Click on "Save" button for ASI and Charge
Then Success popup displayed with message "Air Waybill saved successfully." for ASI and Charge
When Click on "Ok" button of Success popup for ASI and Charge
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for ASI and Charge
When Click on "ASI" icon of 1 mawb for ASI and Charge
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for ASI and Charge
When Click on "Ok" button of MAWB ASI popup for ASI and Charge
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for ASI and Charge
When Click on "CO" icon of 1 mawb for ASI and Charge
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for ASI and Charge
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for ASI and Charge
Then CO message popup opened with "Carting order requested successfully." message for ASI and Charge
When Click on "Ok" button for CO message popup for ASI and Charge
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login with airline user in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
And CO Shipment screen dispalyed for ASI and Charge
When Enter mawb no and click on "Search" button of CO approval screen for ASI and Charge
Then Mawb no shipment only displayed in the CO approval grid for ASI and Charge
When Click on "Action" icon of 1 shipment for ASI and Charge
Then Naviaged to Carting Order Approval screen with all shipment details displayed
When Click on "Approve" button of CO Approval screen for ASI and Charge
Then Success popup opened with "Carting order approved successfully" message for ASI and Charge
When Click on "Ok" button of Success popup in CO Approval screen for ASI and Charge
Then Navgiated to CO Shipment screen for ASI and Charge
When Click on "Logout" button of user for ASI and Charge
Then Navigated to login screen for ASI and Charge
When Login in Bial application for ASI and Charge
Then Verify Navigated to Home screen for ASI and Charge
#When Navigate to MAWB List for ASI and Charge
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
Then Flitered mawb no only visible in MAWB list grid for ASI and Charge 
When Click on "Add SB" icon of 1 mawb for ASI and Charge
Then Shipping Bill Details screen opened and able to mawb no for ASI and Charge
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for ASI and Charge
When Click on "Save" button in shipping bill details screen for ASI and Charge
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for ASI and Charge
When Click on "Ok" button of shipping bill popup for ASI and Charge
Then Navigated to MAWB list screen for ASI and Charge
###### TSP payment 
When Add fliter to "MAWB No" column with "" in MAWB list grid for ASI and Charge
When Click on "Expand" icon of 1 mawb for ASI and Charge
When Click on "TSP payment" icon of 1 mawb for ASI and Charge
Then validate TSP Payment is opened for ASI and Charge
Then enter cargotype commodityName HSNcode transaction_passward and paynow for ASI and Charge
When validate payment confirmation Message popup opens and clickon Yes for ASI and Charge
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon No for ASI and Charge
Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker								 |noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  

  
  