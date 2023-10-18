package br.augustoliks.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerMain {
    public static void main(String[] args) {
        String carlos = new String("Hello");
        System.out.println(carlos);

        SpringApplication.run(RunnerMain.class, args);
    }
}
