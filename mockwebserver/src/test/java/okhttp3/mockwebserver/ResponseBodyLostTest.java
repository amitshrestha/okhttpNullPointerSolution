package okhttp3.mockwebserver;

//comp530 My Change
import okio.Buffer;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResponseBodyLostTest {
    @Rule
    public final MockWebServer server = new MockWebServer();

    @Test
    public void test() throws Exception {
        server.enqueue(new MockResponse()
                // comp530 My Change
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


        WebSocketCall webSocketCall = WebSocketCall.create(client, request);
        final BlockingQueue<Response> responses = new LinkedBlockingDeque<>();

        webSocketCall.enqueue(new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                responses.add(response);
            }

            @Override
            public void onFailure(IOException e, Response response) {
                responses.add(response);
            }

            @Override
            public void onMessage(ResponseBody message) throws IOException {
                System.exit(0);
            }

            @Override
            public void onPong(Buffer payload) {}

            @Override
            public void onClose(int code, String reason) {}
        });
        Response r = responses.poll(5, TimeUnit.SECONDS);

        assertNotNull(r);
        assertNotNull(r.body());
        // comp530 My Change
       assertEquals("Content/Type", r.body().contentType().toString());
    }
}