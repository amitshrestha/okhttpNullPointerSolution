Narrative:
In order to avoid the Nul Pointer Exception when logging-interceptor:3.0.1 with okhttp-ws:3.0.1
As a development team member
I want to add NULL validations to the code and send proper response code

Scenario: Handle Null Pointer Exception while logging-interceptor:3.0.1with okhttp-ws:3.0.1
Given a request is made to OKHTTP
When OKHTTP module fails to create the response body
Then an empty body is created automatically and the proper response code is sent


