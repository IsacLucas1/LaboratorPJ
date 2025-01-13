package com.example.TemaLaborator9SDJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TemaLaborator9SdjpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(TemaLaborator9SdjpaApplication.class);
	@Autowired
	private MasinaSDJPArepository masinaSDJPArepository;

	public void adaugareMasina(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Numar de inmatriculare: ");
		String nrInmatriculare = scanner.nextLine();
		System.out.println("Marca: ");
		String marca = scanner.nextLine();
		System.out.println("Anul de fabricatiei: ");
		int anulFabricatiei = scanner.nextInt();
		System.out.println("Culoare: ");
		String culoare = scanner.next();
		System.out.println("Numar km: ");
		int nrKm = scanner.nextInt();

		Masina masina=new Masina(nrInmatriculare, marca, anulFabricatiei, culoare, nrKm);
		masinaSDJPArepository.save(masina);
		System.out.println("Masina adaugata");
		logger.info("Masina cu numarul de inmatriculare {} adaugata", nrInmatriculare);
	}

	public void stergereNrInmatriculare(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Numarul de inmatriculare: ");
		String nrInmatriculare = scanner.nextLine();
		masinaSDJPArepository.deleteById(nrInmatriculare);
		System.out.println("Masina cu numarul de inmatriculare: " + nrInmatriculare+" a fost stearsa");
		logger.info("Masina cu numarul de inmatriculare {} a fost stearsa", nrInmatriculare);
	}

	public void cautareNrInmatriculare(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Numar de inmatriculare: ");
		String nrInmatriculare = scanner.nextLine();
		List<Masina> masini = masinaSDJPArepository.findByNrInmatriculare(nrInmatriculare);
		if (masini.isEmpty()) {
			System.out.println("Nicio masina gasita cu acest numar de inmatriculare.");
			logger.info("Nicio masina gasita cu acest numar de inmatriculare.");
		} else {
			masini.forEach(System.out::println);
			masini.forEach(masina -> logger.info("Masina gasita: {}", masina));
		}
	}

	private void toateMasinile() {
		List<Masina> masini = masinaSDJPArepository.findAll();
		System.out.println("\nToate masinile:");
		masini.forEach(System.out::println);
		masini.forEach(masina -> logger.info("Masina: {}", masina));
	}

	public void masiniMarcaTastatura(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Marca: ");
		String marca = scanner.nextLine();
		List<Masina> masini = masinaSDJPArepository.findByMarca(marca);
		System.out.println("\nMasini cu marca " + marca + ":");
		masini.forEach(System.out::println);
		logger.info("\nMasina cu marca {}:", marca);
		masini.forEach(masina -> logger.info("{}", masina));
	}

	public void masiniSub100_000km(){
		List<Masina> masini = masinaSDJPArepository.findByNumarkmLessThan(100000);
		System.out.println("\nMasini sub 100 000km:");
		masini.forEach(System.out::println);
		masini.forEach(masina -> logger.info(" {}", masina));
	}

	public void masiniMaiNoi5Ani(){
		int anCurent = java.time.Year.now().getValue();
		List<Masina> masini = masinaSDJPArepository.findByAnulGreaterThan(anCurent - 5);
		System.out.println("\nMasini mai noi de 5 ani:");
		masini.forEach(System.out::println);
		masini.forEach(masina -> logger.info("Masina mai noua de 5 ani: {}", masina));
	}

	public static void main(String[] args) {
		SpringApplication.run(TemaLaborator9SdjpaApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{

		int opt;

		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("1) Adăugarea unei mașini în BD");
			System.out.println("2) Ștergerea unei mașini indicată prin numărul de înmatriculare");
			System.out.println("3) Căutarea unei mașini după numărul de înmatriculare ");
			System.out.println("4) Extragerea unei liste care conţine toate mașinile din baza de date ");
			System.out.println("5) Determinarea numărului de mașini din BD care au o anumită marcă, introdusă de la\n" +
					"tastatură");
			System.out.println("6) Determinarea numărului de mașini din BD care au sub 100 000 km");
			System.out.println("7) Extragera unei liste care conţine maşinile mai noi de 5 ani.");
			System.out.println("Optiunea dumneavoastra: ");
			opt=scanner.nextInt();
			switch (opt){
				case 0:
					System.exit(0);
				case 1:
					adaugareMasina();
					break;
				case 2:
					stergereNrInmatriculare();
					break;
				case 3:
					cautareNrInmatriculare();
					break;
				case 4:
					System.out.println("\nToate masinile: ");
					masinaSDJPArepository.findAll().forEach(System.out::println);
					masinaSDJPArepository.findAll().forEach(m->logger.info("{}\n", m));
					break;
				case 5:
					masiniMarcaTastatura();
					break;
				case 6:
					masiniSub100_000km();
					break;
				case 7:
					masiniMaiNoi5Ani();
					break;
			}
		}
	}
}
