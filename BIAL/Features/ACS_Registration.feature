@ACS_Registration  @ACS_BIAL @Export

Feature: ACS_Registration

Background: Launch application & login Bial application for registration
Given Launch Browser and Bial application link for registration

  
@135875  @BIAL_TC_01_ACS_Registration
Scenario: To verify whether the system displays the login screen properly
When Refresh website
Then validate login div is present in homepage



@135875	@BIAL_TC_02_ACS_Registration
Scenario:  To verify that New Registration hyperlink is available on login page & user is able to click it.
Given Refresh website
Then validate Registration Text is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed

@135875	@BIAL_TC_03_ACS_Registration
Scenario: To verify whether the system allow the user to select multiple business lines
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink
Then validate new Registration page is displayed  
Then Select more than one business line Validate for FF, CB, consolidator. 
Then validate remaining business line should be disabled if FF, CB, consolidator. is selected 
Then uncheck  FF, CB, consolidator. 
Then Select more than one business line Validate for FF, CB
Then validate remaining business line should be disabled if FF, CB is selected 
Then uncheck FF, CB 
Then Select more than one business line Validate for Shipper, consignee
Then validate remaining business line should be disabled if Shipper, consignee is selected 
Then uncheck  Shipper, consignee
When Check the check box of Freight Forwarder business line
Then validate Customs Broker and Consolidator business line is enabled
Then validate remaining business line should be disabled
	

@135875	@BIAL_TC_04_ACS_Registration
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Freight Forwarder' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check the check box of Freight Forwarder business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<EmailID>""<mobileNo>"
Then Select"<RegistrationStatus>"option from the drop down option for Freight Forwarder business line
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
When Enter valid IATA registration number
When Select IATA Registration Date from the calendar icon
Then Enter valid CASS no 
Given for_FreightForwarder_businessline Click on Select Document Type drop down as"<doctype>"
###Then Click on Browser button send the file and click on UploadBtn
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete 
	
Examples: 
				|Organizationname  |BusinessEmailID        |Contactnumber|Streetaddress1  |Citycode|Statecode|Zip   |Username       |Firstname  |Lastname  |RegistrationStatus|GSTStateCode|GSTIN           |doctype  |EmailID               |mobileNo  | 
				|kaleAutomation    |abc@kaleautomation.com |022-255532   |25 golden park  |1       |1        |421306|KLAutoTeam |Rakesh     |Jaiswal   |Registered        |1           |06ABIFS3901K3Z3 |NA       |abc@kaleautomation.com|9876543210|
				
				

@135875	@BIAL_TC_05_ACS_Registration
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Trucking Co.' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink
Then validate new Registration page is displayed 
When Check the Trucking Co. check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<RegistrationStatus>"option from the drop down option for Trucking Co
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Given for_Trucking_Co_businessline Click on Select Document Type drop down as"<doctype>" for Trucking Co 	
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Organizationname  |BusinessEmailID        |Contactnumber|Streetaddress1|Citycode|Statecode|Zip   |Username       |Firstname  |Lastname  |RegistrationStatus|GSTStateCode|GSTIN           |doctype  | 
				|kaleAutomation    |abc@kaleautomation.com |9874562310  |25             |1       |1        |421306|KLAutomateTeam |Rakesh     |Jaiswal   |Registered        |1           |06ABIFS3901K5Z3 |NA       | 
				


@135875	@BIAL_TC_06_ACS_Registration
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Customer Broker' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check the Customer Broker check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
#BIAL_TC_06.18 (field does not exist)	
Then Enter valid Customs Broker License Number whichis PAN Based
#BIAL_TC_06.19 (field does not exist)	
Then Select License Expiry Date from the calendar icon
Given for_Customer_Broker_businessline Click on Select Document Type drop down as"<doctype>"
Then Check the check box of Terms and Conditions
Then Click on Submit

Examples: 
				| Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				| kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3103K1Z3 |          | 
			
			

@135875	@BIAL_TC_07_ACS_Registration
Scenario Outline: To verify that user able to submit the New Registration details with Airline business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 	
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"	
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Then Enter AirlineDetails
Given for_Airline_businessline Click on Select Document Type drop down as"<doctype>" for Trucking Co 
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline | Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|Airline      | kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3107K1Z3 |          | 
			

@135875	@BIAL_TC_08_ACS_Registration
Scenario Outline: sTo verify that user is able to submit the 'New Registration' valid details with 'Consolidator' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Then Consolidator Registration Details__
Given for_Consolidator_businessline Click on Select Document Type drop down as"<doctype>" 
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline     | Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|Consolidator     | kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3909K1Z3 |NA		    | 
			

