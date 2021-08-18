@GenerateTSP_VCT @ACS_BIAL @Export
Feature: GenerateTSP_VCT

Background: Launch application & login Bial application for eAWB screen
Given Launch Browser and Bial application link for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT

@142141	@TS_BIAL_01_GenerateTSP_VCT
Scenario Outline: TS_BIAL_01_GenerateTSP_VCT To verify whether user is able to create TSP for direct shipment
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for GenerateTSP_VCT
When Select "acs consignee#atlanta#atl" "Consignee Name" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
### -------------------- -------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "No" for GenerateTSP_VCT

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
@142141	@TS_BIAL_02_GenerateTSP_VCT
Scenario Outline:  TS_BIAL_02_GenerateTSP_VCT To verify whether user is able to create TSP for direct shipment
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for GenerateTSP_VCT
When Select "acs consignee#atlanta#atl" "Consignee Name" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
### -------------------- #	TS_BIAL_02.06	Enter Remarks and Transaction password and click on Pay Now button -------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "No" for GenerateTSP_VCT


Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  



@142141	@TS_BIAL_03_GenerateTSP_VCT
Scenario Outline: TS_BIAL_03_GenerateTSP_VCT To verify whether user is able to print a TSP corresponding to a particular shipping bill
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<777>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for GenerateTSP_VCT
When Select "acs consignee#atlanta#atl" "Consignee Name" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
### --------------Adding SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
### -------- #	TS_BIAL_02.06	Enter Remarks and Transaction password and click on Pay Now button-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "No" for GenerateTSP_VCT
### -------------------- #	TS_BIAL_03.03	Click on Print button-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then Clickon printBtn for GenerateTSP_VCT


Examples: 
		  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
		  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  

@142141	@TS_BIAL_04_GenerateTSP_VCT
Scenario Outline: TS_BIAL_04_GenerateTSP_VCT To verify whether user is able to detach the particular shipment from Airport Tab
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "Awb Prefix" and "Awb No" for GenerateTSP_VCT__ 
When Select field name"Shipper Name" and enter value "ACS SHIPPER123#BLR#BLR" for GenerateTSP_VCT
When Select field name"Consignee Name" and enter value "ACS CONSIGNEE#atlanta#atl" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select field name"Destination Code" and enter value "ATL" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select field name"Charge Code" and enter value "CA" for GenerateTSP_VCT
When Select field name"Custom Broker" and enter value "JEENA N CO GLOBAL LOGISTICS" for GenerateTSP_VCT

When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT__
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
### --------------Adding SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
#	TS_BIAL_04.02	Click on the detach icon under the Detach column against the shipment
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then clickon detach Btn for GenerateTSP_VCT

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
  
@142141	@TS_BIAL_05_GenerateTSP_VCT
Scenario: TS_BIAL_05_GenerateTSP_VCT To verify whether user is able to add special equipment details for the shipment
#	TS_BIAL_05.01	Go to Agent Login -> Airport tab
#	TS_BIAL_05.02	Click on the icon under SE column against the shipment
#	TS_BIAL_05.03	Select equipment type from the dropdown
#	TS_BIAL_05.04	Enter Quantity value
#	TS_BIAL_05.05	Click on Submit button

@142141	@TS_BIAL_06_GenerateTSP_VCT
Scenario Outline: TS_BIAL_06_GenerateTSP_VCT To verify whether the user is able to generate VT for single SB and single vehicle
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select fieldname"Shipper Name"and enter value"ACS SHIPPER123#BLR#BLR" for GenerateTSP_VCT__
When Select fieldname"Consignee Name"and enter value"acs consignee#atlanta#atl" for GenerateTSP_VCT__
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
#####-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
###### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
##### --------------Adding single   SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
##### -------- for single SB Do TSPpayment-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcs>" "<grWt>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT

Examples: 
		  |prefix|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
		  |777   |ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  


@142141	@TS_BIAL_07_GenerateTSP_VCT
Scenario Outline: TS_BIAL_07_GenerateTSP_VCT To verify whether the user is able to generate VT for single SB and multiple vehicle
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for GenerateTSP_VCT
When Select "acs consignee#atlanta#atl" "Consignee Name" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
### --------------Add single SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
### -------- for single SB do TSP payment-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "5" "50" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given add more vehile row for GenerateTSP_VCT
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "5" "50" "Remark" in row 2 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT



