package com.quaters.enigma;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class enigma {
	public static void main(String[] args) {
		var mammals = List.of("Aardvark", "Armadillo", "AyeAye", "Baboon", "Beaver", "Bobcat", "Caribou", "Cheetah",
				"Chimpanzee", "Chipmunk", "Cougar", "Coyote", "Dingo", "Dugong", "Fossa", "Gelada", "Gibbon", "Giraffe",
				"Groundhog", "Hare", "Hedgehog", "Hippopotamus", "Horse", "Impala", "Jaguar", "Kinkajou", "Koala",
				"Leopard", "Llama", "Lynx", "Manatee", "Mandrill", "Meerkat", "Mongoose", "Narwhal", "Nutria", "Ocelot",
				"Opossum", "Orangutan", "Platypus", "Porcupine", "Pronghorn", "Raccoon", "Sifaka", "Skunk", "Squirrel",
				"Tapir", "Wallaby", "Walrus", "Warthog", "Wildebeest", "Wolf", "Wolverine", "Zebra");
		var cities = List.of("Bangkok", "London", "Paris", "Dubai", "NewYork", "Singapore", "KualaLumpur", "Istanbul",
				"Tokyo", "Seoul", "HongKong", "Barcelona", "Amsterdam", "Milan", "Taipei", "Rome", "Osaka", "Vienna",
				"Shanghai", "Prague", "LosAngeles", "Madrid", "Munich", "Miami", "Dublin");
		var specials = List.of("@", "%", "+", "!", "#", "$", "^", "?", ":", "-", "_", ".");
		Random random = new Random();
		Calendar c = Calendar.getInstance();
		String[] password = new String[6];
		for (int i = 0; i < 1000; i++) {
			password[0] = UUID.randomUUID().toString().substring(0, 4);
			password[1] = Integer.toString(random.nextInt(100));
			password[2] = mammals.get(random.nextInt(mammals.size()));
			password[3] = cities.get(random.nextInt(cities.size()));
			password[4] = specials.get(random.nextInt(specials.size()));
			password[5] = specials.get(random.nextInt(specials.size()));
			for (int s = 0; s < password.length; s++) {
				int r = random.nextInt(password.length);
				String tmp = password[s];
				password[s] = password[r];
				password[r] = tmp;
			}
			c.add(Calendar.DATE, 1);
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())+"\t"+password[0] + password[1] + password[2] + password[3] + password[4] + password[5]);
		}
	}
}