@135875	@BIAL_TC_09_ACS_Registration
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Security' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 	
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Then  Security Registration Details 
Given for_Security_businessline Click on Select Document Type drop down as"<doctype>" for Trucking Co 
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline     | Organizationname  | BusinessEmailID           | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|Security         | kaleAutmtion     	| abc@kaleautomation.com 		| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomTeam    | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3911K1Z3 |NA		    | 
			

@135875	@BIAL_TC_10_ACS_Registration	
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Shipper' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Then   Shipper Registration Details 
Given for_Shipper_businessline Click on Select Document Type drop down as"<doctype>" 
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline     | Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|Shipper          | kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3913K1Z3 |NA		    | 
			

@135875	@BIAL_TC_11_ACS_Registration
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Consignee' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Then   Consignee Registration Details 
Given for_Consignee_businessline Click on Select Document Type drop down as"<doctype>"
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline     | Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|Consignee        | kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3915K1Z3 |NA		    | 
			

@135875	@BIAL_TC_12_ACS_Registration
Scenario Outline: 	To verify that user is able to submit the 'New Registration' valid details with 'GHA' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink
Then validate new Registration page is displayed  
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Given for_GHA_businessline Click on Select Document Type drop down as"<doctype>" for Trucking Co 
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline | Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|GHA          | kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3917K1Z3 |NA		    | 
			

@135875	@BIAL_TC_13_ACS_Registration	
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Bonded Trucker' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Given Enter Bonded Trucker Registration Details 
Given for_BondedTrucker_businessline Click on Select Document Type drop down as"<doctype>" for Trucking Co 
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline   | Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|Bonded Trucker | kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3918K1Z3 |NA		    | 
			


@135875	@BIAL_TC_14_ACS_Registration	
Scenario Outline: To verify that user is able to submit the 'New Registration' valid details with 'Chamber of Commerce' business line
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink
Then validate new Registration page is displayed  
When Check"<Businessline>"check box of Business line
Then Enter valid Organizationname"<Organizationname>"	
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<BusinessEmailID>""<Contactnumber>"
Then Select"<GSTRegistrationStatus>"option from the drop down option for Customer Broker
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
Given Enter Chamber of Commerce Registration Details 
Given for_ChamberOfCommerce_businessline Click on Select Document Type drop down as"<doctype>" for Trucking Co 
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete

Examples: 
				|Businessline        | Organizationname  | BusinessEmailID               | Contactnumber  | Streetaddress1  | Citycode  | Statecode  | Zip     | Username       | Firstname  | Lastname  | GSTRegistrationStatus  | GSTStateCode  | GSTIN           | doctype  | 
				|Chamber of Commerce | kaleAutomation   	| abc@kaleautomation.com 				| 022-255532     | 25              | 1         | 1          | 421306  | KLAutomateTeam | Rakesh     | Jaiswal   | Registered             | 1             | 06ABIFS3920K1Z3 |NA		    | 
			


@126709	@BIAL_TC_15_ACS_Registration	
Scenario: To verify whether the system allows the user to register by keeping mandatory fields blank
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
Then Click on Submit
Then Validate whether the system allows the user to register by keeping mandatory fields blank


@135875	@BIAL_TC_16_ACS_Registration	
Scenario: To verify whether the system gets navigated back to login screen after clicking on Back button of New registration screen
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
Then Click on backBtn
Then Validate whether the system gets navigated back to login screen after clicking on Back button



@135875	@BIAL_TC_17_ACS_Registration	
Scenario: To verify that user is able to view Terms of Usage hyperlink of New registration screen
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
Then Click on Terms and Conditions hyperlink
When Switch to next tab
Then Click on every single menu to view the information about the Terms and Conditions

@135875	@BIAL_TC_18_ACS_Registration
Scenario: To verify whether the user able to login by keeping mandatory fields blank
Then validate login div is present in homepage
When Click on LoginBtn 
Then Validate login error message is displayed 


@135875	@BIAL_TC_19_ACS_Registration
Scenario Outline: To verify whether the system allows the user to register without checking the Terms and Conditions check box 
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check the check box of Freight Forwarder business line
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Username"<Username>"	
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<EmailID>""<mobileNo>"
Then Select"<RegistrationStatus>"option from the drop down option for Freight Forwarder business line
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
When Enter valid IATA registration number
When Select IATA Registration Date from the calendar icon
Then Enter valid CASS no 
Given for_FreightForwarder_businessline Click on Select Document Type drop down as"<doctype>"
###	BIAL_TC_19.22	Uncheck the Terms and Conditions check box (hence feature not mention)	
Then Click on Submit
Then Validate alert message is displayed for unchecked term and condition cb
	