Examples: 
		  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
		  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  



@142141	@TS_BIAL_08_GenerateTSP_VCT
Scenario Outline: TS_BIAL_08_GenerateTSP_VCT To verify whether the user is able to generate VT for multiple SB and single vehicle
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for GenerateTSP_VCT
When Select "acs consignee#atlanta#atl" "Consignee Name" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcsSB1>" and "<length>" and "<width>" and "<height>" and "<grWtSB1>" for GenerateTSP_VCT
When Click on "Add Row" icon of shipping bill details screen for GenerateTSP_VCT
When Add 2 shipping bill details with "<sbType>" and "<noPcsSB2>" and "<length>" and "<width>" and "<height>" and "<grWtSB2>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
### --------------Adding multiple  SB (2 SB )--------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT

### -------- for First SB Enter Remarks and Transaction password and click on Pay Now button-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcsSB1>" "<grWtSB1>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT

### --------------Adding multiple SB (2 SB )--------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 2 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
### -------- for second  SB Enter Remarks and Transaction password and click on Pay Now button-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "yes" for GenerateTSP_VCT
## -------- generate single  vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcsSB2>" "<grWtSB2>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT

Examples: 
 		  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker											 |noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|noPcsSB1|grWtSB1|noPcsSB2|grWtSB2|
  		|777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS 			 |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|6       |60     |4       |40     |


@142141	@TS_BIAL_09_GenerateTSP_VCT
Scenario Outline: TS_BIAL_09_GenerateTSP_VCT To verify whether the user is able to generate VT for multiple SB and multiple vehicle
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for GenerateTSP_VCT
When Select "acs consignee#atlanta#atl" "Consignee Name" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcsSB1>" and "<length>" and "<width>" and "<height>" and "<grWtSB1>" for GenerateTSP_VCT
When Click on "Add Row" icon of shipping bill details screen for GenerateTSP_VCT
When Add 2 shipping bill details with "<sbType>" and "<noPcsSB2>" and "<length>" and "<width>" and "<height>" and "<grWtSB2>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
### --------------Adding multiple  SB (2 SB )--------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT

### -------- for First SB Enter Remarks and Transaction password and click on Pay Now button-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcsSB1>" "<grWtSB1>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT

### --------------Adding multiple SB (2 SB )--------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 2 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
### -------- for second  SB Enter Remarks and Transaction password and click on Pay Now button-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "yes" for GenerateTSP_VCT
## -------- generate single  vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcsSB2>" "<grWtSB2>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT

Examples: 
 		  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker											 |noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|noPcsSB1|grWtSB1|noPcsSB2|grWtSB2|
  		|777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS 			 |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|6       |60     |4       |40     |





@142141	@TS_BIAL_10_GenerateTSP_VCT
Scenario Outline: TS_BIAL_10_GenerateTSP_VCT To verify whether the user is able to generate VT for multiple CTO
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for GenerateTSP_VCT
When Select "acs consignee#atlanta#atl" "Consignee Name" for GenerateTSP_VCT
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
Then change CTO
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
### -------------------- -------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "No" for GenerateTSP_VCT

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  


@142141	@TS_BIAL_11_GenerateTSP_VCT
Scenario Outline: TS_BIAL_11_GenerateTSP_VCT To verify whether the user is able to search for a VT
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select fieldname"Shipper Name"and enter value"ACS SHIPPER123#BLR#BLR" for GenerateTSP_VCT__
When Select fieldname"Consignee Name"and enter value"acs consignee#atlanta#atl" for GenerateTSP_VCT__
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
#####-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
###### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
##### --------------Adding single   SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
##### -------- for single SB Do TSPpayment-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcs>" "<grWt>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT
#### ----- capture VT 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "vehicle token" icon of 1 mawb for GenerateTSP_VCT
Then capture Vehicle_Token_No for GenerateTSP_VCT and click on backBtn

#######validate user is able to search VT 
Given for_GenerateTSP_VCT Clickon searchTokenBtn
Given for GenerateTSP_VCT Enter Token No"EVT2103080001" and clickon search
Given for GenerateTSP_VCT validate details are displayed

Examples: 
		  |prefix|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
		  |777   |ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  



