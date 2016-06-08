package com.example.helder.serial;

import java.io.Serializable;

/**
 * Created by Helder on 01/06/2016.
 */
public class Botao implements Serializable{
    private String nome;
    private String codigo;

    public Botao(String nome, String cod) {
        this.nome = nome;
        this.codigo = cod;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
