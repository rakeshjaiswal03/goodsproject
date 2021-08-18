@E_AWB @ACS_BIAL @Export
Feature: e-AWB

Background: Launch application & login Bial application for eAWB screen
Given Launch Browser and Bial application link for eAWB screen
When Login in Bial application for eAWB screen
Then Verify Navigated to Home screen for eAWB screen


@E_AWB_152335 
Scenario Outline:  To verify All data filled in e-Booking screen is autopopulated in respective fields 
Given eAWB_screen Navigated to Create screen of e-Booking
  When eAWB_screen Choose file from the local directory for e-Booking
  When eAWB_screen Click on "Upload" button to choose file for e-Booking
  Then eAWB_screen All mandatory field get populated with data from the excel file for e-Booking
  When eAWB_screen Click on "Save" Job button for e-Booking
  Then eAWB_screen Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When eAWB_screen Click "No" Success popup button for e-Booking
  Then eAWB_screen Navigated Saved screen of e-Booking and created job in the job list
  And  eAWB_screen Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When eAWB_screen Select 1 Job in saved job gird for e-Booking
  When eAWB_screen Click on "Forward To Airline" in Saved page for e-Booking
  Then eAWB_screen Shipment type popup opened in the Boking Shipment screen for e-Booking
  When eAWB_screen Click on "Submit" button on shipment type popup for e-Booking
  Then eAWB_screen Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When eAWB_screen Select Airline Schedule for date for e-Booking
  When eAWB_screen Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then eAWB_screen Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When eAWB_screen Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When eAWB_screen Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then eAWB_screen Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When eAWB_screen Click on "Yes" button on Message popup for e-Booking
  Then eAWB_screen Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When eAWB_screen Click on "No" button on Booking status poup for e-Booking
  Then eAWB_screen Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking
  
  #Given Navigated to Sent screen of e-Booking
  When eAWB_screen Select "<actionName>" of 1 sent job grid for e-Booking
  Then eAWB_screen Navigated to Create MAWB screen and see message popup for e-Booking
  When eAWB_screen Click on "Ok" button on create MAWB messsage popup for e-Booking
  Then eAWB_screen Create MAWB Message popup closed and able see all fields auotmatically populated from job for e-Booking
  When eAWB_screen Select "<chargeCode>" "Charge Code" on created MAWB screen for e-Booking
  When eAWB_screen Select "<customBroker>" "Custom Broker" on created MAWB screen for e-Booking
  When eAWB_screen Select "<rateClass>" and enter chargeble weight of 1 rate line in create MAWB screen for e-Booking
  When eAWB_screen Click on RateAsAgreed
  
  When eAWB_screen CLick on "Save" button on create MAWB for e-Booking
  Then eAWB_screen Awb succesfully created and Success popup opened with "Air Waybill saved successfully." on create MAWB screen for e-Booking
  When eAWB_screen Click on "Ok" button in Success popup on create MAWB screen  for e-Booking
  Then eAWB_screen Navigated MAWB Created screen and Saved awb details visible in the 1st row for e-Booking
  
  Examples: 
  |prefix|actionName  |chargeCode|customBroker|rateClass|
  |777   | Create MAWB|PP        |JEENA N CO GLOBAL LOGISTICS       |Q        |
  


  @E_AWB_152336 
Scenario: Verify_Balance_Amount_messsage
####To verify If user tries to create AWB,then alert message should display of "Balance amount" for creating AWBs
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen



 @Create_Direct_e-AWB @E_AWB_152337
Scenario: Verify_Save_Direct_AWB
####To verify User is able to save 'Direct AWB'
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen

 @Add_Houses_in_eAwb @E_AWB_152338
Scenario: 	Add_HouseManifest_in_eAWB
####To verify User is able to add houses in a existing 'Direct AWB' by clicking on 'House Manifest' button in edit mode
#When Clicked on eAwb Edit button for eAWB screen
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Clicked on Consol/HAWB radio button for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
Then Verify message popup displays and click Ok for HAWB screen
###Do you want to create House Air Waybill first?
Then Verify Housing Manifest iframe is displayed for HAWB screen
When Enter House Manifest data "acs shipper" "acs consignee" "BLR" "ATL" "1" "10" "Bags" 1 for HAWB Screen
When Click Save House Manifest button for HAWB Screen
Then Verify Save Success message is displayed on iFrame for HAWB Screen
When Click on Close Housing Manifest iFrame for HAWB window
Then Verify HAWB table is displayed in eAWB screen for HAWB Screen
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen


	@E_AWB_152339
