package Decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FolhaPagamentoTest {

    @Test
    void deveRetornarSalarioBase() {
        FolhaPagamento folha = new FolhaPagamentoFuncionario(1000.0f);
        assertEquals(1000.0f, folha.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioComDescontoINSS() {
        // -5% de 1000 = 950
        FolhaPagamento folha = new DescontoINSS(new FolhaPagamentoFuncionario(1000.0f));
        assertEquals(950.0f, folha.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioComBonusAniversario() {
        // +25% de 1000 = 1250
        FolhaPagamento folha = new BonusAniversario(new FolhaPagamentoFuncionario(1000.0f));
        assertEquals(1250.0f, folha.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioComValeTransporte() {
        // -6% de 1000 = 940
        FolhaPagamento folha = new ValeTransporte(new FolhaPagamentoFuncionario(1000.0f));
        assertEquals(940.0f, folha.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioComAdicionalPericulosidade() {
        // +10% de 1000 = 1100
        FolhaPagamento folha = new AdicionalPericulosidade(new FolhaPagamentoFuncionario(1000.0f));
        assertEquals(1100.0f, folha.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioComInssMaisValeTransporte() {
        // 1000 - 5% (INSS) = 950 -> 950 - 6% (VT) = 893
        FolhaPagamento folha = new ValeTransporte(new DescontoINSS(new FolhaPagamentoFuncionario(1000.0f)));
        assertEquals(893.0f, folha.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioComPericulosidadeMaisBonusAniversario() {
        // 1000 + 10% = 1100 -> 1100 + 25% = 1375
        FolhaPagamento folha = new BonusAniversario(new AdicionalPericulosidade(new FolhaPagamentoFuncionario(1000.0f)));
        assertEquals(1375.0f, folha.getSalarioLiquido());
    }

    @Test
    void deveRetornarSalarioComTodosModificadores() {
        /*
        1000 + 10% (Peric) = 1100
        1100 + 25% (Bonus) = 1375
        1375 - 5% (INSS) = 1306.25
        1306.25 - 6% (VT) = 1227.875
        */
        FolhaPagamento folha = new ValeTransporte(new DescontoINSS(new BonusAniversario(new AdicionalPericulosidade(new FolhaPagamentoFuncionario(1000.0f)))));

        //Resultado esperado:
        assertEquals(1227.875f, folha.getSalarioLiquido());
    }
}