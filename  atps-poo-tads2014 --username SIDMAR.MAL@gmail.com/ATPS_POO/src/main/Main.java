package main;

import tads_atps_poo.*;
import java.util.Collection;
import javax.swing.*;
import java.util.Scanner;
import java.lang.InterruptedException;

public class Main {
	static Quarto[] acomodacao = new Quarto[60];
	public static void main(String[] args) throws InterruptedException{
			
		/* Instancia dos 60 quartos*/
			for(int i=0;i<60;i++){
			acomodacao[i] = new Quarto(i,0);
			if(i <= 50)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().COMUM); // De 1 - 50 quartos comuns
			acomodacao[i].setPrecoDiarias(105.00f); // pre�o da diaria
			if(i >= 60)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().CHALE); // De 51 - 60 chales
			    acomodacao[i].setPrecoDiarias(115.00f); // pre�o da diaria
		} // Fim do la�o for
			
				menu();
			
	} // Fim do main
	
	
		
				
		              /* METODO MENU*/
		public static void menu(){
			JFrame janela = new JFrame();
			JButton btn_1 = new JButton();
			JButton btn_2 = new JButton();
			
			Scanner s = new Scanner(System.in);
			System.out.println("\t\t----- MENU PRINCIPAL -----\n\n");
			System.out.println("\t  <1> CHECK IN  <2> CHECK OUT  <3> SAIR");
			int opcao = s.nextInt();
			switch(opcao){
			case 1:
				registrarEntrada();
				break;
			case 2:
				registrarSaida();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("COMANDO NAO RECONHECIDO");
				//sleep(2000);
				s.close();
				return;
				
			}
			
		}
		
		      /*METODO DE CHECK IN*/
		public static void registrarEntrada(){
			
			String num = JOptionPane.showInputDialog("Digite o numero do quarto");
			Integer nQuarto = Integer.parseInt(num);
			    /* testa se o quarto esta vazio*/
				if(acomodacao[nQuarto].isOcupado() == true){
					//System.out.println("O quarto "+ nQuarto +" Esta ocupado");
					JOptionPane.showMessageDialog(null, "O quarto "+ nQuarto +" Esta ocupado");
					} // fim if
					else{
					String nome = JOptionPane.showInputDialog("Digite o nome do hospede");
					acomodacao[nQuarto].hospede.setNome(nome);
					
					String nDoc = JOptionPane.showInputDialog("Digite o numero de documento do hospede");
					acomodacao[nQuarto].hospede.setNumDocumento(nDoc);
					
					String data = JOptionPane.showInputDialog("Digite a data de entada dd/mm/aaaa");
					acomodacao[nQuarto].hospede.setDataEntrada(data);
					acomodacao[nQuarto].setOcupado(true); // registra a ocupa��o do quarto
					} // fim else
				menu();
		} // fim metodo
		
		     /*METODO DE CHECK OUT*/
		public static void registrarSaida(){
			String quarto;
			quarto = JOptionPane.showInputDialog("Digite o numero do quarto");
			Integer nQuarto = new Integer(quarto);
			nQuarto.parseInt(quarto);// converte a string para inteiro
			if(acomodacao[nQuarto].isOcupado() == false){
				System.out.println("O quarto "+ nQuarto +" Esta vazio");
				
				
					menu();
				
			} // fim if
			else{
				//System.out.println("Deseja fechar a conta do quarto "+nQuarto+"? <1> SIM <2> NAO");
				Object[] options = { "OK", "CANCELAR" };
			      JOptionPane.showOptionDialog(null, "Clique OK para continuar", "Deseja fechar a conta do quarto "+nQuarto+"?",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, options, options[0]);
				
					//System.out.println("Digite a data de saida dd/mm/aaaa");
					String saida = JOptionPane.showInputDialog("Digite a data de saida dd/mm/aaaa");
					// captura o total de diarias devidas
					int tDiarias = acomodacao[nQuarto].diaria.calculaDiarias(acomodacao[nQuarto].hospede.getDataEntrada(),
							saida);
					// efetua os calculos e imprime as informa��es na tela
					JOptionPane.showMessageDialog(null,"Tempo de permanencia do Sr(a) "+acomodacao[nQuarto].hospede.getNome()+"\n"
							+tDiarias+" dias, data de entrada "+acomodacao[nQuarto].hospede.getDataEntrada()+
							" data de saida "+saida+
							"\n Total a pagar: "+(tDiarias*acomodacao[nQuarto].getPrecoDiaria()+" R$"));
					
					menu();
				
			}// fim else
		}// fim metodo
		
	

}
