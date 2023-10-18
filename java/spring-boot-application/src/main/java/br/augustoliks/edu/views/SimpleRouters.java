package br.augustoliks.edu.views;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRouters {
    @Value("${spring.application.name}")
    private String name;

    @Value("${variavel.aleatoria}")
    private String variavelAleatoria;

    @RequestMapping("/")
    public String root() {
        return "Carlos";
    }

    @RequestMapping("/app")
    public String getValueFromApplicationProperties() {
        return name;
    }

    @RequestMapping("/teste01")
    public String getVariavelAleatoria() {
        return variavelAleatoria;
    }
}
