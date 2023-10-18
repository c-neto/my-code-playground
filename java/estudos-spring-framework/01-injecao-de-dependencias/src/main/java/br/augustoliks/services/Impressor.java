package br.augustoliks.services;


import br.augustoliks.domain.api.CariocaCostumes;
import br.augustoliks.domain.api.GauchoCostumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Impressor {
    @Qualifier("gaucho-inocente")
    @Autowired
    private GauchoCostumes gauchoNutella;

    @Qualifier("gaucho-da-gema")
    @Autowired
    private GauchoCostumes gauchoRaiz;

    @Qualifier("carioca-da-gema")
    @Autowired
    private CariocaCostumes cariocaRaiz;
    private CariocaCostumes cariocaNutella;

    @Qualifier("carioca-inocente")
    @Autowired
    public void injetaCariocaNutella(CariocaCostumes cariocaNutella){
        this.cariocaNutella = cariocaNutella;
    }

    private String atributosDeGauchoFormatados(GauchoCostumes gaucho){
        return "\t- falaEnrolado:" + String.valueOf(gaucho.falaEnrolado()) + "\n" +
                "\t- jogaFutebol:" + String.valueOf(gaucho.jogaFutebol()) + "\n" +
                "\t- ouveBaitaca:" + String.valueOf(gaucho.ouveBaitaca()) + "\n" +
                "\t- tomaChimarrao: " + String.valueOf(gaucho.tomaChimarrao());
    }

    private String atributosDeGauchoFormatados(CariocaCostumes cariocaCostumes){
        return "\t- jogaFutebol:" + String.valueOf(cariocaCostumes.jogaFutebol()) + "\n" +
                "\t- vaiPraPraia:" + String.valueOf(cariocaCostumes.vaiPraPraia()) + "\n";
    }

    public void mostrarInformacoes() {
        System.out.println("Gaucho Nutella:");
        System.out.println(atributosDeGauchoFormatados(gauchoNutella));
        System.out.println("Gaucho Raiz:");
        System.out.println(atributosDeGauchoFormatados(gauchoRaiz));

        System.out.println("Carioca Raiz:");
        System.out.println(atributosDeGauchoFormatados(cariocaRaiz));
        System.out.println("Carioca Nutella:");
        System.out.println(atributosDeGauchoFormatados(cariocaNutella));
    }
}
