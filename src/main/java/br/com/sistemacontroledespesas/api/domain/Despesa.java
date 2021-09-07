package br.com.sistemacontroledespesas.api.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Despesa {


    @Id
    private String id;
    private BigDecimal valor;
    private String nomeDespesa;
    private LocalDateTime dataDespesa;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public LocalDateTime getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(LocalDateTime dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", nomeDespesa='" + nomeDespesa + '\'' +
                ", dataDespesa=" + dataDespesa +
                '}';
    }
}
