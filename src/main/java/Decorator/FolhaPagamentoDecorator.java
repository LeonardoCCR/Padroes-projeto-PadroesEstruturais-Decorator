package Decorator;

public abstract class FolhaPagamentoDecorator {

    //Decorator da minha interface ( Produto base )
    //É uma classe abstrata base para os decoradores

    //Recebo um produto base para ser decorado
    private FolhaPagamento folhaPagamento;

    public FolhaPagamentoDecorator(FolhaPagamento folhaPagamento) {
        this.folhaPagamento = folhaPagamento;
    }

    public FolhaPagamento getFolhaPagamento(){
        return this.folhaPagamento;
    }

    public void setFolhaPagamento(FolhaPagamento folhaPagamento){
        this.folhaPagamento = folhaPagamento;
    }

    public abstract float getPercentualModificacao();
}
