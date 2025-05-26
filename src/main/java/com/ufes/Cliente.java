package com.ufes;

public class Cliente {
    private String nome;
    private String tipo;
    private double fidelidade;
    private String logadouro;
    private String bairro;
    private String cidade;

    public Cliente(String nome, String tipo, double fidelidade, String logadouro, String bairro, String cidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.fidelidade = fidelidade;
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.cidade = cidade;
    }


    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public double getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(double fidelidade) {
        this.fidelidade = fidelidade;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fidelidade=" + fidelidade +
                ", logadouro='" + logadouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
