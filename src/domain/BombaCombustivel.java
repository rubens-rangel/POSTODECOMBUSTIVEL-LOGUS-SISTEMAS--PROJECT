package domain;

public class BombaCombustivel {
    private String tipo;
    private int velocidade;
    private int totalLitrosAbastecidos;

    public BombaCombustivel(String tipo, int velocidade) {
        this.tipo = tipo;
        this.velocidade = velocidade;
    }

    public String getTipo() {
        return tipo;
    }


    public int abastecer(double litros) {
        int tempoAbastecimento = (int) Math.ceil(litros / velocidade) * 60;
        totalLitrosAbastecidos += litros;
        return tempoAbastecimento;
    }

    public int getTotalLitrosAbastecidos() {
        return totalLitrosAbastecidos;
    }

    public String getResumo() {
        return String.format("Total abastecido na bomba de %s: %d litros", tipo, totalLitrosAbastecidos);
    }
}