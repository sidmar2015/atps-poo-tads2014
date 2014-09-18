
/* PROGRAMA PARA CÁLCULO DE DIÁRIAS DE UMA POUSADA
 * CRIADO POR SIDMAR PORFIRIO RA 7989711257 ALUNO DO 3º SEMESTRE
 * DO CURSO DE TADS DA FACULDADE ANHANGUERA DE CAMPINAS
 * UNIDADE 1, PARA A ATIVIDADE PRATICA SUPERVISIONADA
 * DA DISCIPLINA DE PROGRAMAÇÃO ORIENTADA A OBJETOS
 */


package main;

import tads_atps_poo.*;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.*;
import java.util.Scanner;




public class Main {
	
	public static Quarto[] quartos = new Quarto[61];
			
	public static void main(String[] args){
		
		/* Instancia dos 60 quartos*/
			for(int i=1;i<61;i++){
				quartos[i] = new Quarto(i,0);
			if(i <= 25)
				quartos[i].setTipoQuarto(quartos[i].getTipoQuarto().COMUM); // De 1 - 25 quartos comuns
			quartos[i].setBanheira(false);
			if(i <= 50)
				quartos[i].setTipoQuarto(quartos[i].getTipoQuarto().COMUM); // De 26 - 50 quartos com banheira
			quartos[i].setBanheira(true);
			if(i >= 60)
				quartos[i].setTipoQuarto(quartos[i].getTipoQuarto().CHALE); // De 51 - 60 chales
			quartos[i].setBanheira(false);
		} // Fim do laço for
		
			
				menu();
			
	} // Fim do main
	
	
		
				
		              /* METODO MENU*/
		public static void menu(){
			   
	        			
			Scanner s = new Scanner(System.in);
			System.out.println("\t\t----- MENU PRINCIPAL -----\n\n");
			System.out.println("\t  <0> SAIR <1> CHECK IN  <2> CHECK OUT  <3> ATUALIZAR DIARIA");
			int opcao = s.nextInt();
			switch(opcao){
			case 1:
				registrarEntrada();
				break;
			case 2:
				registrarSaida();
				break;
			case 3:
				atualizarValor();
			case 0:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null,"COMANDO NAO RECONHECIDO");
				s.close();
				menu();
				
			}
			
		}
		
		     

  
		/*METODO DE CHECK IN*/
		public static void registrarEntrada(){
			String escolha = JOptionPane.showInputDialog("Deseja um quarto ou chale ?");
			if((escolha != "quarto")||(escolha != "QUARTO")||(escolha != "Quarto")||(escolha != "q")||(escolha != "Q")){
				String num = JOptionPane.showInputDialog("Digite o numero do quarto");
				Integer nQto = Integer.parseInt(num);
				quartos[nQto].setNumQuarto(nQto);
				if(quartos[nQto].isOcupado()){
					JOptionPane.showMessageDialog(null, "O quarto "+ nQto +" Esta ocupado");
					menu();
				}//fim if interno
				else{
					/* Obtem os dados do hospede*/
					String nome = JOptionPane.showInputDialog("Digite o nome do hospede");
					quartos[nQto].hospede.setNome(nome);
					String nDoc = JOptionPane.showInputDialog("Digite o numero de documento do hospede");
					quartos[nQto].hospede.setNumDocumento(nDoc);
					String data = JOptionPane.showInputDialog("Digite a data de entada dd/mm/aaaa");
					quartos[nQto].hospede.setDataEntrada(data);
					/* Verifica a solicitação de banheira*/
					Object[] options = { "SIM", "NÃO" };
					int i = JOptionPane.showOptionDialog(null, 
							"Deseja Banheira ?", "Banheira", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
							options, options[0]);
					if (i == JOptionPane.YES_OPTION) { 
						quartos[nQto].setBanheira(true); 
						}
					
					quartos[nQto].setOcupado(true);
					menu();
				}//fim else interno
			  }//fim if externo
			else if((escolha != "chale")||(escolha != "CHALE")||(escolha != "Chale")||(escolha != "c")||(escolha != "C")){
				String num = JOptionPane.showInputDialog("Digite o numero do quarto");
				Integer nQto = Integer.parseInt(num);
				quartos[nQto].setNumQuarto(nQto);
				if(quartos[nQto].isOcupado()){
					JOptionPane.showMessageDialog(null, "O quarto "+ nQto +" Esta ocupado");
					menu();
				}//fim if interno
				else{
					/* Obtem os dados do hospede*/
					String nome = JOptionPane.showInputDialog("Digite o nome do hospede");
					quartos[nQto].hospede.setNome(nome);
					String nDoc = JOptionPane.showInputDialog("Digite o numero de documento do hospede");
					quartos[nQto].hospede.setNumDocumento(nDoc);
					String data = JOptionPane.showInputDialog("Digite a data de entada dd/mm/aaaa");
					quartos[nQto].hospede.setDataEntrada(data);
					Integer camas = new Integer(JOptionPane.showInputDialog("Quantas camas extras ?"));
					quartos[nQto].setCamaExtra(camas);
					quartos[nQto].setOcupado(true);
					menu();
				}//fim else interno
			}
			  else{
				  /* caso não reconheça a opção*/
				  JOptionPane.showMessageDialog(null, "Opcao Nao Reconhecida !");
				  menu();
			  }//fim else externo
			menu();
			}//fim método
			
			    
		
		     /*METODO DE CHECK OUT*/
		public static void registrarSaida(){
			Integer nQto = new Integer(JOptionPane.showInputDialog("Digite o numero do quarto"));
			if(quartos[nQto].isOcupado() == false){
				JOptionPane.showMessageDialog(null,"O quarto "+ nQto +" Esta vazio");
					menu();
			} // fim if
			else{
				Object[] options = { "OK", "CANCELAR" };
			      JOptionPane.showOptionDialog(null, "Clique OK para continuar", "Deseja fechar a conta do quarto "+nQto+" ?",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			      
			      	/* lê a data de saida e calcula quandos dias o hospede permaneceu hospedado*/
					String saida = JOptionPane.showInputDialog("Digite a data de saida dd/mm/aaaa");
					int tDiarias = quartos[nQto].diaria.calculaDiarias(quartos[nQto].hospede.getDataEntrada(),saida);
					
					/* efetua os calculos e imprime as informações na tela */
					JOptionPane.showMessageDialog(null,"Tempo de permanencia do Sr(a) "+quartos[nQto].hospede.getNome()+"\n"
							+tDiarias+" dias, data de entrada "+quartos[nQto].hospede.getDataEntrada()+
							" data de saida "+saida+
							"\n Total a pagar: "+(tDiarias*quartos[nQto].getPrecoDiaria()*quartos[nQto].extras(quartos[nQto].getCamaExtra(),
									quartos[nQto].isBanheira(), quartos[nQto].getTipoQuarto())+" R$"));
					
					menu();
				
			}// fim else
		}// fim metodo
		
		/* Atualiza o valor da diarias*/
		public static void atualizarValor(){
			Float valor = new Float(JOptionPane.showInputDialog("Digite o novo valor da diaria"));
				for(int i=1;i<61;i++){
					quartos[i].setPrecoDiarias(valor);
					menu();
				}
		}
	

}
