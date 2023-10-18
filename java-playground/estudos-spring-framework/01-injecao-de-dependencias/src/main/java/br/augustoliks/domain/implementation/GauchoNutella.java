package br.augustoliks.domain.implementation;

import br.augustoliks.domain.api.GauchoCostumes;


public class GauchoNutella extends Pessoa implements GauchoCostumes {
    public GauchoNutella(String name, Integer age) {
        super(name, age);
    }

    public GauchoNutella() {
    }

    @Override
    public Boolean tomaChimarrao() {
        return Boolean.TRUE;
    }

    @Override
    public Boolean ouveBaitaca() {
        return Boolean.FALSE;
    }

    @Override
    public Boolean falaEnrolado() {
        return Boolean.FALSE;
    }

    @Override
    public Boolean jogaFutebol() {
        return Boolean.FALSE;
    }
}
