package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Modelo;
import domain.Veiculo;

public class LeituraCSV {
	
	
	static List<Modelo> lerModelos() {		
		List<Modelo> modelos = new ArrayList<>();
		
		try {
			BufferedReader csvFileModelos = new BufferedReader(new FileReader("src/ressources/modelos.csv"));
			String linhas;
			int numeroLinhas = 0;
			
			if ((linhas = csvFileModelos.readLine()) != null) {
				numeroLinhas++;
			}							
			
						while((linhas = csvFileModelos.readLine()) != null) {
							  String[] partes = linhas.split(";");
					            String nome = partes[0];
					            String etanolStr = partes[1].trim();
					            String gasolinaStr = partes[2].trim();					      
					            Double consumoEtanol = (etanolStr.isEmpty()) ? 0 : Double.parseDouble(etanolStr.replace(",", "."));
					            Double consumoGasolina = (gasolinaStr.isEmpty()) ? 0 : Double.parseDouble(gasolinaStr.replace(",", "."));
					            int capacidadeTanque = Integer.parseInt(partes[3]);
//					            System.out.println(" " +nome +" " + consumoEtanol+ " " + consumoGasolina+ " " + capacidadeTanque);

						        Modelo model = new Modelo(nome, consumoEtanol, consumoGasolina, capacidadeTanque);
							 modelos.add(model);
						}
						csvFileModelos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		return modelos;
		
	}
	

    public static List<Veiculo> lerVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        List<Modelo> modelos = lerModelos();
        try (BufferedReader csvFileVeiculos = new BufferedReader(new FileReader("src/ressources/veiculos.csv"))) {
            String linha;
            while ((linha = csvFileVeiculos.readLine()) != null) {
                String[] dados = linha.split(";");
                String modeloString = dados[0];
                String placa = dados[1];
               
                // Procurar o modelo na lista de modelos
                Modelo modelo = null;
               
                for (Modelo m : modelos) {
                    if (m.getNome().equals(modeloString)) {
                        modelo = m;
                        Veiculo veiculo = new Veiculo(modelo, placa);
                        veiculos.add(veiculo);     
                        break;
                    }
                }                            
       
                
            } 
            csvFileVeiculos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        return veiculos;
    }
}
