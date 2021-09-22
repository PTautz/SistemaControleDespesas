package br.com.sistemacontroledespesas.api.controller;

import br.com.sistemacontroledespesas.api.controller.param.DataFinalInicial;
import br.com.sistemacontroledespesas.api.domain.Balanco;
import br.com.sistemacontroledespesas.api.repository.DespesaRepository;
import br.com.sistemacontroledespesas.api.repository.EntradaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

//Executa teste com extensoes do Mockito
@ExtendWith({MockitoExtension.class})
public class BalancoControllerTeste {

    //Anotação que injeta os "mocks" - Precisa adicionar dependencia no pom.XML
    //Mock são objetos com comportamento modificado especificamente para testes
    @InjectMocks
    private BalancoController balancoControllerTeste;

    //Trata o objeto como um "Mock"
    @Mock
    private DespesaRepository despesaRepositoryMock;
    @Mock
    private EntradaRepository entradaRepositoryMock;

    // anotação que marca o metodo como um metodo de teste
    @Test
    //metodo que testa o teste =P
    public void testeTeste() {
        //verifica se a condição esperada do teste foi respeitada
        Assertions.assertTrue(true);
    }

    @Test
    public void calculaBalancoTeste_zero() {
        DataFinalInicial dataFinalInicial = new DataFinalInicial();
        dataFinalInicial.setDataInicial(LocalDateTime.now());
        dataFinalInicial.setDataFinal(LocalDateTime.now());

        Mockito.when(despesaRepositoryMock.findByDataDespesaBetween(Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(new ArrayList<>());
        Mockito.when(entradaRepositoryMock.findByDataEntradaBetween(Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(new ArrayList<>());

        // chamada de teste
        Balanco balancoRetorno = balancoControllerTeste.calculaBalanco(dataFinalInicial);

        Balanco balancoEsperado = new Balanco();
        balancoEsperado.setBalanco(BigDecimal.ZERO);
        balancoEsperado.setTotalEntradas(BigDecimal.ZERO);
        balancoEsperado.setTotalDespesas(BigDecimal.ZERO);

        Assertions.assertEquals(balancoEsperado.getBalanco(), balancoRetorno.getBalanco());
        Assertions.assertEquals(balancoEsperado.getTotalDespesas(), balancoRetorno.getTotalDespesas());
        Assertions.assertEquals(balancoEsperado.getTotalEntradas(), balancoRetorno.getTotalEntradas());

    }

    @Test
    public void calculaBalancoTeste_valores() {
        DataFinalInicial dataFinalInicial = new DataFinalInicial();
        dataFinalInicial.setDataInicial(LocalDateTime.now());
        dataFinalInicial.setDataFinal(LocalDateTime.now());

        Mockito.when(despesaRepositoryMock.findByDataDespesaBetween(Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(new ArrayList<>());
        Mockito.when(entradaRepositoryMock.findByDataEntradaBetween(Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(new ArrayList<>());

        // chamada de teste
        Balanco balancoRetorno = balancoControllerTeste.calculaBalanco(dataFinalInicial);

        Balanco balancoEsperado = new Balanco();
        balancoEsperado.setBalanco(BigDecimal.ZERO);
        balancoEsperado.setTotalEntradas(BigDecimal.ZERO);
        balancoEsperado.setTotalDespesas(BigDecimal.ZERO);

        Assertions.assertEquals(balancoEsperado.getBalanco(), balancoRetorno.getBalanco());
        Assertions.assertEquals(balancoEsperado.getTotalDespesas(), balancoRetorno.getTotalDespesas());
        Assertions.assertEquals(balancoEsperado.getTotalEntradas(), balancoRetorno.getTotalEntradas());

    }

}
