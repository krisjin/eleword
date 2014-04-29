package net.eleword.blog.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Elemental example for executing multiple GET requests sequentially.
 */
public class ElementalHttpGet {

	private static final String SAMPLE_URL = "http://ipapi.sinaapp.com/api.php?f=text&ip=122.205.7.82";

    private CloseableHttpClient instance;

    private CloseableHttpResponse response;

    @Before
    public final void before() {
        instance = HttpClientBuilder.create().build();
        System.out.println("before");
    }

    @After
    public final void after() throws IllegalStateException, IOException {
        if (response == null) {
            return;
        }
        System.out.println("after");
        try {
            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                final InputStream instream = entity.getContent();
                instream.close();
            }
        } finally {
            response.close();
        }
    }


   // @Test
    public final void whenExecutingBasicGetRequest_thenNoExceptions() throws ClientProtocolException, IOException {
        response = instance.execute(new HttpGet(SAMPLE_URL));
    }

   // @Test
    public final void givenGetRequestExecuted_whenAnalyzingTheResponse_thenCorrectStatusCode() throws ClientProtocolException, IOException {
        response = instance.execute(new HttpGet(SAMPLE_URL));
        final int statusCode = response.getStatusLine().getStatusCode();
    }

    @Test
    public final void givenGetRequestExecuted_whenAnalyzingTheResponse_thenCorrectMimeType() throws ClientProtocolException, IOException {
        response = instance.execute(new HttpGet(SAMPLE_URL));
        final String contentMimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        
		System.out.println(EntityUtils.toString(response.getEntity()));

    }

    //@Test
    public final void givenGetRequestExecuted_whenAnalyzingTheResponse_thenCorrectBody() throws ClientProtocolException, IOException {
        response = instance.execute(new HttpGet(SAMPLE_URL));
        final String bodyAsString = EntityUtils.toString(response.getEntity());

    }

}