Examples: 
				|Organizationname  |BusinessEmailID        |Contactnumber|Streetaddress1  |Citycode|Statecode|Zip   |Username       |Firstname  |Lastname  |RegistrationStatus|GSTStateCode|GSTIN           |doctype  |EmailID               |mobileNo  | 
				|kaleAutomation    |abc@kaleautomation.com |022-255532   |25 golden park  |1       |1        |421306|KLAutoTeam |Rakesh     |Jaiswal   |Registered        |1           |06ABIFS3901K1Z3 |NA       |abc@kaleautomation.com|9876543210|
			

@135875	@BIAL_TC_20_ACS_Registration
Scenario: To verify whether the ACS admin able to approve the registration request from acs admin login
Then validate login div is present in homepage
When Login in Bial application for ACS_Registration TC
Then Clickon Registration >> Received Request
Then Filter Organization Startswith KaleAutomation
Then Click on requested organization name
Then Click on Approve Btn


@135875	@BIAL_TC_21_ACS_Registration
Scenario: To verify whether the ACS admin able to reject the registration request from acs admin login
Then validate login div is present in homepage
When Login in Bial application for ACS_Registration TC
Then Clickon Registration >> Received Request
Then Filter Organization Startswith KaleAutomation
Then Click on requested organization name
Then Click on Reject Btn
Then Enter reason for rejection 
Then Clickon saveBtn


@135875	@BIAL_TC_22_ACS_Registration
Scenario: To verify whether the user is able to do first login with provided login credentials in the mail after approving from acs admin
Given unable to automate as we donot automate mail


@135875	@BIAL_TC_23_ACS_Registration
Scenario: To verify whether the user receives proper mail after doing registration
Given unable to automate as we donot automate mail


@135875	@BIAL_TC_24_ACS_Registration	
Scenario: To verify whether the user receives credentials mail after approving from acs admin
Given unable to automate as we donot automate mail


@135875	@BIAL_TC_25_ACS_Registration
Scenario: To verify whether the Admin receives the proper mail after the user registration
Given unable to automate as we donot automate mail


@135875	@BIAL_TC_26_ACS_Registration	
Scenario Outline: To verify whether the user is able to do registration with FF, Customs Broker and Consolidator(multiple business line)
#######	BIAL_TC_04.01
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
#######	BIAL_TC_04.02
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
######BIAL_TC_04.03 (Check the check box of FF, Customs Broker and Consolidator(multiple business line))
Then Select more than one business line Validate for FF, CB, consolidator. 
Then validate FF CB consolidator are checked
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"	
Then Enter valid Zip"<Zip>"	
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Statecode"<Statecode>"	
Then Enter valid Citycode"<Citycode>"
Then Enter valid Username"<Username>"	
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<EmailID>""<mobileNo>"
Then Select"<RegistrationStatus>"option from the drop down option for Freight Forwarder business line	
Then Enter valid"<GSTStateCode>"of GST details section	
Then Enter valid"<GSTIN>"value
#### --------------field for FF selection --------------------------------------
When Enter valid IATA registration number	
When Select IATA Registration Date from the calendar icon
Then Enter valid CASS no 
#### --------------field for CB selection--------------------------------------
Then Enter valid Customs Broker License Number whichis PAN Based
Then Select License Expiry Date from the calendar icon
#### ---------------doc upload for FF selection -------------------------------------
Given for_FreightForwarder_businessline Click on Select Document Type drop down as"<doctype>"
#### ---------------doc upload for CB selection -------------------------------------
Given for_Customer_Broker_businessline Click on Select Document Type drop down as"<doctype>" 
#### ---------------doc upload for consolidator selection -------------------------------------
Given for_Consolidator_businessline Click on Select Document Type drop down as"<doctype>"
#### -------------------------------------------------------------------------------------------	
Then Check the check box of Terms and Conditions
#### --------------field for consolidator selection--------------------------------------
Then Consolidator Registration Details 
Then Click on Submit
Then Validate Registration is complete 
	
