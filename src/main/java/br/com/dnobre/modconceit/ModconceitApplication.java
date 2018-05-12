package br.com.dnobre.modconceit;

import br.com.dnobre.modconceit.domain.Categoria;
import br.com.dnobre.modconceit.repositories.CategoriaRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModconceitApplication implements CommandLineRunner{

        @Autowired
        CategoriaRepository categoriaRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(ModconceitApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
    }
}
