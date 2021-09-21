package br.com.sistemacontroledespesas.api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;


public class Despesa {


    @Id
    private String id;
    //@Field define o tipo a ser usado no banco de dados
    @Field(targetType = DECIMAL128)
    private BigDecimal valor;
    private String nomeDespesa;
    private LocalDate dataDespesa;

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

    public LocalDate getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(LocalDate dataDespesa) {
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
