package br.com.sistemacontroledespesas.api.domain;
import lombok.Data;

import java.math.BigDecimal;

//Usando lombok para Getters/Setters
@Data
public class Balanco {
    private BigDecimal totalEntradas;
    private BigDecimal totalDespesas;
    private BigDecimal balanco;

}
