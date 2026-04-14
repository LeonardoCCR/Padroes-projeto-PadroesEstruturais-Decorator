package Decorator;

public class ValeTransporte extends FolhaPagamentoDecorator {

    public ValeTransporte(FolhaPagamento folhaPagamento) {
        super(folhaPagamento);
    }

    @Override
    public float getPercentualModificacao() {
        return -6.0f;
    }
}