Scenario: To verify User is able to save Consol AWB
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Clicked on Consol/HAWB radio button for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
Then click Yes for popUpMsg Do you want to create House Air Waybill first? 
Then Verify Housing Manifest iframe is displayed for HAWB screen
When Enter House Manifest data "acs shipper" "acs consignee" "ATL" "ATL" "1" "10" "Bags" 1 for HAWB Screen
When Click Save House Manifest button for HAWB Screen
Then Verify Save Success message is displayed on iFrame for HAWB Screen
When Clickon Close Housing Manifest iFrame for HAWB Screen

Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter Consignee Name and Address  "acs consignee#atlanta#atl" in eAWB screen
When Enter FirstCarrier code
When Clickon Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen
When clickon Rates as agreed for eAWB screen
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen


	@E_AWB_152340
Scenario Outline: To verify User is able to save AWB by selecting Existing AWB from Create AWB as/from option
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen

Given for eAWB screen- select"<option>"from Create AWB as/from option
Given for eAWB screen- from AWBList select MAWBno and click on OK"<MAWBno>"

Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen

When Enter AWB prefix and AWB number for eAWB screen

When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen

Examples: 
			|option         	|MAWBno         |
			|Existing AWB   	|777-14789681   |


@createtemplateforE_AWB_152341
Scenario: To verify User is able to save AWB by selecting Template from Create AWB
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
Then Save as template for eAWB screen

	@E_AWB_152341
Scenario Outline: To verify User is able to save AWB by selecting Template from Create AWB
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
Given for eAWB screen- select"<option>"from Create AWB as/from option
Given for eAWB screen- from AWBTemplateList select firstradio and click on OK"<MAWBno>"
#####Then Verify that balance amount message is displayed for eAWB screen
#####Then refresh the website
Then for eAWB validate popupMsg"The Template is copied. Please verify the details and enter new AWB no" and click OK
#####Then Click in Ok button of message for eAWB screen
#####When Click on Save eAWB button for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
#Then for E_AWB Enter flight date  #### commenteed before feature no longer required
Then Enter Rate Class and ChargebleWt
When Click on SaveeAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen

Examples: 
			|option   	|
			|Template  	|


	@E_AWB_152342
Scenario: To verify By default ,Value of Issuing agent is fetched from  Issuing Carriers Agent Name and City is displayed same as of branch which is logged in
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
Then To verify default issuing Carriers Agent Name and City 


	@E_AWB_152343
Scenario: To verify User is able to change the Issuing agent
### tested and works only using Agentusername: ACS_Forwarder as it only contains multiple issuing agent 
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
#Then hover branch and select branch name"ATL FF Branch 2"
#Given Navigate to Create AWB for eAWB screen
#Then Verify that balance amount message is displayed for eAWB screen
#Then Click in Ok button of message for eAWB screen
When Enter issuing agent name"ATL FF Branch 2"
Then validate Issuing Carriers Agent Name and City is as selected branch 




	@E_AWB_152344
Scenario: To verify Check if Issuing agent(new) creates AWB then amount should be deducted from the new Issuing agent account
# -Note--: TC onHold as Deduction will happen at MAWB ASI level hence not automatedd 



	@E_AWB_152345
Scenario: To verify that user is able to add new shipper details or search the existing details.
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
Then Click on Plus sign near Shipper field
When validate AddShipper PopUp appears
Then Enter Shipper Name and Address details, clickon Save, Click on OK
When search the same shipper Name and Address to validate


	@E_AWB_152346
Scenario: To verify that user is able to add new consignee details or search the existing details.
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
Then Click on Plus sign near consignee field
When validate Addconsignee PopUp appears
Then Enter consignee Name and Address details, clickon Save, Click on OK
When search the same consignee Name and Address to validate


	@E_AWB_152347
Scenario: To verify User is not able to save AWB Shipper & consignee details having same country
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter same shipper and consignee details "acs shipper#thanw#bom" and "ACS Consignee#mumbai#BO" for eAWB screen
Then in AWSscreen verify validation popUp appears


	@E_AWB_152348
Scenario: To verify User is able to save AWB with various Charge Codes available in the system
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen


	@E_AWB_152349
Scenario: To verify User is able to save AWB with Routing details having via 1 or Via 1 & Via 2 points
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "LCY" and Flight No "231" for eAWB screen
Then Enter via 1 flight details 
Then FOR E_AWB enter Rate in Cargo1
Then FOR E_AWB enter Due Carrier
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen



	@E_AWB_152350
