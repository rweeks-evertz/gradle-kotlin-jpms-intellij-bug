package io.github.rweeks.evertz;

import io.github.rweeks.evertz.kotlin.common.JavaEntryPoint;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void test() {
        JavaEntryPoint.runTest();
    }
}
