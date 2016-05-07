Narrative:
In order to avoid the inconsistent behavior in the number of concurrent streams
As a development team member
I want to ensure the maximum concurrent stream is correctly set

Scenario: Server sends settings to the client
Given the server sets 10 as the maximum limit of concurrent stream
When a client requests server for settings
Then the maximum concurrent stream at a time should be 10