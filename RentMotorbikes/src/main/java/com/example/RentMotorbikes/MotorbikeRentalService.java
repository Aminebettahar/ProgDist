package com.example.RentMotorbikes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import com.example.RentMotorbikes.Motorbike;

@RestController
public class MotorbikeRentalService {

    private List<Motorbike> motorbikes = new ArrayList<Motorbike>();
	
	public MotorbikeRentalService() {
		motorbikes.add(new Motorbike("11AA22", "Yamaha", 1000));
		motorbikes.add(new Motorbike("33BB44", "Honda", 2222));
	}
	
	@GetMapping("/motorbikes")
	public List<Motorbike> getListOfMotorbikes(){
		return motorbikes;
	}
	
	@PostMapping("/motorbikes")
	public void addCar(@RequestBody Motorbike motorbike) throws Exception{
		System.out.println(motorbike);
		motorbikes.add(motorbike);
	}

	@GetMapping("/motorbikes/{plateNumber}")
	public Motorbike getMotorbike(@PathVariable(value = "plateNumber") String plateNumber){
		for(Motorbike motorbike : motorbikes){
			if(motorbike.getPlateNumber().equals(plateNumber)){
				return motorbike;
			}
		}
		return null;
	}

	@PutMapping(value = "/motorbikes/{plateNumber}")
	public void rent(@PathVariable("plateNumber") String plaque,
					 @RequestParam(value="rent", required = true)boolean rented,
					 @RequestBody(required = false) Dates dates){
		System.out.println(plaque);
		System.out.println(rented);
		System.out.println(dates);
		// parcourir le tablea à la recherche d'une voiture de plaque plaque
		// si voiture trouvé
		//		si rented = true => louer
		//		sinon ramener
		// si voiture non trouvé
		// 	envoyer HttsStattus NOT-FOUND
		for (Motorbike motorbike : motorbikes) {
			if (motorbike.getPlateNumber().equals(plaque)) {
				// Voiture trouvée
				if (rented) {
					// Louer la voiture en définissant son statut de location sur true
					motorbike.setRented(true);
					// Si des dates sont spécifiées, vous pouvez les traiter ici
					if (dates != null) {
						// Faire quelque chose avec les dates
						motorbike.setHistorique(dates);
					}
					return; // Sortir de la méthode après la location
				} else {
					// Ramener la voiture en définissant son statut de location sur false
					motorbike.setRented(false);
					return; // Sortir de la méthode après le retour
				}
			}
		}
		if(rented == false){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
		}
	}
    
}
