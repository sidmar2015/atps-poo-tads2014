package main;

import tads_atps_poo.*;

import java.util.Collection;

import javax.swing.*;

import java.util.Scanner;
import java.lang.NullPointerException;
import java.lang.InterruptedException;

public class Main {
	static Quarto[] acomodacao = new Quarto[60];
	public static void main(String[] args) throws InterruptedException{
			
		/* Instancia dos 60 quartos*/
			for(int i=0;i<60;i++){
			acomodacao[i] = new Quarto(i,0);
			if(i <= 50)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().COMUM); // De 1 - 50 quartos comuns
			if(i >= 60)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().CHALE); // De 51 - 60 chales
		} // Fim do laço for
		menu();
	} // Fim do main
	
	
		
				
		              /* METODO MENU*/
		public static void menu() throws InterruptedException{
			Scanner s = new Scanner(System.in);
			System.out.println("\t\t----- MENU PRINCIPAL -----");
			System.out.println("<1> CHECK IN  <2> CHECK OUT  <3> SAIR");
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
				Thread.sleep(2000);
				s.close();
				return;
				
			}
			s.close();
		}
		
		      /*METODO DE CHECK IN*/
		public static void registrarEntrada(){
			Scanner s = new Scanner(System.in);
			System.out.println("Digite o numero do quarto");
			int nQuarto = s.nextInt();
			    /* testa se o quarto esta vazio*/
				if(acomodacao[nQuarto].isOcupado() == true){
					System.out.println("O quarto "+ nQuarto +" Esta ocupado");
					s.close();
					return ;
					} // fim if
				else{
					System.out.println("Digite o nome do hospede");
					String nome = s.next();
					acomodacao[nQuarto].hospede.setNome(nome);
					System.out.println("Digite o numero de documento do hospede");
					String nDoc = s.next();
					acomodacao[nQuarto].hospede.setNumDocumento(nDoc);
					System.out.println("Digite a data de entada dd/mm/aaaa");
					acomodacao[nQuarto].hospede.setDataEntrada(s.next());
					s.close();
				} // fim else
		} // fim metodo
		
		     /*METODO DE CHECK OUT*/
		public static void registrarSaida(){
			Scanner s = new Scanner(System.in);
			int nQuarto;
			System.out.println("Digite o numero do quarto");
			nQuarto = s.nextInt();
			if(acomodacao[nQuarto].isOcupado() == false){
				System.out.println("O quarto "+ nQuarto +" Esta vazio");
				s.close();
			} // fim if
			else{
				System.out.println("Deseja fechar a conta do quarto "+nQuarto+"? <1> SIM <2> NAO");
				int opcao = s.nextInt();
				s.close();
				
				switch(opcao){
				case 1:
					// captura o total de diarias devidas
					int tDiarias = acomodacao[nQuarto].diaria.calculaDiarias(acomodacao[nQuarto].hospede.getDataEntrada(),
							acomodacao[nQuarto].hospede.getDataSaida());
					// efetua os calculos e imprime as informações na tela
					System.out.println("Tempo de permanencia do Sr(a) "+acomodacao[nQuarto].hospede.getNome()+"\n"
							+tDiarias+" dias, data de entrada "+acomodacao[nQuarto].hospede.getDataEntrada()+
							" data de saida "+acomodacao[nQuarto].hospede.getDataSaida()+
							"\n Total a pagar: "+(tDiarias*acomodacao[nQuarto].getPrecoDiaria()));
					break;
				case 2:
					return;
				default:
					return;
				}// fim switch
			}// fim else
		}// fim metodo
		
	

}
