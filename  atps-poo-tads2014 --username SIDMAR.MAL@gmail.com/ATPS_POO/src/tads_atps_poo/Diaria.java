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
	
	public Diaria(){
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.tempoMS = tempoMS;
		this.tempoSeg = tempoSeg;
		this.tempoMin = tempoMin;
		this.tempoHoras = tempoHoras;
	}
	
	public int calculaDiarias(String entrada, String saida){
		try{
			dataEntrada = data.parse(entrada);  // recebe a data da entrada do hospede
			dataSaida   = data.parse(saida);    // recebe a data de saida do hospede
		}catch(java.text.ParseException e){     // lança uma exceção caso não seja possivel converter a data
			return 0;
			}
		tempoMS    = dataSaida.getTime() - dataEntrada.getTime();  // efetua o calculo do tempo de hospedagem em milisegundos
		tempoSeg   = tempoMS/1000;                                 // efetua o calculo do tempo de hospedagem em segundos
		tempoMin   = tempoSeg/60;                                  // efetua o calculo do tempo de hospedagem em minutos
		tempoHoras = tempoMin/60;                                  // efetua o calculo do tempo de hospedagem em horas 
		diarias    = (int) tempoHoras/24;                          // efetua o calculo do tempo de hospedagem em dias
		
		if(diarias == 0)     /* não existe diaria 0, mesmo que o hospede permaneça */
		return diarias + 1;  /* menos de 24h, ele paga uma diaria completa*/
		else
		return diarias;	
		}
	
}
