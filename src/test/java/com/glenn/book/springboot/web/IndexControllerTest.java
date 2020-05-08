package com.glenn.book.springboot.web;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest extends TestCase {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loadTest() {
        String body = this.restTemplate.getForObject("/", String.class);

        assertThat(body).contains("Spring Boot로 시작하는 Web-Service");
    }
}