
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
import java.lang.InterruptedException;
import java.awt.ActiveEvent;
import java.awt.FlowLayout;


public class Main {
	public static Quarto[] acomodacao = new Quarto[60];
	public static ArrayList quartos = new ArrayList<QuartoComum>();
	public static ArrayList chales  = new ArrayList<Chale>();
	
	public static void main(String[] args) throws InterruptedException{
			
		/* Instancia dos 60 quartos*/
			/*for(int i=0;i<60;i++){
			quartos.add(i);
			quartos.
			if(i <= 25)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().COMUM); // De 1 - 50 quartos comuns
			acomodacao[i].setPrecoDiarias(105.00f); // preço da diaria
			if(i <= 50)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().COMUM); // De 1 - 50 quartos comuns
			acomodacao[i].setPrecoDiarias(105.00f); // preço da diaria
			if(i >= 60)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().CHALE); // De 51 - 60 chales
			    acomodacao[i].setPrecoDiarias(115.00f); // preço da diaria
		} // Fim do laço for*/
		
			
				menu();
			
	} // Fim do main
	
	
		
				
		              /* METODO MENU*/
		public static void menu(){
			/*
			JFrame janela = new JFrame("POUSADA SYS");
			JLabel rotulo = new JLabel("MENU PRINCIPAL");
			JButton btn_1 = new JButton("CHECK IN");
			JButton btn_2 = new JButton("CHECK OUT");
			JButton btn_3 = new JButton("ALTERAR DIARIA");
			JTextField jTxt = new JTextField();
			
			btn_1.setSize(50,100);
			btn_2.setSize(50,100);
			btn_3.setSize(50,150);
			
										
			janela.setLayout(new FlowLayout());
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        janela.setVisible(true);  
	        janela.setSize(400,400);
	        janela.add(rotulo);
	        janela.add(btn_1);
	        janela.add(btn_2);
	        janela.add(btn_3);
	        janela.add(jTxt);
	        jTxt.setText("");*/
	        
	        /* DAQUI PARA BAIXO FUNCIONA PERFEITAMENTE*/
			
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
				JOptionPane.showMessageDialog(null,"COMANDO NAO RECONHECIDO");
				menu();
				
			}
			
		}
		
		     

  
		/*METODO DE CHECK IN*/
		public static void registrarEntrada(){
			
			String num = JOptionPane.showInputDialog("Digite o numero do quarto");
			Integer nQuarto = Integer.parseInt(num);
			    /* testa se o quarto esta vazio*/
				if(acomodacao[nQuarto].isOcupado()){
					JOptionPane.showMessageDialog(null, "O quarto "+ nQuarto +" Esta ocupado");
					menu();
					} // fim if
					else{
					String nome = JOptionPane.showInputDialog("Digite o nome do hospede");
					acomodacao[nQuarto].hospede.setNome(nome);
					
					String nDoc = JOptionPane.showInputDialog("Digite o numero de documento do hospede");
					acomodacao[nQuarto].hospede.setNumDocumento(nDoc);
					
					String data = JOptionPane.showInputDialog("Digite a data de entada dd/mm/aaaa");
					acomodacao[nQuarto].hospede.setDataEntrada(data);
					acomodacao[nQuarto].setOcupado(true); // registra a ocupação do quarto
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
				JOptionPane.showMessageDialog(null,"O quarto "+ nQuarto +" Esta vazio");
				
				
					menu();
				
			} // fim if
			else{
				//System.out.println("Deseja fechar a conta do quarto "+nQuarto+"? <1> SIM <2> NAO");
				Object[] options = { "OK", "CANCELAR" };
			      JOptionPane.showOptionDialog(null, "Clique OK para continuar", "Deseja fechar a conta do quarto "+nQuarto+" ?",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, options, options[0]);
				
					//System.out.println("Digite a data de saida dd/mm/aaaa");
					String saida = JOptionPane.showInputDialog("Digite a data de saida dd/mm/aaaa");
					// captura o total de diarias devidas
					int tDiarias = acomodacao[nQuarto].diaria.calculaDiarias(acomodacao[nQuarto].hospede.getDataEntrada(),
							saida);
					// efetua os calculos e imprime as informações na tela
					JOptionPane.showMessageDialog(null,"Tempo de permanencia do Sr(a) "+acomodacao[nQuarto].hospede.getNome()+"\n"
							+tDiarias+" dias, data de entrada "+acomodacao[nQuarto].hospede.getDataEntrada()+
							" data de saida "+saida+
							"\n Total a pagar: "+(tDiarias*acomodacao[nQuarto].getPrecoDiaria()+" R$"));
					
					menu();
				
			}// fim else
		}// fim metodo
		
	
	

}
