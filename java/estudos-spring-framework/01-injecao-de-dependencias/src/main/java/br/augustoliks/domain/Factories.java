package br.augustoliks.domain;

import br.augustoliks.domain.api.CariocaCostumes;
import br.augustoliks.domain.api.GauchoCostumes;
import br.augustoliks.domain.implementation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Factories {
    @Bean
    @Qualifier("gaucho-da-gema")
    public GauchoCostumes produzGauchoRaiz(){
        return new GauchoRaiz("Humberto Gessinger", 50);
    }

    @Bean
    @Qualifier("gaucho-inocente")
    public GauchoCostumes produzGauchoNutella(){
        return new GauchoNutella("Enzo", 20);
    }

    @Bean
    @Qualifier("carioca-da-gema")
    public CariocaCostumes produzCariocaRaiz(){
        return new CariocaRaiz("Romario", 50);
    }

    @Bean
    @Qualifier("carioca-inocente")
    public CariocaCostumes produzCariocaNutella(){
        return new CariocaNutella("YFG Nobre", 20);
    }

}
