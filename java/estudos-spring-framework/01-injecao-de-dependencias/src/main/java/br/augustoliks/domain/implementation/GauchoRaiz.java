package br.augustoliks.domain.implementation;

import br.augustoliks.domain.api.GauchoCostumes;

public class GauchoRaiz extends Pessoa implements GauchoCostumes {
    public GauchoRaiz() {
    }

    public GauchoRaiz(String name, Integer age) {
        super(name, age);
    }

    @Override
    public Boolean tomaChimarrao() {
        return Boolean.TRUE;
    }

    @Override
    public Boolean ouveBaitaca() {
        return Boolean.TRUE;
    }

    @Override
    public Boolean falaEnrolado() {
        return Boolean.TRUE;
    }

    @Override
    public Boolean jogaFutebol() {
        return Boolean.FALSE;
    }
}
