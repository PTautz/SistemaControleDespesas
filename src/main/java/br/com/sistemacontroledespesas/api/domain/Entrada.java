package br.com.sistemacontroledespesas.api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

public class Entrada {


    @Id
    private String id;

    @Field(targetType = DECIMAL128)
    private BigDecimal valor;
    private String nomeEntrada;
    private LocalDateTime dataEntrada;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomeEntrada() {
        return nomeEntrada;
    }

    public void setNomeEntrada(String nomeEntrada) {
        this.nomeEntrada = nomeEntrada;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", nomeEntrada='" + nomeEntrada + '\'' +
                ", dataEntrada=" + dataEntrada +
                '}';
    }
}
