package com.example.TemaLaborator9JPA;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Year;
import java.util.Scanner;
import org.slf4j.Logger;

@SpringBootApplication
public class TemaLaborator9JpaApplication implements CommandLineRunner {

	private final Logger logger = (Logger) LoggerFactory.getLogger(TemaLaborator9JpaApplication.class);
	@Autowired
	MasinaJPArepository masinaJPArepository;

	public void adaugareMasina(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("NrInmatriculare: ");
		String nrInmatriculare = scanner.nextLine();
		System.out.println("Marca: ");
		String marca = scanner.nextLine();
		System.out.println("anulFabricatiei: ");
		int anulFabricatiei = scanner.nextInt();
		System.out.println("Culoarea: ");
		String culoare = scanner.next();
		System.out.println("NrKm: ");
		int nrKm = scanner.nextInt();

		Masina masina=new Masina(nrInmatriculare, marca, anulFabricatiei, culoare, nrKm);
		masinaJPArepository.insert(masina);
		logger.info("Masina adaugata: {}", masina);
	}

	public void stergereNrInmatriculare(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Numarul de inmatriculare: ");
		String nrInmatriculare = scanner.nextLine();
		masinaJPArepository.deleteById(nrInmatriculare);
		System.out.println("Masina cu numarul de inmatriculare: " + nrInmatriculare+" a fost stearsa");
		logger.info("Masina cu numarul de inmatriculare {} a fost stearsa", nrInmatriculare);
	}

	public void cautareNrInmatriculare(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Numar de inmatriculare: ");
		String nrInmatriculare = scanner.nextLine();
		System.out.println(masinaJPArepository.findById(nrInmatriculare).toString());
		Masina masina = masinaJPArepository.findById(nrInmatriculare);
		logger.info("Masina gasita: {}", masina);
	}

	public void masiniMarcaTastatura(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Marca: ");
		String marca = scanner.nextLine();
		masinaJPArepository.findAll().stream().filter(m->m.getMarca().equals(marca)).forEach(System.out::println);
		masinaJPArepository.findAll().stream().filter(m->m.getMarca().equals(marca))
				.forEach(m->logger.info("Masini cu marca {}: {}", marca,m));
	}

	public void masiniSub100_000km(){
		masinaJPArepository.findAll().stream().filter(m->m.getNumar_km()<100000).forEach(System.out::println);
		masinaJPArepository.findAll().stream().filter(m->m.getNumar_km()<100000).forEach(m->logger.info("{}", m));
	}

	public void masiniMaiNoi5Ani(){
		for(Masina masina : masinaJPArepository.findAll()){
			int varsta= Year.now().getValue()-masina.getAnul();
			if(varsta<5){
				System.out.println(masina.toString());
				logger.info("{}",masina);
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(TemaLaborator9JpaApplication.class, args);
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
					masinaJPArepository.findAll().forEach(System.out::println);
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

