Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verfiy if Place is being successfully added using AddPlace API
	Given Add Place Payload with "<name>" "<address>" "<language>"
	When User calls "getAddPlace" with "Post" http request
	Then API call is success with Status Code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify "place_id" created maps to "<name>" using "getGetPlace" for "name"
	
Examples:
	| name  | address   | language  |
	| Tom   | HIG II-15 | Tamil     |
#	|Hilton | Pinnacle  | Latin     |
	
@UpdatePlace @Regression
Scenario Outline: Update the Place with new address
	Given "Update" Place Payload
	When User calls "getUpdatePlace" with "Update" http request
	Then API call is success with Status Code 200
	And "msg" in response body is "Address successfully updated"
	And verify "place_id" created maps to "<new address>" using "getGetPlace" for "address"
	
Examples:
	|new address     |
	|Seetha ram nagar|

@DeletePlace @Regression
Scenario: Delete the newly added Place
	Given "Delete" Place Payload
	When User calls "getDeletePlace" with "Delete" http request
	Then API call is success with Status Code 200
	And "status" in response body is "OK"
	And verify "place_id" using "getGetPlace"	
	And "msg" in response body is "Get operation failed, looks like place_id  doesn't exists"