Scenario: To verify User is able to save AWB with multiple Carrier Codes
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
##When Click on Routing Info button and enter Destn "ATL" and Via "ATL" and Flight No "231" for eAWB screen Create_Direct_eAWB with multiple Carrier Codes
When Click on Routing Info button and enter Destn "ATL" and Via "LCY" and Via "DXB" and Flight No "231" and Flight No "232" for eAWB screen Create_Direct_eAWB
Then Enter via 1 flight details 
Then Enter via 2 flight detailsss 
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen






	@E_AWB_152351
Scenario: To verify User is able to save AWB with multiple Flight Details
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "DXB" and Via "LCY" and Flight No "231" and Flight No "232" for eAWB screen Create_Direct_eAWB
Then Enter via 1 flight details 
Then Enter via 2 flight detailsss 
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen


	@E_AWB_152352
Scenario: To verify User is able to save AWB with Handling Information
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB with handling info
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen



	@E_AWB_152353
Scenario: To verify If "Rates as agreed" is checked then, Rate/Charges, Total,Prepaid section,Collect section, Due Agent & Due Carrier becomes disabled
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When clickon Rates as agreed for eAWB screen
Then validate Rate_Charges, Total, Prepaid section, Collect section, Due Agent & Due Carrier should become disabled for eAWB screen



	@E_AWB_152354
Scenario: To verify User is able to save AWB with Single dimension in single rateline
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen



	@E_AWB_152355
Scenario: To verify User is able to save AWB with multiple dimensions in Single rateline
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen for multiple dimensions in Single rateline
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen




	@E_AWB_152356
Scenario: To verify User is able to save AWB with single dimension in multiple ratelines
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen for single dimension in multiple ratelines
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen

	@E_AWB_152357
Scenario: To verify User is able to save AWB with multiple dimensions in multiple ratelines
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen for multiple dimensions in multiple ratelines
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen

	@E_AWB_152358
Scenario: To verify User is able to save AWB with different Rate Class
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen

	@E_AWB_152359
Scenario: To verify User is able to save AWB by selecting his CHA organization name from Select CHA drop down list where forwarding and CHA activities are performed from same organization
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen


	@E_AWB_152360
Scenario: To verify User is able to save AWB by selecting its preferred CHA trade partner from 
Select CHA drop down list where forwarding and CHA activities are performed from different organization 
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then Click in Ok button of message for eAWB screen
When Enter AWB prefix and AWB number for eAWB screen
When Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for CHA activities are performed from different organization  
When Click on Save eAWB button for eAWB screen
Then Verify Success message is displayed for eAWB screen




# @E_AWB_152361	#( this TC is on hold )
#Scenario: To verify User is able to save AWB by selecting option Other from Select CHA drop down list where forwarding and CHA activities are performed from different organization. This will be used where TSP is generated by an adhoc CHA




	@E_AWB_152362
