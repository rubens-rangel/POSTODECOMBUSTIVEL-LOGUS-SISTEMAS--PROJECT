package domain;

public class Modelo{


	private String nome;
    private double consumoEtanol; 
    private double consumoGasolina; 
    private int capacidadeTanque; 

    public Modelo() {
    }

    public Modelo(String nome, double consumoEtanol, double consumoGasolina, int capacidadeTanque) {
        this.nome = nome;
        this.consumoEtanol = consumoEtanol;
        this.consumoGasolina = consumoGasolina;
        this.capacidadeTanque = capacidadeTanque;
    }

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getConsumoEtanol() {
        return consumoEtanol;
    }

    public void setConsumoEtanol(double consumoEtanol) {
        this.consumoEtanol = consumoEtanol;
    }

    public double getConsumoGasolina() {
        return consumoGasolina;
    }

    public void setConsumoGasolina(double consumoGasolina) {
        this.consumoGasolina = consumoGasolina;
    }

    public int getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(int capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public double calcularAutonomiaEtanol() {
        return consumoEtanol * capacidadeTanque;
    }

    public double calcularAutonomiaGasolina() {
        return consumoGasolina * capacidadeTanque;
    }
}