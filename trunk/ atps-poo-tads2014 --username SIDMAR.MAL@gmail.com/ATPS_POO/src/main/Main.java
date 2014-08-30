package main;

import tads_atps_poo.*;
import java.util.Collection;
import javax.swing.*;

public class Main {
	public static void main(String[] args){
		Quarto[] acomodacao = new Quarto[60]; 
		for(int i=0;i<60;i++){
			acomodacao[i] = new Quarto(null,i,0);
			if(i <= 50)
				acomodacao[i].setTipoQuarto(COMUM);
			if(i >= 60)
				acomodacao[i].setTipoQuarto(CHALE);
		}
		
	}

}
