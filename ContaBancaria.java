package CrudBank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class ContaBancaria {
	public String cliente;
    public int numero;
    public double saldo;
    public String historico = "";
    
    
    
    //saque
    public void sacar (double valorSaque){
        if (valorSaque > saldo){
        	JOptionPane.showMessageDialog(null,"Não foi possivel sacar, "
            + "pois o valor sacado é maior do que o saldo");
            return;
        }else{
        	JOptionPane.showMessageDialog(null,"saque realizado com sucesso");
        }
         saldo -= valorSaque;
         historico += "SAQUE: " + "\nData: " + retornarDataHoraAtual() 
                 + "\nValor do saque: R$" + valorSaque + "\n\n";
    }
    public String retornarDataHoraAtual(){
        return  LocalDateTime
                 .now()
                 .format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }
    
    //deposito
    public void depositar (double valorDeposito){
        saldo = saldo + valorDeposito;
        historico += "DEPOSITO: " + "\nData: " +retornarDataHoraAtual() + "\nValor do deposito R$ "
                + valorDeposito + "\n\n";
    }
    
    //pagar conta
    public boolean pagarConta (String nome, double valor){
        if (valor > saldo){
            return false;
        }
       saldo -= valor;
       historico += "PAGAMENTO: " + "\nNome da conta: " + nome + "\nData do pagamento: " + retornarDataHoraAtual()
               + "\nValor da conta R$" + valor + "\n\n";
       return true;
    }
    
    //extrato
    public void extrato(){
    	JOptionPane.showMessageDialog(null,"\nCliente: " + cliente 
                + "\nconta: " + numero 
                + "\ndata do extrato: " + retornarDataHoraAtual() 
                + "\n\nEXTRATO: " + "\n" + historico);
    }
    
    //informações basicas
    public void informacoesBasicas (){
        cliente = JOptionPane.showInputDialog("nome: ");
        numero = Integer.valueOf(JOptionPane.showInputDialog("numero da conta : "));
        
        JOptionPane.showMessageDialog(null, "informaçoes básicas alteradas com sucesso");
        
    }
    
    
    
}


