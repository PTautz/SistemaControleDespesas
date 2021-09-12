package br.com.sistemacontroledespesas.api.controller.param;

import java.time.LocalDateTime;

public class DataFinalInicial {
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "DataFinalInicial{" +
                "dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                '}';
    }
}
