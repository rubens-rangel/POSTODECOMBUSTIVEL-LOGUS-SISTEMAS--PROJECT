package domain;

public class Veiculo {
    
	private	 Modelo modelo;
	private String placa;


    public Veiculo() {
	}
    
    public Veiculo(Modelo modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

	public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}