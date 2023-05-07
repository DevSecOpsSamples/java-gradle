package com.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SampleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHome() {
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("OK", response.getBody());
    }

    @Test
    public void testPingPath1() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sample", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("OK", response.getBody());
    }

    @Test
    public void testPingPath2() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sample/test1", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("OK", response.getBody());
    }

    @Test
    public void testPingPath3() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sample/test1/test2", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("OK", response.getBody());
    }

    @Test
    public void testPingPath4() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sample/test1/test2/test3", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("OK", response.getBody());
    }
}