@142141	@TS_BIAL_12_GenerateTSP_VCT
Scenario Outline: TS_BIAL_12_GenerateTSP_VCT To verify whether the user is able to edit the VT details
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select fieldname"Shipper Name"and enter value"ACS SHIPPER123#BLR#BLR" for GenerateTSP_VCT__
When Select fieldname"Consignee Name"and enter value"acs consignee#atlanta#atl" for GenerateTSP_VCT__
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
#####-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
###### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
##### --------------Adding single   SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
##### -------- for single SB Do TSPpayment-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcs>" "<grWt>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT
##### ---- capture Vehicle token
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "vehicle token" icon of 1 mawb for GenerateTSP_VCT
Then capture Vehicle_Token_No for GenerateTSP_VCT and click on backBtn

#--------------------
Given for_GenerateTSP_VCT Clickon searchTokenBtn
Given for GenerateTSP_VCT Enter Token No"" and clickon search
Given for GenerateTSP_VCT validate details are displayed
Then for GenerateTSP_VCT Click on Edit button
Then for GenerateTSP_VCT Make the required changes in Remarks and click on save button
Then for GenerateTSP_VCT handle the vehicleupdate popup
Given for GenerateTSP_VCT Enter Token No"" and clickon search
Given for GenerateTSP_VCT validate changesin Remarksfield is displayed

Examples: 
		  |prefix|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
		  |777   |ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  


@142141	@TS_BIAL_13_GenerateTSP_VCT
Scenario Outline: TS_BIAL_13_GenerateTSP_VCT To verify whether the user is able to Cancel the generated VT Details
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select fieldname"Shipper Name"and enter value"ACS SHIPPER123#BLR#BLR" for GenerateTSP_VCT__
When Select fieldname"Consignee Name"and enter value"acs consignee#atlanta#atl" for GenerateTSP_VCT__
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
#####-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
###### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
##### --------------Adding single   SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
##### -------- for single SB Do TSPpayment-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcs>" "<grWt>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT

When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "vehicle token" icon of 1 mawb for GenerateTSP_VCT
Then capture Vehicle_Token_No for GenerateTSP_VCT and click on backBtn


Given for_GenerateTSP_VCT Clickon searchTokenBtn
Given for GenerateTSP_VCT Enter Token No"EVT2103160002" and clickon search
Given for GenerateTSP_VCT validate details are displayed
Then Click on the Cancel Token button 

Examples: 
		  |prefix|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
		  |777   |ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  

