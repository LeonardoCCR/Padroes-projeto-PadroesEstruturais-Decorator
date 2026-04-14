package Decorator;

public class BonusAniversario extends FolhaPagamentoDecorator {

    public BonusAniversario(FolhaPagamento folhaPagamento) {
        super(folhaPagamento);
    }

    @Override
    public float getPercentualModificacao() {
        return 25.0f;
    }
}
