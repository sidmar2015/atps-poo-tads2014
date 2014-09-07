package tads_atps_poo;

public class Hospede {
	
	private  String nome;
	private  String numDocumento;
	private  String dataEntrada;
	private  String dataSaida;
	private  String horaEntrada;
	private  String horaSaida;
		// Contrutor da classe
		public Hospede(){
			String nome = this.nome;
			String numdocumento = this.numDocumento;
			String dataEntrada = this.dataEntrada;
			String dataSaida = this.dataSaida;
			String horaEntrada = this.horaEntrada;
			String horaSaida = this.horaSaida;
		}
		
	// Encapsulamento	
	public  String getNome() {
		return nome;
	}
	public  void setNome(String nome) {
		this.nome = nome;
	}
	public  String getNumDocumento() {
		return numDocumento;
	}
	public  void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	public  String getDataEntrada() {
		return dataEntrada;
	}
	public  void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public  String getDataSaida() {
		return dataSaida;
	}
	public  void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public  String getHoraEntrada() {
		return horaEntrada;
	}
	public  void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public  String getHoraSaida() {
		return horaSaida;
	}
	public void  setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

}
