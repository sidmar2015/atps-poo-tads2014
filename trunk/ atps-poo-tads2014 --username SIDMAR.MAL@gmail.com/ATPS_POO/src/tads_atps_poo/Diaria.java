package tads_atps_poo;
import java.util.*;
import java.text.SimpleDateFormat;

public class Diaria {
	
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");//expecifica o formato da data
	Date dataEntrada = null;
	Date dataSaida   = null;
	long tempoMS;
	long tempoSeg;
	long tempoMin;
	long tempoHoras;
	int  diarias;
	
	Diaria(){
		
			}
	public int calculaDiarias(String entrada, String saida){
		try{
			dataEntrada = data.parse(entrada);//recebe a data da entrada do hospede
			dataSaida   = data.parse(saida);
		}catch(java.text.ParseException e){
			return 0;
			}
		tempoMS    = dataSaida.getTime() - dataEntrada.getTime();
		tempoSeg   = tempoMS/1000;
		tempoMin   = tempoSeg/60;
		tempoHoras = tempoMin/60;
		diarias    = (int) tempoHoras/24;
		
		return diarias;		
		}
	
}
