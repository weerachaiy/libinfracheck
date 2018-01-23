package com.cisco.devnet.infracheck;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class InfraCheckTest {

    String TICKET;
    InfraCheck health = new InfraCheck();

    @Before
    public void setUp() {
        TICKET = String.valueOf(health.getTicket());
    }

//    @Test
//    public void testPathCheck() throws  Exception {
//        String result = health.pathCheck(TICKET)
//                .getBody()
//                .getObject()
//                .getJSONObject("response")
//                .getJSONObject("request")
//                .getString("status");
//
//        assertEquals("FAILED", result);
//
//    }

    @Test
    public void testOptionalPathCheck() throws  Exception {
        String result = health.pathCheck(TICKET, "3772b101-6769-4dd7-9fbf-cdd45d8971ea")
                .getBody()
                .getObject()
                .getJSONObject("response")
                .getJSONObject("request")
                .getString("status");

        assertEquals("FAILED", result);

    }

//    @Test
//    public void testCreatePathTrace() throws Exception {
//
//
//        HttpResponse<JsonNode> response = health.createPathTrace(TICKET,"192.168.1.128", "192.168.1.169");
//
//        String result = response.getBody()
//                .getObject()
//                .getJSONObject("response")
//                .getString("url");
//
//        assertNotEquals(null, result);
//    }


}
