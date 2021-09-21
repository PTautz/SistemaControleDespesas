package br.com.sistemacontroledespesas.api.controller.param;

import br.com.sistemacontroledespesas.api.domain.Despesa;
import lombok.Data;

//Classe que cria objeto para calcular recorrencia da despesa
@Data
public class DataDespesa {
    //Ponto de partida da contagem da recorrência da despesa
    private Despesa despesaInical;

    //Quantas vezes a despesa ocorre
    private int numeroDeVezes;
}
