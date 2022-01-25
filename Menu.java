package CrudBank;

import javax.swing.JOptionPane;

public class Menu {
	ContaBancaria contaBancaria = new ContaBancaria();
	int Opcao = 0;
    
    public void gerenciarMenu(){
        String opcao = "";
        while (! opcao.equalsIgnoreCase("6")){
            apresentarMenu();
        }
    }
    
    public void apresentarMenu(){
    	try {
    		String Menuzin = JOptionPane.showInputDialog("1 - informações Basicas" + "\n2 - saque" +
                    "\n3 - deposito" + "\n4 - pagar conta" + "\n5 - gerar extrato" + "\n6 - encerrar cessao");
            Opcao = Integer.valueOf(Menuzin);
            VerificaOpcao(Opcao);
            coordenarMenu(Opcao);
    		
    	}catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "Opaco invalida");
    	}
    	
        
    }
    public boolean VerificaOpcao(int op) {
    		if (op > 6 || op < 1) {
        		JOptionPane.showMessageDialog(null, "Opcao Invalida");
        		return true;
        	}else {
        		return false;
        	}
    		
		}
    	
    public void coordenarMenu (int opc){
        switch (opc){
                case 1: 
                    contaBancaria.informacoesBasicas();
                   break;
                case 2:
                	String valorTexto = JOptionPane.showInputDialog("valor do saque: R$");
                    valorTexto = valorTexto.replace(',', '.');
                    double saque = Double.valueOf(valorTexto);
                    contaBancaria.sacar(saque);
                    JOptionPane.showMessageDialog(null, "Saldo da conta: R$" + contaBancaria.saldo
                            + "\n");
                   break;
                case 3:
                	try {
                		String valor = JOptionPane.showInputDialog("valor do deposito: R$");
                        valor = valor.replace(',', '.');
                        double deposito = Double.parseDouble(valor);
                        contaBancaria.depositar(deposito);
                	}catch(NumberFormatException e) {
                		JOptionPane.showMessageDialog(null, "O campo não aceita letras!");
                		return;
                	}
                	
                    JOptionPane.showMessageDialog(null, "deposito feito com sucesso: "
                    + "\nvalor do saldo: R$" + contaBancaria.saldo +"\n");
                   break;
                case 4:
                	String pagando = JOptionPane.showInputDialog("nome da conta: ");
                	double Valorconta = Double.valueOf(JOptionPane.showInputDialog("valor da conta: ").replace(',', '.'));
             
                boolean possivelPagar = contaBancaria.pagarConta(pagando, Valorconta);
                if (possivelPagar){
                JOptionPane.showMessageDialog(null, "pagamento realizado com sucesso");
            
                }else{
                	JOptionPane.showMessageDialog(null,"saldo insuficiente");
                }
                   break;
                case 5:
                contaBancaria.extrato();
                  break;
                
        }

    }
   
}

