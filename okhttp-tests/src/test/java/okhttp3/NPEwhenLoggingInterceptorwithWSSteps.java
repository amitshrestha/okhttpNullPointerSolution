package okhttp3;

//comp530 My Change

import okhttp3.internal.http.HttpEngine;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.jbehave.core.annotations.*;
public class NPEwhenLoggingInterceptorwithWSSteps{
    public final MockWebServer server = new MockWebServer() ;
    public boolean forWebSocket = true;
	@Given("a request is made to OKHTTP")
	@Pending
	public void givenARequestIsMadeToOKHTTP(){
		 //TODO 
            server.enqueue(new MockResponse()
                .setBody("Cpntent/Type")
                .setResponseCode(500)
                .setHeader("Upgrade", "websocket")
                .setHeader("Connection", "Downgrade")
                .setHeader("Sec-WebSocket-Accept", "ujmZX4KXZqjwy6vi1aQFH5p4Ygk="));

        final Request request = new Request.Builder()
                .url(server.url("/path"))
                .header("User-Agent", "Test Case")
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();

	}
	@Then("an empty body is created automatically and the proper response code is sent")
	@Pending
	public void thenAnEmptyBodyIsCreatedAutomaticallyAndTheProperResponseCodeIsSent(){
            //TODO 
            server.enqueue(new MockResponse()
                //My Change
                .setBody("")
                .setResponseCode(500)
                .setHeader("Upgrade", "websocket")
                .setHeader("Connection", "Downgrade")
                .setHeader("Sec-WebSocket-Accept", "ujmZX4KXZqjwy6vi1aQFH5p4Ygk="));

        final Request request = new Request.Builder()
                .url(server.url("/path"))
                .header("User-Agent", "Test Case")
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        
         HttpEngine engine = new HttpEngine(client, request, true, true, true, null, null, null);
//          engine.proceed(request);
	}
	@When("OKHTTP module fails to create the response body")
	@Pending
	public void whenOKHTTPModuleFailsToCreateTheResponseBody(){
		 //TODO 
                 
            server.enqueue(new MockResponse()
                //My Change
                //.setBody("Cpntent/Type")
                .setResponseCode(500)
                .setHeader("Upgrade", "websocket")
                .setHeader("Connection", "Downgrade")
                .setHeader("Sec-WebSocket-Accept", "ujmZX4KXZqjwy6vi1aQFH5p4Ygk="));

        final Request request = new Request.Builder()
                .url(server.url("/path"))
                .header("User-Agent", "Test Case")
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
	}
}