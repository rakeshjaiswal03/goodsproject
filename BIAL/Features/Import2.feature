 @ACS_BIAL @Import
Feature: Import2
  
Background: Launch application & login Bial application for e-Booking screen
Given forImport2 Launch Browser and Bial application link
When forImport2 Login in Bial application
Then forImport2 Verify Navigated to Home screen


@import14
Scenario:  To check if user is able to create multiple VT for single BoE  from TSP pop up	
######### 1. create Awb and add MAWB
Given forImport2 Navigate to Create AWB for eAWB screen
Then forImport2 Verify that balance amount message is displayed for eAWB screen
Then forImport2 Click in Ok button of message for eAWB screen
When forImport2 Enter AWB prefix and AWB number for eAWB screen
When forImport2 Enter "acs shipper#than" and "acs consignee#atlanta#atl" for eAWB screen
When forImport2 Click on Routing Info button and enter Destn "ATL" and Via "" and Flight No "231" for eAWB screen Create_Direct_eAWB
When forImport2 Click on Save eAWB button for eAWB screen
Then forImport2 Verify Success message is displayed for eAWB screen
Then forImport2 Verify Navigated to Home screen
######### 2. create MAWB 
When forImport2 Click on "Imports" mode.
Then forImport2 Click on "Add MAWB/HAWB"  button
When forImport2 Enter all the MAWB Details and click on Save button.
Then 	forImport2	validate Message "Shipment details saved successfully." is displayed and clickon OK
Then forImport2 Verify Navigated to Home screen
######### 3. ADO approval
Then 	forImport2	logout from FF username
Then  forImport2  login using airline credential 
Then forImport2 Verify Navigated to Home screen
When forImport2 Click on "Imports" mode.
					######### note: here Shipement Details screen is default/ main screen after clicking on Importbtn
Then 	forImport2	Enter IGM number and clickon Search btn
Then  forImport2	clickon Action Pending ADO
Then 	forImport2	validate Approve DO popup is displayed
Then 	forImport2	enter DO No and DO date and click on submit 
Then 	forImport2	validate Message "Airline DO approved successfully." is displayed and clickon OK in ShipmentDetails Screen
Then 	forImport2	logout from airline credential
######### 4. 
When  forImport2 Login in Bial application
Then  forImport2 Verify Navigated to Home screen
When forImport2 Click on "Imports" mode.
Then 	forImport2	filter using IGM
Then 	forImport2	click on BOE 
Then 	forImport2	Enter Bill of Entry Details like BOE number, BOE Date, BOE type, NOP, upload BOE
Then  forImport2  clickon save 
Then 	forImport2	validate message " Bill of Entry details saved successfully. " is displayed and clickon OK for BoE Screen
Then forImport2 Verify Navigated to Home screen
When forImport2 Click on "Imports" mode.
Then 	forImport2	filter using IGM 
Then  forImport2 click on GridExpandBtn
####Then 	forImport2	scroll horizontally right / click on expand option 
Then 	forImport2	click on OoC 
Then 	forImport2	validate OoC screen is displayed 
Then 	forImport2	Enter Details in OoC screen like   OoC Number, Date, OoC Type==Manual,(BOEnumber, BOE date, NOP, CustomerBroker code is autofilled) and upload Ooc
Then  forImport2  clickon save
Then 	forImport2	validate message "Out of Charge saved successfully. " is displayed and clickon OK
Then 	forImport2	validate screen redirected to Import home screen
######### 5. 
#1. User should be able to complete process till TSP payment 
#and User should get a success message about TSP and asking if user wants to generate token, 
#User should click on Yes and system should navigate user to Generate token screen.
#2. User should be able to see the Create token screen with Generate token grid and select the terminal, 
#3. Token details grid should have: Total BoE count, Custom broker name, Custom broker number, Frieght forwarder details
#4. BoE details grid with Multiple BoE No., BoE date, MAWB No., HAWB No., AWB Total NoP, AWB Total Gr Wt., AWB Allocated NoP, AWB Allocated Gr Wt., Unit, TSP receipt no., TSP receipt date, OoC no., OoC recd NoP, Action button.
#5. Vehicle details grid with Vehicle token no.,Enter Vehicle no., Driver license no., Driver name, Driver mobile no., Agent mobile no., NoP, Gross Wt(kgs), Cargo type, Remark(opt), Parking area status, Dockin status, Dock out status, action button with Back and Save button.
#6. User should be able to click on 'Plus' button on Action field and user should be able to fill all the vehicle details.
#6. User should be able to click on save button and get pop up with success message.
#7. Vehicle token icon on MAWB List screen shoud be changed to completed




















