package br.com.sistemacontroledespesas.api.controller.param;

import br.com.sistemacontroledespesas.api.domain.Entrada;
import lombok.Data;

//Classe que cria objeto para calcular recorrencia da entrada
@Data
public class DataEntrada {
    //Ponto de partida da contagem da recorrência da entrada
    private Entrada entradaInicial;

    //Quantas vezes a entrada ocorre
    private int numeroDeVezes;
}
