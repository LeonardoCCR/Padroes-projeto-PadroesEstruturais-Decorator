package Decorator;

public class AdicionalPericulosidade extends FolhaPagamentoDecorator{

    public AdicionalPericulosidade(FolhaPagamento folhaPagamento) {
        super(folhaPagamento);
    }

    @Override
    public float getPercentualModificacao() {
        return 10.0f;
    }
}
