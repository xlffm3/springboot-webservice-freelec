package com.glenn.book.springboot.web;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest extends TestCase {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loadTest() {
        String body = this.restTemplate.getForObject("/", String.class);

        assertThat(body).contains("Spring Boot로 시작하는 Web-Service");
    }
}