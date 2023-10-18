package br.augustoliks.domain.implementation;

import br.augustoliks.domain.api.CariocaCostumes;

public class CariocaRaiz extends Pessoa implements CariocaCostumes {

    public CariocaRaiz() {
    }

    public CariocaRaiz(String name, Integer age) {
        super(name, age);
    }

    @Override
    public Boolean vaiPraPraia() {
        return Boolean.TRUE;
    }

    @Override
    public Boolean jogaFutebol() {
        return Boolean.TRUE;
    }
}
