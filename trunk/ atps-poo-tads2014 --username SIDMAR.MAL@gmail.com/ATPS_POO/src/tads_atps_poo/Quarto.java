package tads_atps_poo;

public class Quarto {
	
	public enum TipoQuarto {COMUM,CHALE};
	public  TipoQuarto tipoQuarto;
	private  int numQuarto;
	private  boolean ocupado;
	private  boolean banheira;
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
				super();
				this.numQuarto = numQuarto;
				this.camaExtra = camaExtra;
				this.banheira  = banheira;
				this.ocupado   = ocupado;
				this.precoDiaria = precoDiaria;
				this.diarias   = diarias;
				
			}
			
			// Métodos que retornam variáveis encapsuladas da classe
			public boolean isBanheira() {
				return banheira;
			}

			public void setBanheira(boolean banheira) {
				this.banheira = banheira;
			}
			
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
			public int getNumQuarto() {
				return numQuarto;
			}

			public void setNumQuarto(int numQuarto) {
				this.numQuarto = numQuarto;
			}

			public int getCamaExtra() {
				return camaExtra;
			}

			public void setCamaExtra(int camaExtra) {
				this.camaExtra = camaExtra;
			}

			
			
						
			// Métodos da classe
			// Testa se o quarto esta vazio
			public  void quartoVazio(){
				if(isOcupado() != true)
					setOcupado(false);
				else
					setOcupado(true);
			}
			// Calcula despesas extras
			public float extras(int camaExtra,boolean banheira,TipoQuarto tipo){
				if(tipo == tipoQuarto.CHALE){
					return 1.2f*(camaExtra*1.1f);// se o tipo de acomodação for um chalé o custo é 20%
				}	                             // e se tiver cama extra soma-se mais 10% a diária
				
				if(banheira){
					return 1.18f; // se for um quarto com banheira soma-se 18% ao valor da diária
				}
				else{
					return 1;
				}
				
				
			}
}
