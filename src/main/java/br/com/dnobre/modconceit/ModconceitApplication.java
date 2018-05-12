package br.com.dnobre.modconceit;

import br.com.dnobre.modconceit.domain.Categoria;
import br.com.dnobre.modconceit.domain.Produto;
import br.com.dnobre.modconceit.repositories.CategoriaRepository;
import br.com.dnobre.modconceit.repositories.ProdutoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModconceitApplication implements CommandLineRunner{

        @Autowired
        CategoriaRepository categoriaRepository;
        
        @Autowired
        ProdutoRepository produtoRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(ModconceitApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        
        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);
        
        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));
        
        p1.getCategoria().addAll(Arrays.asList(cat1));
        p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
        p3.getCategoria().addAll(Arrays.asList(cat1));
        
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
        
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
    }
}
