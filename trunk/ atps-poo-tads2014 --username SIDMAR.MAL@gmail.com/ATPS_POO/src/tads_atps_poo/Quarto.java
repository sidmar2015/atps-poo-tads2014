package tads_atps_poo;

public class Quarto {
	
	public enum TipoQuarto {COMUM,CHALE};
	private TipoQuarto tipoQuarto;
	public int numQuarto;
	private boolean ocupado;
	private float precoDiaria;
	private int diarias;
	public String nomeHospede;
	private int camaExtra;
	
	        // Construtor da classe, inicializa os atributos
			public Quarto(String nomeHospede, int numQuarto, int camaExtra)
			{
				this.nomeHospede = nomeHospede;
				this.numQuarto = numQuarto;
				this.camaExtra = camaExtra;
				}
			
			// M�todos que retornam vari�veis encapsuladas da classe
			public float getPrecoDiaria(){
				return precoDiaria;
			}
			public void setPrecoDiarias(float precoDiaria){
				this.precoDiaria = precoDiaria;
			}
			
			public boolean isOcupado(){
				return ocupado;
			}
			public void setOcupado(boolean ocupado){
				this.ocupado = ocupado;
			}
			
			public TipoQuarto getTipoQuarto(){
				return tipoQuarto;
			}
			public void setTipoQuarto(TipoQuarto tipoQuarto){
				this.tipoQuarto = tipoQuarto;
			}
			
			// M�todos da classe
			public void quartoVazio(){
				if((nomeHospede == null)||(nomeHospede == ""))
					setOcupado(false);
				else
					setOcupado(true);
			}
}
