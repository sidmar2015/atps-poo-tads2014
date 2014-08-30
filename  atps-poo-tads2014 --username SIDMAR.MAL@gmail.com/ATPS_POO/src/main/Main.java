package main;

import tads_atps_poo.*;

import java.util.Collection;

import javax.swing.*;

public class Main {
	public static void main(String[] args){
		/* Instancia dos 60 quartos*/
		Quarto[] acomodacao = new Quarto[60]; 
		for(int i=0;i<60;i++){
			acomodacao[i] = new Quarto(null,i,0);
			if(i <= 50)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().COMUM); // De 1 - 50 quartos comuns
			if(i >= 60)
				acomodacao[i].setTipoQuarto(acomodacao[i].getTipoQuarto().CHALE); // De 51 - 60 chales
		}
		System.out.println(acomodacao[1].numQuarto +"\n"
		+ acomodacao[1].nomeHospede +"\n"+ acomodacao[1].getTipoQuarto());
	}

}
