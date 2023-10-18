package br.augustoliks.domain.implementation;

import br.augustoliks.domain.api.CariocaCostumes;

public class CariocaNutella extends Pessoa implements CariocaCostumes {
    public CariocaNutella() {
    }

    public CariocaNutella(String name, Integer age) {
        super(name, age);
    }

    @Override
    public Boolean vaiPraPraia() {
        return Boolean.TRUE;
    }

    @Override
    public Boolean jogaFutebol() {
        return Boolean.FALSE;
    }
}
