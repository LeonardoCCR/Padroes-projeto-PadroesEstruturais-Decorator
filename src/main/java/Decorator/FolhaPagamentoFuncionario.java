package Decorator;

public class FolhaPagamentoFuncionario implements FolhaPagamento{


    //getSalarioLiquido() desse é diferente do get salário líquido do decorator, pois esse aqui é o objeto base

        private float valor;

        public FolhaPagamentoFuncionario() {
        }
        public FolhaPagamentoFuncionario(float valor) {
            this.valor = valor;
        }

        @Override
        public float getSalarioLiquido() {
            return this.valor;
        }

}
