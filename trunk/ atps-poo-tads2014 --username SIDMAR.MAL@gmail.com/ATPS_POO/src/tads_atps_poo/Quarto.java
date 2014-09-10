package tads_atps_poo;

public class Quarto {
	
	public enum TipoQuarto {COMUM,CHALE};
	public  TipoQuarto tipoQuarto;
	private  int numQuarto;
	private  boolean ocupado;
	private  float precoDiaria;
	private  int diarias;
	private  int camaExtra;
	/* Objeto do tipo Hospede, a classe Quarto tem um
	 * relacionamento do tipo TEM-UM com a classe Hospede*/ 
	public Hospede hospede = new Hospede();
	/* Objeto do tipo Diaria, a classe Quarto tem um
	 * relacionamento do tipo TEM-UM com a classe Diaria*/ 
	public Diaria  diaria = new Diaria();
	
	
	        // Construtor da classe, inicializa os atributos
			public Quarto(int numQuarto, int camaExtra)
			{
				this.numQuarto = numQuarto;
				this.camaExtra = camaExtra;
				this.tipoQuarto = tipoQuarto;
				}
			
			// Métodos que retornam variáveis encapsuladas da classe
			public  float getPrecoDiaria(){
				return precoDiaria;
			}
			public  void setPrecoDiarias(float precoDiaria){
				this.precoDiaria = precoDiaria;
			}
			
			public boolean isOcupado(){
				return ocupado;
			}
			public  void setOcupado(boolean ocupado){
				this.ocupado = ocupado;
			}
			
			public  TipoQuarto getTipoQuarto(){
				return tipoQuarto;
			}
			public  void setTipoQuarto(TipoQuarto tipoQuarto){
				this.tipoQuarto = tipoQuarto;
			}
			
			// Métodos da classe, testa se o quarto esta vazio
			public  void quartoVazio(){
				if(isOcupado() != true)
					setOcupado(false);
				else
					setOcupado(true);
			}
}
