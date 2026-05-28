package banco.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

public abstract class ContaBancaria {
    private String numeroConta;
    private Cliente titular;
    private double saldo;
    private List<String> historico;
    private LocalDateTime evento;
    private DateTimeFormatter formatador;

    ContaBancaria(String numeroConta, Cliente titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        saldo = saldoInicial;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            evento = LocalDateTime.now();
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            historico.add(String.format("Depósito: R$%.2f - %s", valor, evento.format(formatador)));
        } else {
            JOptionPane.showMessageDialog(null, "Valor de depósito inválido", "Erro no depósito",
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            evento = LocalDateTime.now();
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            historico.add(String.format("Saque: R$%.2f - %s", valor, evento.format(formatador)));
        } else if (valor > saldo) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Erro no saque",
            JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Valor de saque inválido", "Erro no saque",
            JOptionPane.ERROR_MESSAGE);
        }
    }

    void exibirSaldo() {
        JOptionPane.showMessageDialog(null, String.format("Saldo atual: R$%.2f", saldo), "Saldo Atual",
        JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected void registrarTransacao(String descricao) {
        evento = LocalDateTime.now();
        formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        historico.add(String.format("%s - %s", descricao, evento.format(formatador)));

    }

    void exibirHistorico() {
        
    }
}
