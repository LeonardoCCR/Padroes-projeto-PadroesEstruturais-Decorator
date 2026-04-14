package Decorator;

public abstract class FolhaPagamentoDecorator implements FolhaPagamento{

    //Decorator da minha interface ( Produto base )
    //É uma classe abstrata base para os decoradores

    //Método que retorna modificadores únicos;
    //Implementa o método da interface para que assim seja pego e calculado o valor

    //Recebo um produto base para ser acessado recursivamente


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

    public float getSalarioLiquido() {
        return this.getFolhaPagamento().getSalarioLiquido() * (1 + (this.getPercentualModificacao() / 100));
    }

    public abstract float getPercentualModificacao();
}
