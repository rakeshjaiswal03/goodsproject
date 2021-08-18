@eBooking @ACS_BIAL @Export
Feature: e-Booking
  
Background: Launch application & login Bial application for e-Booking screen
Given Launch Browser and Bial application link for e-Booking screen
When Login in Bial application for e-Booking screen
Then Verify Navigated to Home screen for e-Booking screen


  @152368 @152370 @CreateJob @CreateJobWithSingleDimensionSingleRateline
  Scenario Outline: To verify user is able to create job with single dimension and rate line
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName         |consgineeName         |destCode|noOfPcs|length|width|height|grWt|cargoDescrption|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10     |10    |10   |10    |100 |Auto Parts     |
      |AutoTest Shipper 134|AutoTest Consignee 261|ATL     |10     |10    |10   |10    |100 |Auto Parts     |
      
      
      @152369 @CreateJobWithLoadDataFromFile
  Scenario: To verify user is able to create booking by Load Data From File functionality
  Given Navigated to Create screen of e-Booking
  #When Click on "Download" sample excel data button for e-Booking
  #Then Sample excel data file get downloaded in the local directory for e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
      
      
          @152386
  Scenario: User should be able to view all jobs created in Create job screen
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
      
      
      @152371 @CreateJobWithMultipleDimension
  Scenario Outline: To verify user is able to create job with multiple dimension and single rate line
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs1>" and "<length1>" and "<width1>" and "<height1>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Plus" icon of 1 add dimension for e-Bookng
  Then Dimension Row get added for e-Booking
  When Enter "<noOfPcs2>" and "<length2>" and "<width2>" and "<height2>" of 2 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 2 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName         |consgineeName|destCode|noOfPcs1|length1|width1|height1|noOfPcs2|length2|width2|height2|grWt|cargoDescrption|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10      |10     |10    |10     |5       |12     |12    |12     |100 |Auto Parts     |
      
      
          @152372 @CreateJobWithMultipleRateline
  Scenario Outline: To verify user is able to create job with single dimension and multiple rate line
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs11>" and "<length11>" and "<width11>" and "<height11>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt1>" and "<cargoDescrption1>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Plus" icon of 1 rate line for e-Booking
  Then Rate line row get added in e-Booking
  When Click on "Dimensions" icon of 2 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs12>" and "<length12>" and "<width12>" and "<height12>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 2 rate line for e-Booking
  When Enter "<grWt2>" and "<cargoDescrption2>" of 2 rate line for e-Booking
  Then Chargeable Weight is get populated of 2 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName     |consgineeName|destCode|noOfPcs11|length11|width11|height11|grWt1|cargoDescrption1|noOfPcs12|length12|width12|height12|grWt2|cargoDescrption2|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10       |10      |10     |10      |100  |Auto Parts      |5        |50      |50     |50      |10   |Auto Parts      |
      
      
  @152373 @CreateJobWithMultipleDimesion&Rateline
  Scenario Outline: To verify user is able to create job with single multiple and multiple rate line
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs11>" and "<length11>" and "<width11>" and "<height11>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Plus" icon of 1 add dimension for e-Bookng
  Then Dimension Row get added for e-Booking
  When Enter "<noOfPcs21>" and "<length21>" and "<width21>" and "<height21>" of 2 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 2 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt1>" and "<cargoDescrption1>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Plus" icon of 1 rate line for e-Booking
  Then Rate line row get added in e-Booking
  When Click on "Dimensions" icon of 2 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs12>" and "<length12>" and "<width12>" and "<height12>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Plus" icon of 1 add dimension for e-Bookng
  Then Dimension Row get added for e-Booking
  When Enter "<noOfPcs22>" and "<length22>" and "<width22>" and "<height22>" of 2 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 2 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 2 rate line for e-Booking
  When Enter "<grWt2>" and "<cargoDescrption2>" of 2 rate line for e-Booking
  Then Chargeable Weight is get populated of 2 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName     |consgineeName|destCode|noOfPcs11|length11|width11|height11|noOfPcs21|length21|width21|height21|grWt1|cargoDescrption1|noOfPcs12|length12|width12|height22|noOfPcs22|length22|width22|height22|grWt2|cargoDescrption2|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10       |10      |10     |10      |25       |15      |10     |12      |100  |Auto Parts      |5        |50      |50     |50      |2        |70      |30     |99      |10   |Auto Parts      |
  
  
  
  @152377 @CreateJobWithSameOrigin&Destination
  Scenario Outline: To verify cant Create Job with same origin & Destination Routing Details
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Unable to create a job and "Routing Details should be different." error message displayed
 
  
  Examples: 
      |shipperName     |consgineeName|destCode|noOfPcs|length|width|height|grWt|cargoDescrption|
      |AutoTest Shipper 134|AutoTest Consignee 772|BLR     |10     |10    |10   |10    |100 |Auto Parts     |
  
  
  @152374 @152375 @CreateJobWithNewAddShipper @CreateJobWithNewAddConsignee
  Scenario Outline: To verify user is able to create job with new add shipper and consignee
  Given Navigated to Create screen of e-Booking
  When Click on plus icon of add "Shipper" for e-Booking
  Then Add Shipper popup opened for e-Booking
  When Enter "<compnayName>" and IE no and "<emailIdS>" and "<addressLine1S>" and "<zipCodeS>" and "<countryS>" and "<cityS>" on Add Shipper for e-Booking
  When CLick on "Save" button for save shipper details of Add Shipper for e-Booking
  Then Shipper details get saved and "Customer Details saved successfully." message dispalyed
  When Click on "Ok" button of Add Shipper for e-Booking
  Then Add Shipper popup will closed and shipper name and address field get populated
  When Click on plus icon of add "Consignee" for e-Booking
  Then Add Consignee popup opened for e-Booking
  When Enter "<consgineeName>" and "<emailIdC>" and "<addressLine1C>" and "<zipCodeC>" and "<countryC>" and "<cityC>" on Add Consignee for e-Booking
  When CLick on "Save" button for save Consignee details of Add Consignee for e-Booking
  Then Consignee details get saved and "Consignee saved successfully" message dispalyed
  When Click on "Ok" button of Add Consignee for e-Booking
  Then Add Consignee popup will closed and Consignee name and address field get populated
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  Examples: 
      |compnayName     |emailIdS        |addressLine1S    |zipCodeS|countryS|cityS|consgineeName     |emailIdC          |addressLine1C      |zipCodeC|countryC|cityC|destCode|noOfPcs|length|width|height|grWt|cargoDescrption|
      |AutoTest Shipper|AutoTest.Shipper|Auto Test Shipper|410000  |IN      |BOM  |AutoTest Consignee|AutoTest.Consignee|Auto Test Consignee|110000  |US      |ATL  |ATL     |10     |10    |10   |10    |100 |Auto Parts     |
      |AutoTest Shipper|AutoTest.Shipper|Auto Test Shipper|410000  |IN      |BOM  |AutoTest Consignee|AutoTest.Consignee|Auto Test Consignee|110000  |US      |ATL  |ATL     |10     |10    |10   |10    |100 |Auto Parts     |
  
  
  
  @152376 @CreateJobWhereShipperAndConsigneeSameCity
  Scenario Outline: To verify that user is not able to create Job with Shipper & Consignee having same cities.
  Given Navigated to Create screen of e-Booking
  When Click on plus icon of add "Shipper" for e-Booking
  Then Add Shipper popup opened for e-Booking
  When Enter "<compnayName>" and IE no and "<emailIdS>" and "<addressLine1S>" and "<zipCodeS>" and "<countryS>" and "<cityS>" on Add Shipper for e-Booking
  When CLick on "Save" button for save shipper details of Add Shipper for e-Booking
  Then Shipper details get saved and "Customer Details saved successfully." message dispalyed
  When Click on "Ok" button of Add Shipper for e-Booking
  Then Add Shipper popup will closed and shipper name and address field get populated
  When Click on plus icon of add "Consignee" for e-Booking
  Then Add Consignee popup opened for e-Booking
  When Enter "<consgineeName>" and "<emailIdC>" and "<addressLine1C>" and "<zipCodeC>" and "<countryC>" and "<cityC>" on Add Consignee for e-Booking
  When CLick on "Save" button for save Consignee details of Add Consignee for e-Booking
  Then Consignee details not saved and "Shipper and Consignee should be from different country." error message dispalyed
  
  Examples: 
      |compnayName     |emailIdS        |addressLine1S    |zipCodeS|countryS|cityS|consgineeName     |emailIdC          |addressLine1C      |zipCodeC|countryC|cityC|
      |AutoTest Shipper|AutoTest.Shipper|Auto Test Shipper|410000  |IN      |BOM  |AutoTest Consignee|AutoTest.Consignee|Auto Test Consignee|110000  |IN      |BOM  |
  
  
  @152378 @CreateJobWithSingleViaPoint
  Scenario Outline: To verify create job with Routing details with Single Via point
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  When Enter "<via1Code>" "Via1 Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName     |consgineeName|destCode|via1Code|noOfPcs|length|width|height|grWt|cargoDescrption|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |DXB     |10     |10    |10   |10    |100 |Auto Parts     |
      
      
      @152379 @CreateJobWithMultipleViaPoint
  Scenario Outline: To verify create job with Routing details with multiple Via points.
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  When Enter "<via1Code>" "Via1 Code" for e-Booking
  When Enter "<via2Code>" "Via2 Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName     |consgineeName|destCode|via1Code|via2Code|noOfPcs|length|width|height|grWt|cargoDescrption|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |DXB     |JFN     |10     |10    |10   |10    |100 |Auto Parts     |
      
      
      @152380 @CreateJobWithHazardousDetails
  Scenario Outline: To verify user is able to save job with Hazardous details
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" and select Hazardous and enter UN no and "<class>" and select "<packingGroup>" 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName     |consgineeName|destCode|noOfPcs|length|width|height|grWt|cargoDescrption|class    |packingGroup|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10     |10    |10   |10    |100 |Auto Parts     |autoClass|I           |
      
      
      @152381 @CreateJobWithCHA
  Scenario Outline: To verify user is able to create job by selecting CHA
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Check custom broker and select "<customBroker>" for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "<shipperName>" "Shipper Name" and "<destCode>" "Destination Code" and "<grWt>" "Gross Weight" and "Job Created" "Status" for e-Booking
  
  
  Examples: 
      |shipperName     |consgineeName|destCode|noOfPcs|length|width|height|grWt|cargoDescrption|customBroker  |
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10     |10    |10   |10    |100 |Auto Parts     |JEENA N CO GLOBAL LOGISTICS|
  
  
  @152382 @CreateJobWithSaveAsDraft 
  Scenario Outline: To verify user is able to save job as Draft
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save As Draft" Job button for e-Booking
  Then Draft Name popup opened for e-Booking
  When Enter "<draftName>" on Draft Name popup for e-Booking
  When Click on "Save" draft name button for e-Booking
  Then Navigated Draft screen of e-Booking and Booking Status popup displayed
  
  Examples: 
      |shipperName     |consgineeName|destCode|noOfPcs|length|width|height|grWt|cargoDescrption|draftName|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10     |10    |10   |10    |100 |Auto Parts     |AutoDraft|
      
      
      
      @152383 @CreateJobWithSaveAsTemplate
  Scenario Outline: To verify user is able to save job as Template
  Given Navigated to Create screen of e-Booking
  When Select "<shipperName>" "Shipper Name" for e-Booking
  When Select "<consgineeName>" "Consignee Name" for e-Booking
  Then Verify "BLR" already entered in "Origin Code" field for e-Booking
  When Enter "<destCode>" "Destination Code" for e-Booking
  Then "Destination Name" is get populated with correct value for e-Booking
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimension row for e-Booking
  Then Volume field get popluated on the base of entered dimension of 1 dimension row for e-Booking
  When Click on "Save" Dimension button for e-Booking
  Then Dimension get save and No of Pcs field get populated of 1 rate line for e-Booking
  When Enter "<grWt>" and "<cargoDescrption>" of 1 rate line for e-Booking
  Then Chargeable Weight is get populated of 1 rate line for e-Booking
  When Click on "Save As Template" Job button for e-Booking
  Then Template popup opened for e-Booking
  When Enter "<templateName>" on Template popup for e-Booking
  When Click on "Save" Template button for e-Booking
  Then Navigated Template screen of e-Booking and Booking Status popup displayed
  
  Examples: 
      |shipperName     |consgineeName|destCode|noOfPcs|length|width|height|grWt|cargoDescrption|templateName|
      |AutoTest Shipper 134|AutoTest Consignee 772|ATL     |10     |10    |10   |10    |100 |Auto Parts     |AutoTemplate|
      
      
      
      
      @152384 @Help
  Scenario: To verify by clicking on Help icon,User is able to view Create Job guide
  #Given Navigated to Create screen of e-Booking
  #When Click on "Help" button for e-Booking
  #Then Verify user should be able to view 'Create Job' guide.
  
  
  
      @152385 @SearchJobInGridWithUrn/Date/Shipper/Origin
  Scenario: To verify user is able to search records by Quick Search by selecting parameters such as Date,Destination Port code,Destination Port name,Orgin port code,Origin port name & URN
  #Given Navigated to Saved screen of e-Booking
  #When Search "URN" for e-Booking
  #Then Searched urn job only displyed in job grid for e-Booking
  #When Click on "Clear Filter" in Saved page for e-Booking
  #Then All filter will remove for e-Booking
  #When Search "Date" for e-Booking
  #Then All job with searched date will displayed for e-Booking
  #When Click on "Clear Filter" in Saved page for e-Booking
  #Then All filter will remove for e-Booking
  #When Search "Shipper" for e-Booking
  #Then All job with searched shipper will displayed for e-Booking
  #When Click on "Clear Filter" in Saved page for e-Booking
  #Then All filter will remove for e-Booking
  #When Search "Origin" for e-Booking
  #Then All job with searched origin will displayed for e-Booking
  #When Click on "Clear Filter" in Saved page for e-Booking
  #Then All filter will remove for e-Booking
  #
  
      @152387 @ClickOnUrnLinkToSeeJobDetailsInCreateJobScreen
  Scenario: To verify On click of URN,user will be navigated to 'Create Job' screen. Job details will be auto populated. All fields and buttons on this screen will be disabled.
  Given Navigated to Saved screen of e-Booking
  When Click on 1 "URN" in job grid for e-Booking
  Then Navigated Create Job screen to see all the details of job in the field which are disabled and also all button also disabled
  
  
      @152388 @ViewHawbOfJob
  Scenario Outline: To verify user is able to view HAWB by clicking on 'HAWB view' icon
  Given Navigated to Saved screen of e-Booking
  When Search "<urnNo>" "URN" of on saved screen for e-Booking
  When Click on 1 "HAWB View" in job grid for e-Booking
  Then Navigated HAWB View screen and able to see the hawb job details for e-Booking
    
  Examples: 
  |urnNo|
  |200  |
  
  
   @152389 @ViewHMawbOfJob
  Scenario Outline: To verify user is able to view HAWB by clicking on 'HAWB view' icon
  Given Navigated to Saved screen of e-Booking
  When Search "<urnNo>" "URN" of on saved screen for e-Booking
  When Click on 1 "MAWB View" in job grid for e-Booking
  Then Navigated to MAWB view screen and able to see mawb job details for e-Booking 
  
  
  Examples: 
  |urnNo|
  |200  |
  
  
   @152391 @CopyBooking
  Scenario: To verify user is able to Copy Job by clicking on 'Copy' icon
  Given Navigated to Saved screen of e-Booking
  When Click on 1 "Copy Booking" in job grid for e-Booking
  Then Navigated to Create Job screen poulated all field with of that job for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated URN and "Job Created" Status for e-Booking
  
  
  @152393 @eDocket
  Scenario Outline: To verify user is able to upload e-Docket of Job by clicking on 'e-Docket' link
  Given Navigated to Saved screen of e-Booking
  When Click on 1 "e-Docket" in job grid for e-Booking
  Then e-Docket popup opened for e-Booking
  When Select "<documentType>" and choose file from local directory of 1 row for e-Booking
  When CLick on "Upload" eDocket button for e-Booking
  Then Document get uploaded and document details displayed in document grid for e-Booking
  #When Click on "Close" eDocket button for e-Booking
  #Then e-Docket popup is closed and job gird visible for e-Booking
  
  Examples: 
  |documentType|
  |Others      |
  
  
  @152394 @ForwardToAirlineForSingleJob
  Scenario: To verify user is able to Forward single Job to Airline by selecting one checkbox of a job & clicking on "Forward to Airline" button 
  Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  
  @152395 @ForwardToAirlineForMultipleJob
  Scenario: To verify user is able to Forward multiple Jobs to Airline by multiple checkboxes of jobs & clicking on "Forward to Airline" button 
  Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Select 4 Job in saved job gird for e-Booking
  When Select 3 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected jobs details in grid for e-Booking
  
  @152397 @NavigatedToBookingShipment
  Scenario: To verify after Forwarding,User is navigated to  'Booking Shipment' screen 
  Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  
  
  @152398 @GoToReceivedJob
  Scenario: To verify user is able to go to 'Job saved ' screen by clicking on 'Go to Received Jobs' button 
  Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Click on "Go to Received Job" button on booking shipment screen for e-Booking
  Then Navigated to Saved Job screen for e-Booking
  
  
  @152399 @GoToSentJob
  Scenario: To verify user is able to go to 'Job sent ' screen by clicking on 'Go to Sent Jobs" button 
  Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Click on "Go to Sent Job" button on booking shipment screen for e-Booking
  Then Navigated to Sent Job screen for e-Booking
  
  
  @152400 @JobDetailsDisplayedOfSingleJob
  Scenario: To verify in case of Single Job, One job is visible with data disabled on forward job screen 
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  
  @152401 @JobDetailsDisplayedOfMultipleJob
  Scenario: To verify In case of multiple Jobs, multiple jobs are visible with data disabled on forward job screen
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "Copy This Job" Success popup button for e-Booking
  Then Job get saved and same details populated in the create job screen for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "Copy This Job" Success popup button for e-Booking
  Then Job get saved and same details populated in the create job screen for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Select 2 Job in saved job gird for e-Booking
  When Select 3 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected jobs details in grid for e-Booking
  
  
  @152402 
  Scenario: To verify if single job is selected to forward then OK button is displayed and user is able to click it 
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  
  @152403 
  Scenario: To verify if multiple jobs are selected to forward then Consolidate button is displayed and user is able to click it 
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Select "Yes" radio button on shipment type popup for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  
  
  @152404 @GetSchedule
  Scenario: To verify user is able to Schedule Flight by entering 'Schedule for' & on click of  'Get Schedule' button 'Air schedule' screen should open
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
   
   
  @152405 @SaveFlightDetailsForSingleJob
  Scenario Outline: To verify user is able to save Flight details with single Shipment
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When Click on "No" button on Booking status poup for e-Booking
  Then Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking
  
  Examples: 
  |prefix|
  |777   |
  
  @152406 @SaveFlightDetailsForMultipleJobs
  Scenario Outline: To verify user is able to save Flight details with multiple Shipment
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "Copy This Job" Success popup button for e-Booking
  Then Job get saved and same details populated in the create job screen for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "Copy This Job" Success popup button for e-Booking
  Then Job get saved and same details populated in the create job screen for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Select 2 Job in saved job gird for e-Booking
  When Select 3 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected jobs details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When Click on "No" button on Booking status poup for e-Booking
  Then Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking
  
  
  Examples: 
  |prefix|
  |777   |
  
  
  @152407 @SaveFlightDetailsWithUsedAwbNo
  Scenario Outline: To verify user is unable to save flight details of existing AWB No
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and "<awbNo>" and flight number to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Message popup opened with "MAWB number <prefix>-<awbNo> already used. Please use different MAWB number" message for e-Booking
  When Click on "Ok" button on Message popup for e-Booking
  Then Message popup is closed and flight details not saved for e-Booking
  
  Examples: 
  |prefix|awbNo    |
  |777   |11116630 |
  
  
  @152408 @AbleToNaviagetToCreatMawbScreen
  Scenario Outline: To verify after saving, Booking request should be saved & User is navigated to Create MAWB screen else User shall be redirected to Job sent screen
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When Click on "Yes" button on Booking status poup for e-Booking
  Then Navigated to Create MAWB screen and see message popup for e-Booking
  When Click on "Ok" button on create MAWB messsage popup for e-Booking
  Then Create MAWB Message popup closed and able see all fields auotmatically populated from job for e-Booking
     
  Examples: 
  |prefix|
  |777   |
  
  
  @152409 @NavigatedJobForwardedScreen
  Scenario Outline: 152409To verify user is able to view Jobs forwarded to Airlines
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When Click on "No" button on Booking status poup for e-Booking
  Then Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking
  
  #Given Navigated to Sent screen of e-Booking
  
  
  Examples: 
  |prefix|
  |777   |
  
  
  
  @152410 @CreateAwbSceenDisplayedWhenSelectCreateMawbOnSentJob
  Scenario Outline: To verify create a Master Air Waybill MAWB from existing Job record by selecting the option under Action column
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When Click on "No" button on Booking status poup for e-Booking
  Then Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking
  
  #Given Navigated to Sent screen of e-Booking
  When Select "<actionName>" of 1 sent job grid for e-Booking
  Then Navigated to Create MAWB screen and see message popup for e-Booking
  When Click on "Ok" button on create MAWB messsage popup for e-Booking
  Then Create MAWB Message popup closed and able see all fields auotmatically populated from job for e-Booking
  
  
  Examples: 
  |prefix|actionName  |
  |777   | Create MAWB|
  
  
  
  @152411 @CreateMasterAwbWithHawbJobThroughSentJobScreen
  Scenario Outline: 152411 To verify create a House Air Waybill (HAWB) from existing Job record by selecting the option under Action column. (MAWB must saved for this action)
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Select "Yes" radio button on shipment type popup for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Hawb Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When Click on "No" button on hawb Booking status poup for e-Booking
  Then Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking
  
  #Given Navigated to Sent screen of e-Booking
  When Select "<actionName>" of 1 sent job grid for e-Booking
  Then Navigated to Create HAWB screen and see message popup for e-Booking
  When Enter hawb number and select "<shipper>"  and "<consgineee>" and enter "<originCode>" and "<destCode>" and "<nop>" and "<grWt>" and "<cargoDescription>" amd select "<chargeCode>" of 1 row in create HAWB for e-Booking
  When Click on "Save" button in Create HAWB screen for e-Booking
  Then Status popup displayed on Create HAWB screen with "HAWB Details saved successfully" message for e-Booking
  When CLick on "Ok" button of status popup on create HAWB screen for e-Booking
  Then Navigated to Create MAWB screen and able to see added hawb details for e-Booking
  When Select "<chargeCode>" "Charge Code" on created MAWB screen for e-Booking
  When Select "<customBroker>" "Custom Broker" on created MAWB screen for e-Booking
  When Select "<rateClass>" and enter chargeble weight of 1 rate line in create MAWB screen for e-Booking
  Then Clickon Rate as agreed
  Then Enter Naure of Good as"<cargoDescription>"
  When CLick on "Save" button on create MAWB for e-Booking
  Then Awb succesfully created and Success popup opened with "Air Waybill saved successfully." on create MAWB screen for e-Booking
  When Click on "Ok" button in Success popup on create MAWB screen  for e-Booking
  Then Navigated MAWB Created screen and Saved awb details visible in the 1st row for e-Booking
  
  Examples: 
  |prefix|actionName  |shipper     |consgineee    	|originCode|destCode|nop|grWt|cargoDescription|chargeCode|customBroker											|rateClass|
  |777   |Create HAWB|ACS SHIPPER1|ACS CONSIGNEE123|BLR       |ATL     |10 |100 |TEXTILES        |PP        |JEENA N CO GLOBAL LOGISTICS       |Q        |
  
  
  @152412 @CreateMasterAwbWithJobThroughSetJobScreen
  Scenario Outline: 152412 To verify send MAWB details to Airlines by selecting the option under Action column_MAWB must saved for this action.
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  #Given Navigated to Saved screen of e-Booking
  When Select 1 Job in saved job gird for e-Booking
  When Click on "Forward To Airline" in Saved page for e-Booking
  Then Shipment type popup opened in the Boking Shipment screen for e-Booking
  When Click on "Submit" button on shipment type popup for e-Booking
  Then Booking shipment screen dispalyed with selected job details in grid for e-Booking
  When Select Airline Schedule for date for e-Booking
  When Click on "Get Schedule" button on booking shipment screen for e-Booking
  Then Ailrine Schedule Tab is displayed on booking shipment screen for e-Booking
  When Enter "<prefix>" and flight umber to add 1 airline schedule for e-Booking
  When Click on "Submit filght details" button on booking shipment screen for e-Booking
  Then Message popup opened with "Do you want to send Booking request to Airline ?" message on booking shipment screen for e-Booking
  When Click on "Yes" button on Message popup for e-Booking
  Then Booking Status popup opened with "Booking Request(s) sent to" message for e-Booking
  When Click on "No" button on Booking status poup for e-Booking
  Then Navigated to Sent job screen and able to Save flight details in the sent job grid for e-Booking
  
  #Given Navigated to Sent screen of e-Booking
  When Select "<actionName>" of 1 sent job grid for e-Booking
  Then Navigated to Create MAWB screen and see message popup for e-Booking
  When Click on "Ok" button on create MAWB messsage popup for e-Booking
  Then Create MAWB Message popup closed and able see all fields auotmatically populated from job for e-Booking
  When Select "<chargeCode>" "Charge Code" on created MAWB screen for e-Booking
  When Select "<customBroker>" "Custom Broker" on created MAWB screen for e-Booking
  When Select "<rateClass>" and enter chargeble weight of 1 rate line in create MAWB screen for e-Booking
  
  When Click on "Dimensions" icon of 1 rate line for e-Booking
  Then Dimensions popup is opened for e-Booking
  When Enter "<noOfPcs>" and "<length>" and "<width>" and "<height>" of 1 dimensionss row for e-Booking
  
  When FOR eBookking select RateAsAgreed checbox
  When CLick on "Save" button on create MAWB for e-Booking
  Then Awb succesfully created and Success popup opened with "Air Waybill saved successfully." on create MAWB screen for e-Booking
  When Click on "Ok" button in Success popup on create MAWB screen  for e-Booking
  Then Navigated MAWB Created screen and Saved awb details visible in the 1st row for e-Booking
  
  Examples: 
  |prefix|actionName  |chargeCode|customBroker								  |rateClass  |noOfPcs|length|width|height|grWt|cargoDescrption|
  |777   | Create MAWB|PP        |JEENA N CO GLOBAL LOGISTICS   |Q          |10     |10    |10   |10    |100 |Auto Parts     |

  
  @152415 @NavigatedToCreateJobScreenFromDraftScreen
  Scenario Outline: To verify Jobs in 'Created Job' screen which was saved as drafts shall be visible to the User
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save As Draft" Job button for e-Booking
  Then Draft Name popup opened for e-Booking
  When Enter "<draftName>" on Draft Name popup for e-Booking
  When Click on "Save" draft name button for e-Booking
  Then Navigated Draft screen of e-Booking and Booking Status popup displayed
  
  Examples: 
      |draftName|
      |AutoDraft|
  
  
  @152416 @CreateJobWithSavedDraft
  Scenario: To verify user is able to use Draft to create the job
  Given Navigated to Draft screen of e-Booking
  When Click on "Draft No" icon of 1 draft in draft screen for e-Booking
  Then Navigated to Create Job screen and all field are populated with data from the draft for e-Booking
  When Click on "Create Job" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  
  @152417 @EditSavedDraftJob
  Scenario Outline: To verify user is able to edit & save the draft by clicking on edit icon
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save As Draft" Job button for e-Booking
  Then Draft Name popup opened for e-Booking
  When Enter "<draftName>" on Draft Name popup for e-Booking
  When Click on "Save" draft name button for e-Booking
  Then Navigated Draft screen of e-Booking and Booking Status popup displayed
  
  #Given Navigated to Draft screen of e-Booking
  When Click on "Draft No" icon of 1 draft in draft screen for e-Booking
  #Then Navigated to Create Job screen and all field are populated with data from the draft for e-Booking
  When Edit "<shipperName>" "Shipper Name" and "<destinationCode>" "Destination Code" on create job screen for e-Booking
  #When Click on "Save Changes" Job button for e-Booking
  When Click on "Save Changes" Job button for e-Booking
  Then Booking status popup opened on draft job screen with "Draft has been saved successfully." message
  When Click "Ok" btton of Booking Status popup on draft job screeb for e-Booking
  Then Booking status popup closed and draft job grid visibile for e-Booking
  
  Examples: 
  |draftName|shipperName     |destinationCode|
  |AutoDraft|AutoTest Shipper 134|ATL            |
  
  
  @152418 @DeleteSavedDraftJob
  Scenario Outline: To verify user is able to delete existing draft by clicking on delete icon
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save As Draft" Job button for e-Booking
  Then Draft Name popup opened for e-Booking
  When Enter "<draftName>" on Draft Name popup for e-Booking
  When Click on "Save" draft name button for e-Booking
  Then Navigated Draft screen of e-Booking and Booking Status popup displayed
  
  #Given Navigated to Draft screen of e-Booking
  When Click on "Delete" icon of 1 draft in draft screen for e-Booking
  Then Confirm popup opened on Draft job screen with "Are you sure you want to delete?" message for e-Booking
  When Click on "Delete" button of confirm popup on draft job screen for e-Booking
  Then Message popup opened on Draft job screen with "Booking Draft deleted successfully." message for e-Booking
  When Click on "Ok" button of message popup on draft job screen for e-Booking
  Then Draft job is get deleted and remove from the draft job grid for e-Booking
  
  Examples: 
      |draftName|
      |AutoDraft|
  
  @152421 @NavigatedCreateJobScreenFromTemplatesScreen
  Scenario Outline: To verify Jobs in Created Job screen which was saved as Template shall be visible to the User
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save As Template" Job button for e-Booking
  Then Template popup opened for e-Booking
  When Enter "<templateName>" on Template popup for e-Booking
  When Click on "Save" Template button for e-Booking
  Then Navigated Template screen of e-Booking and Booking Status popup displayed
  
  Examples: 
      |templateName|
      |AutoTemplate|
  
  
  
  @152422 @CreateJobWithSavedTemplate
  Scenario: To verify user is able to use Template to create the job
  Given Navigated to Template screen of e-Booking
  When Click on "Template Name" icon of 1 template in Template screen for e-Booking
  Then Navigated to Create Job screen and all field are populated with data from the draft for e-Booking
  When Click on "Save" Job button for e-Booking
  Then Success popup opened and "Job saved successfully. Do you want to Create another Job/Copy this job?" message displayed
  When Click "No" Success popup button for e-Booking
  Then Navigated Saved screen of e-Booking and created job in the job list
  And  Able to see gnerated "URN" and "Job Created" "Status" for e-Booking
  
  
  
  @152423 @EditSavedTemplate
  Scenario Outline: To verify user is able to edit & save the Template by clicking on edit icon
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save As Template" Job button for e-Booking
  Then Template popup opened for e-Booking
  When Enter "<templateName>" on Template popup for e-Booking
  When Click on "Save" Template button for e-Booking
  Then Navigated Template screen of e-Booking and Booking Status popup displayed
  
  #Given Navigated to Template screen of e-Booking
  When Click on "Edit" icon of 1 template in Template screen for e-Booking
  Then Navigated to Create Job screen and all field are populated with data from the template for e-Booking
  When Edit "<shipperName>" "Shipper Name" and "<destinationCode>" "Destination Code" on create job screen for e-Booking
  When Click on "Save Changes" Job button for e-Booking
  Then Booking status popup opened on template job screen with "Template saved successfully." message
  When Click "Ok" btton of Booking Status popup on template job screen for e-Booking
  Then Booking status popup closed and template job grid visibile for e-Booking
  
  
  Examples: 
  |templateName|shipperName         |destinationCode|
  |AutoTemplate|AutoTest Shipper 134|ATL            |
  
  
  @152424 @DeleteSavedTemplate
  Scenario Outline: To verify user is able to delete existing template by clicking on delete icon
  Given Navigated to Create screen of e-Booking
  When Choose file from the local directory for e-Booking
  When Click on "Upload" button to choose file for e-Booking
  Then All mandatory field get populated with data from the excel file for e-Booking
  When Click on "Save As Template" Job button for e-Booking
  Then Template popup opened for e-Booking
  When Enter "<templateName>" on Template popup for e-Booking
  When Click on "Save" Template button for e-Booking
  Then Navigated Template screen of e-Booking and Booking Status popup displayed
  
  #Given Navigated to Template screen of e-Booking
  When Click on "Delete" icon of 1 template in Template screen for e-Booking
  #When Click on "Delete" icon of 1 template in template screen for e-Booking
  Then Confirm popup opened on template job screen with "Are you sure you want to delete?" message for e-Booking
  When Click on "Delete" button of confirm popup on template job screen for e-Booking
  Then Message popup opened on template job screen with "Booking Template deleted successfully." message for e-Booking
  When Click on "Ok" button of message popup on template job screen for e-Booking
  Then template job is get deleted and remove from the template job grid for e-Booking
  
  Examples: 
      |templateName|
      |AutoTemplate|