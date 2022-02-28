package br.com.agenda.model;

public enum StatusAgendamento {

    aprovado("APROVADO"),
    pendente("PENDENTE"),
    recusado("RECUSADO"),
    cancelado("CANCELADO"),
    compareceu("COMPARECEU"),
    naoCompareceu("NÃO COMPARECEU");

    public final String valor;

    private StatusAgendamento(String valor){
        this.valor = valor;
    }

}
