package services;

import java.util.ArrayList;
import java.util.List;

import domain.BombaCombustivel;
import domain.Veiculo;

public class Abastecimento {
	
    public static List<String> simularAbastecimento(List<Veiculo> veiculos,BombaCombustivel bombaGasolina,BombaCombustivel bombaEtanol) {
        List<String> eventos = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
      String tipoCombustivel = CombustivelVantajoso.calcularCombustivelVantajoso(veiculo);		
        	BombaCombustivel bomba = tipoCombustivel.equals("ETANOL") ? bombaEtanol : bombaGasolina;
           
//        	bombasList.contains(tipoCombustivel);
//        	
//        	BombaCombustivel bomba =
//        	for (BombaCombustivel tipo: bombasList) {
//        	    if (tipo.getTipo().equals(tipoCombustivel)) {
//        	        tipo = bomba;
//        	        break;
//        	    }
//        	}
        	
        	
        	
        	
            if (bomba != null) {
                eventos.add(abastecerVeiculo(veiculo, bomba));
            }
        }
        return eventos;
    }
    
    private static String abastecerVeiculo(Veiculo veiculo, BombaCombustivel bomba) {
    	double litrosAbastecidos = veiculo.getModelo().getCapacidadeTanque();
        int tempoAbastecimento = bomba.abastecer(litrosAbastecidos);
        return String.format("[%02d:%02d] Veículo modelo %s, placa %s foi abastecido com %.2f litros de %s.",
                tempoAbastecimento / 60, tempoAbastecimento % 60, veiculo.getModelo().getNome(), veiculo.getPlaca(),
                litrosAbastecidos, bomba.getTipo());
    }
}