Scenario Outline: To verify After creation AWBs Amount should be deducted from the Balance amount
Given Navigate to Create AWB for eAWB screen
Then Verify that balance amount message is displayed for eAWB screen
Then check balance amount message is displayed for eAWB screen
Then Capture initial balancAmt in inCargobyBLR_Account
Then Click in Ok button of message for eAWB screen
###---------------
When Enter "<prefix>" "Awb Prefix" and "Awb No" for eAWB
When Select "ACS SHIPPER123#BLR#BLR" "Shipper Name" for eAWB
When Select "acs consignee#atlanta#atl" "Consignee Name" for eAWB
When Click on "Routing Info" icon to add rounting details for eAWB
Then Routing details popup opened and "BLR" origin alreday selected for eAWB
When Select "<destCode>" "Destination Code" for eAWB
When Click on "Ok" button of Routing Details popup for eAWB
Then Destinaiton filed get populated with "<destCode>" for eAWB
When Add 1 flight details with "<flightCode>" flight code for eAWB
When Select "<chargeCode>" "Charge Code" for eAWB
When Select "<customBroker>" "Custom Broker" for eAWB
When Click on "Dimensions" icon of 1 rate line for eAWB
Then Dimensions popup opened for eAWB
When Add 1 dimesnsions with "<noPcs>" and "<length>" and "<width>" and "<height>" for eAWB
When Click on "Ok" button of Dimesnsions for eAWB
Then No of pcs will get populated with "<noPcs>" of 1 rate line for eAWB
When Add 1 rate line details with "<grWt>" and "<rateClass>" and "<rate>" anf "<natureOfGoods>" for eAWB
When Enter 1 "<dueCarrierCode>" and "<dueCarrierAmount>" for eAWB
When Click on "Save" button for eAWB
Then Success popup displayed with message "Air Waybill saved successfully." for eAWB
When Click on "Ok" button of Success popup for eAWB
###-------AWB creation completed-----------
Then AWB successfully created and navigated to MAWB List screen able to see saved details in the grid for eAWB
When Click on "ASI" icon of 1 mawb for eAWB
Then MAWB ASI popup opened with "Advance shipment information (ASI) submitted successfully to respective CTO." message for eAWB
When Click on "Ok" button of MAWB ASI popup for eAWB
Then ASI successfully submited with "MAWB ASI submitted Successfully" title for eAWB
When Click on "CO" icon of 1 mawb for eAWB
Then Carting Order Request popup is opened with "Do you want to send CO request?" message for eAWB
When Select "<airline>" and click on "Yes" button of Carting Order Request popup for eAWB
Then CO message popup opened with "Carting order requested successfully." message for eAWB
When Click on "Ok" button for CO message popup for eAWB
Then Carting order request send with "CO pending for approval from Requested Airline, Click to re-request." title for eAWB
When Click on "Logout" button of user for eAWB
Then Navigated to login screen for eAWB
When Login with airline user in Bial application for eAWB
Then Verify Navigated to Home screen for eAWB
And CO Shipment screen dispalyed for eAWB
When Enter mawb no and click on "Search" button of CO approval screen for eAWB
Then Mawb no shipment only displayed in the CO approval grid for eAWB
When Click on "Action" icon of 1 shipment for eAWB
Then Naviaged to Carting Order Approval screen with all shipment details displayed eAWB
When Click on "Approve" button of CO Approval screen for eAWB
Then Success popup opened with "Carting order approved successfully" message for eAWB
When Click on "Ok" button of Success popup in CO Approval screen for eAWB
When Click on "Logout" button of user for eAWB
Then Navigated to login screen for eAWB
When Login in Bial application for eAWB
Then Verify Navigated to Home screen for eAWB
#### When Navigate to MAWB List for ASI and Charge --------------------
When Add fliter to "MAWB No" column with "" in MAWB list grid for eAWB
Then Flitered mawb no only visible in MAWB list grid for eAWB 
When Click on "Add SB" icon of 1 mawb for eAWB
Then Shipping Bill Details screen opened and able to mawb no for eAWB
When Add 1 shipping bill details with "<sbType>" and "<noPcs>" and "<length>" and "<width>" and "<height>" and "<grWt>" for eAWB
When Click on "Save" button in shipping bill details screen for eAWB
Then Shipping Bill popup opened with "Shipping bill details saved successfully." message for eAWB
When Click on "Ok" button of shipping bill popup for eAWB
Then Navigated to MAWB list screen for eAWB
When Add fliter to "MAWB No" column with "" in MAWB list grid for eAWB
Then Flitered mawb no only visible in MAWB list grid for eAWB
When Click on "Expand" icon of 1 mawb for eAWB
Then SB details grid displayed for eAWB
When Click on "SB ASI" icon of 1 mawb for eAWB
Then SB ASI Submission popup opened for eAWB
When Click on "Proceed" button of SB ASI Submission popup for eAWB
Then SB ASI Confirmation popup opened with "Are you sure all the details for selected shipments are valid?" message for eAWB
When Click on "Yes" button of SB ASI Confirmation popup for eAWB
Then SB Advance Shipment Information popup opened with "SB Advance Shipment Information submitted successfully." message for eAWB
When Click on "Ok" button of SB Advance Shipment Information popup for eAWB
Then SB ASI successfully submited for eAWB

###---------------
When Click on "Logout" button of user for eAwb
Then Navigated to login screen for eAwb
When Login in Bial application for eAWB screen
Then Verify Navigated to Home screen for eAWB screen

Given Navigate to Create AWB for eAWB screen
Then check balance amount message is displayed for eAWB screen
Then Capture final balancAmt in inCargobyBLR_Account
Then verify after creation AWBs,Amount should be deducted from the Balance amount

Examples: 
  |prefix|shipperName|consgineeName|destCode|flightCode|chargeCode|customBroker|noPcs|length|width|height|grWt|rateClass|rate|natureOfGoods|dueCarrierCode|dueCarrierAmount|airline       |sbType|
  |777   |ACS SHIPPER|ACS CONSIGNEE|ATL     |ZZ        |PP        |JEENA N CO GLOBAL LOGISTICS       |10   |10    |10   |10    |100 |Q        |20  |Auto Parts   |AWC           |100             |Kale Airline 1|Manual|
  








