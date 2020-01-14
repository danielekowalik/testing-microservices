package org.example;

import org.example.controller.ExampleController;
import org.example.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ExampleController exampleController;

    @Autowired
    private ExampleService exampleService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(exampleController).isNotNull();
        assertThat(exampleService).isNotNull();
    }
}
