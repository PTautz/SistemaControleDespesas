package br.com.sistemacontroledespesas.api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;


public class Despesa {


    @Id
    private String id;
    //@Field define o tipo a ser usado no banco de dados
    @Field(targetType = DECIMAL128)
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
