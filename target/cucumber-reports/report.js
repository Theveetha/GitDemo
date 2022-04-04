$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/PlaceValidations.feature");
formatter.feature({
  "name": "Validating Place API\u0027s",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verfiy if Place is being successfully added using AddPlace API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddPlace"
    },
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "Add Place Payload with \"\u003cname\u003e\" \"\u003caddress\u003e\" \"\u003clanguage\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "User calls \"getAddPlace\" with \"Post\" http request",
  "keyword": "When "
});
formatter.step({
  "name": "API call is success with Status Code 200",
  "keyword": "Then "
});
formatter.step({
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.step({
  "name": "\"scope\" in response body is \"APP\"",
  "keyword": "And "
});
formatter.step({
  "name": "verify \"place_id\" created maps to \"\u003cname\u003e\" using \"getGetPlace\" for \"name\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "address",
        "language"
      ]
    },
    {
      "cells": [
        "Tom",
        "HIG II-15",
        "Tamil"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verfiy if Place is being successfully added using AddPlace API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddPlace"
    },
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "Add Place Payload with \"Tom\" \"HIG II-15\" \"Tamil\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.StepDefinitions.add_Place_Payload_with(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User calls \"getAddPlace\" with \"Post\" http request",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.StepDefinitions.user_calls_with_http_request(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "API call is success with Status Code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.StepDefinitions.api_call_is_success_with_Status_Code(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.StepDefinitions.in_response_body_is(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"scope\" in response body is \"APP\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.StepDefinitions.in_response_body_is(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"place_id\" created maps to \"Tom\" using \"getGetPlace\" for \"name\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.StepDefinitions.verify_created_maps_to_using(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});