@142141	@TS_BIAL_14_GenerateTSP_VCT
Scenario Outline: TS_BIAL_14_GenerateTSP_VCT To verify whether the user is able to print the vehicle token
Given Navigate to Create AWB for GenerateTSP_VCT
Then Verify that balance amount message popup is displayed for GenerateTSP_VCT
When Click on "Ok" button of message popup for GenerateTSP_VCT
When Enter "<prefix>" "Awb Prefix" and "Awb No" for GenerateTSP_VCT
When Select fieldname"Shipper Name"and enter value"ACS SHIPPER123#BLR#BLR" for GenerateTSP_VCT__
When Select fieldname"Consignee Name"and enter value"acs consignee#atlanta#atl" for GenerateTSP_VCT__
When Click on "Routing Info" icon to add rounting details for GenerateTSP_VCT
Then Routing details popup opened and "BLR" origin alreday selected for GenerateTSP_VCT
When Select "<destCode>" "Destination Code" for GenerateTSP_VCT
When Click on "Ok" button of Routing Details popup for GenerateTSP_VCT
Then Destinaiton filed get populated with "<destCode>" for GenerateTSP_VCT
When Add 1 flight details with "<flightCode>" flight code for GenerateTSP_VCT
When Select "<chargeCode>" "Charge Code" for GenerateTSP_VCT
When Select "<customBroker>" "Custom Broker" for GenerateTSP_VCT
When Click on "Dimensions" icon of 1 rate line for GenerateTSP_VCT
Then Dimensions popup opened for GenerateTSP_VCT
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for GenerateTSP_VCT
When Click on "Ok" button of Dimesnsions for GenerateTSP_VCT
Then No of pcs will get populated with "<noPcs>" of 1 rate line for GenerateTSP_VCT
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for GenerateTSP_VCT
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for GenerateTSP_VCT
When Click on "Save" button for GenerateTSP_VCT
Then Success popup displayed with message "Air Waybill saved successfully." for GenerateTSP_VCT
When Click on "Ok" button of Success popup for GenerateTSP_VCT
#####-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for GenerateTSP_VCT
When Click on "ASI" icon of 1 mawb for GenerateTSP_VCT
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for GenerateTSP_VCT
When Click on "Ok" button of MAWB ASI popup for GenerateTSP_VCT
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for GenerateTSP_VCT
When Click on "CO" icon of 1 mawb for GenerateTSP_VCT
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for GenerateTSP_VCT
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for GenerateTSP_VCT
Then CO message popup opened with "Carting order requested successfully." message for GenerateTSP_VCT
When Click on "Ok" button for CO message popup for GenerateTSP_VCT
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login with airline user in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
And CO Shipment screen dispalyed for GenerateTSP_VCT
When Enter mawb no and click on "Search" button of CO approval screen for GenerateTSP_VCT
Then Mawb no shipment only displayed in the CO approval grid for GenerateTSP_VCT
When Click on "Action" icon of 1 shipment for GenerateTSP_VCT
Then Naviaged to Carting Order Approval screen with all shipment details displayed GenerateTSP_VCT
When Click on "Approve" button of CO Approval screen for GenerateTSP_VCT
Then Success popup opened with "Carting order approved successfully" message for GenerateTSP_VCT
When Click on "Ok" button of Success popup in CO Approval screen for GenerateTSP_VCT
When Click on "Logout" button of user for GenerateTSP_VCT
Then Navigated to login screen for GenerateTSP_VCT
When Login in Bial application for GenerateTSP_VCT
Then Verify Navigated to Home screen for GenerateTSP_VCT
###### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT 
When Click on "Add SB" icon of 1 mawb for GenerateTSP_VCT
Then Shipping Bill Details screen opened and able to mawb no for GenerateTSP_VCT
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for GenerateTSP_VCT
When Click on "Save" button in shipping bill details screen for GenerateTSP_VCT
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for GenerateTSP_VCT
When Click on "Ok" button of shipping bill popup for GenerateTSP_VCT
Then Navigated to MAWB list screen for GenerateTSP_VCT
##### --------------Adding single   SB --------------------------------------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
Then Flitered mawb no only visible in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
Then SB details grid displayed for GenerateTSP_VCT
When Click on "SB ASI" icon of 1 mawb for GenerateTSP_VCT
Then SB ASI Submission popup opened for GenerateTSP_VCT
When Click on "Proceed" button of SB ASI Submission popup for GenerateTSP_VCT
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for GenerateTSP_VCT
When Click on "Yes" button of SB ASI Confirmation popup for GenerateTSP_VCT
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for GenerateTSP_VCT
When Click on "Ok" button of SB Advance Shipment Information popup for GenerateTSP_VCT
Then SB ASI successfully submited for GenerateTSP_VCT
##### -------- for single SB Do TSPpayment-------------------- -------------------- 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "TSP payment" icon of 1 mawb for GenerateTSP_VCT
Then validate TSP Payment is opened for GenerateTSP_VCT
Then enter cargotype commodityName HSNcode transaction_passward and paynow for GenerateTSP_VCT
When validate payment confirmation Message popup opens and clickon Yes for GenerateTSP_VCT
Then validate GenerateTokenFromTSP_Mesage popup opens and clickon "Yes" for GenerateTSP_VCT
## ###-------- generate  first vehicle token number ------------------ -------------------- 
Given enter "vehicleNo" "driverlicence" "DriverName" "DriverMob" "agentMob" "<noPcs>" "<grWt>" "Remark" in row 1 and Clickon GeneratetokenBtn for GenerateTSP_VCT
Given validate "Vehicle Token generated successfully." popup msg appears and clickon OK for GenerateTSP_VCT
#### ----- capture VT 
When Add fliter to "MAWB No" column with "" in MAWB list grid for GenerateTSP_VCT
When Click on "Expand" icon of 1 mawb for GenerateTSP_VCT
When Click on "vehicle token" icon of 1 mawb for GenerateTSP_VCT
Then capture Vehicle_Token_No for GenerateTSP_VCT and click on backBtn

#######validate user is  able to print the vehicle token
Given for_GenerateTSP_VCT Clickon searchTokenBtn
Given for GenerateTSP_VCT Enter Token No"EVT2103160002" and clickon search
Given for GenerateTSP_VCT validate details are displayed
Then Click on the Print button 
Then Select the option and click on Submit button

Examples: 
		  |prefix|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
		  |777   |ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  
