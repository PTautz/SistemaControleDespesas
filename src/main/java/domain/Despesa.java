package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Despesa {
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
}
