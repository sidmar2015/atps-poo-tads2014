package tads_atps_poo;

public class QuartoComum extends Quarto{
	private boolean banheira;

	public QuartoComum(int numQuarto, int camaExtra) {
		super(numQuarto, camaExtra);
		// TODO Auto-generated constructor stub
	}
    
	public boolean isBanheira() {
		return banheira;
	}

	public void setBanheira(boolean banheira) {
		this.banheira = banheira;
	}

}