Examples: 
				|Organizationname  |BusinessEmailID        |Contactnumber|Streetaddress1  |Citycode|Statecode|Zip   |Username   |Firstname  |Lastname  |RegistrationStatus|GSTStateCode|GSTIN           |doctype  |EmailID               |mobileNo  | 
				|kaleAutomation    |abc@kaleautomation.com |022-255532   |25 golden park  |1       |1        |421306|KLAutoTeam |Rakesh     |Jaiswal   |Registered        |1           |06ABIFS3901K1Z3 |NA       |abc@kaleautomation.com|9876543210|
				

@135875	@BIAL_TC_27_ACS_Registration	
Scenario Outline: To verify whether the user is able to do registration with Customs Broker and Consolidator(multiple business line)
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
When Check the Customer Broker check box of Business line
When Check"<Businessline>"check box of Business line
Then validate Customs Broker and Consolidator are selected 
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 	
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<EmailID>""<mobileNo>"
Then Select"<RegistrationStatus>"option from the drop down option for Freight Forwarder business line
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
#### --------------field for CB selection--------------------------------------
Then Enter valid Customs Broker License Number whichis PAN Based
Then Select License Expiry Date from the calendar icon
#### --------------field for consolidator selection--------------------------------------
Then for BIAL_TC_27 Consolidator Registration Details
Given for_Customer_Broker_businessline Click on Select Document Type drop down as"<doctype>" 
Given for_Consolidator_businessline Click on Select Document Type drop down as"<doctype>"
Then Check the check box of Terms and Conditions
Then Click on Submit
 
	
Examples: 
			|Businessline   	|Organizationname  |BusinessEmailID        |Contactnumber|Streetaddress1  |Citycode|Statecode|Zip   |Username   |Firstname  |Lastname  |RegistrationStatus|GSTStateCode|GSTIN           |doctype  |EmailID               |mobileNo  | 
			|Consolidator   	|kaleAutomation    |abc@kaleautomation.com |022-255532   |25 golden park  |1       |1        |421306|KLAutoTeam |Rakesh     |Jaiswal   |Registered        |1           |06ABIFS3901K1Z3 |NA       |abc@kaleautomation.com|9876543210|
				
@135875	@BIAL_TC_28_ACS_Registration	
Scenario Outline: To verify whether the user is able to do registration with Shipper and Consignee(multiple business line)
Then validate login div is present in homepage
Then Validate Registration hyperlink is present in homepage
Then Clickon Registration hyperLink 
Then validate new Registration page is displayed 
Then Select more than one business line Validate for Shipper, consignee
Then validate shipper and consignee are checked
Then Enter valid Organizationname"<Organizationname>"
Then Enter valid BusinessEmailID"<BusinessEmailID>"
Then Enter valid BusinessContactnumber"<Contactnumber>" 
Then Enter valid Streetaddress1"<Streetaddress1>"
Then Enter valid Zip"<Zip>"
Then Enter valid Countrycode"<Countrycode>"
Then Enter valid Statecode"<Statecode>"
Then Enter valid Citycode"<Citycode>"
Then Enter valid Username"<Username>"
Then Enter valid Firstname"<Firstname>"
Then Enter valid Lastname"<Lastname>"
Then Enter EmailID and mobile number "<EmailID>""<mobileNo>"
Then Select"<RegistrationStatus>"option from the drop down option for Freight Forwarder business line
Then Enter valid"<GSTStateCode>"of GST details section
Then Enter valid"<GSTIN>"value
#### --------------field for shipper selection--------------------------------------
Then   Shipper Registration Details 
#### --------------field for consignee selection--------------------------------------
Then   Consignee Registration Details 
#### --------------doc upload for shipper selection -------------------------------------
Given for_Shipper_businessline Click on Select Document Type drop down as"<doctype>" 
#### --------------doc upload for consignee selection -------------------------------------
Given for_Consignee_businessline Click on Select Document Type drop down as"<doctype>"
#### -------------------------------------------------------------------------------------------
Then Check the check box of Terms and Conditions
Then Click on Submit
Then Validate Registration is complete 
	
Examples: 
			|Businessline   	|Organizationname  |BusinessEmailID        |Contactnumber|Streetaddress1  |Citycode|Statecode|Zip   |Username   |Firstname  |Lastname  |RegistrationStatus|GSTStateCode|GSTIN           |doctype  |EmailID               |mobileNo  | 
			|Consolidator   	|kaleAutomation    |abc@kaleautomation.com |022-255532   |25 golden park  |1       |1        |421306|KLAutoTeam |Rakesh     |Jaiswal   |Registered        |1           |06ABIFS3901K1Z3 |NA       |abc@kaleautomation.com|9876543210|
				

  