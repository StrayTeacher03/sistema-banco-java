package banco.interfaces;

interface Operavel {
    void depositar(double valor);

    boolean sacar(double valor);

    void exibirSaldo();
}
