package Decorator;

public class DescontoINSS  extends  FolhaPagamentoDecorator{

    public DescontoINSS(FolhaPagamento folhaPagamento) {
        super(folhaPagamento);
    }

    @Override
    public float getPercentualModificacao() {
        return -5.0f;
    }

}
