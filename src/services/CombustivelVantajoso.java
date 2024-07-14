package services;

import domain.Veiculo;

public class CombustivelVantajoso {
	
	private static final Double precoEtanol = 2.27;
	private static final Double precoGasolina = 2.90;

	public static String calcularCombustivelVantajoso(Veiculo veiculo) {
	    double capacidadeTanque = veiculo.getModelo().getCapacidadeTanque();
	    double consumoEtanol = veiculo.getModelo().getConsumoEtanol();
	    double consumoGasolina = veiculo.getModelo().getConsumoGasolina();
	    
	    // Verificar se os consumos de combustível são maiores que zero para evitar divisões por zero

	        double custoTotalEtanol = (capacidadeTanque / consumoEtanol) * precoEtanol;
	        double custoTotalGasolina = (capacidadeTanque / consumoGasolina) * precoGasolina;

	        if (custoTotalEtanol > custoTotalGasolina) {
	            return "ETANOL";
	        } else {
	            return "GASOLINA";
	        }
	}
}