package br.com.dnobre.modconceit;

import br.com.dnobre.modconceit.domain.Categoria;
import br.com.dnobre.modconceit.domain.Cidade;
import br.com.dnobre.modconceit.domain.Cliente;
import br.com.dnobre.modconceit.domain.Endereco;
import br.com.dnobre.modconceit.domain.Estado;
import br.com.dnobre.modconceit.domain.Pagamento;
import br.com.dnobre.modconceit.domain.PagamentoComBoleto;
import br.com.dnobre.modconceit.domain.PagamentoComCartao;
import br.com.dnobre.modconceit.domain.Pedido;
import br.com.dnobre.modconceit.domain.Produto;
import br.com.dnobre.modconceit.domain.enums.EstadoPagamento;
import br.com.dnobre.modconceit.domain.enums.TipoCliente;
import br.com.dnobre.modconceit.repositories.CategoriaRepository;
import br.com.dnobre.modconceit.repositories.CidadeRepository;
import br.com.dnobre.modconceit.repositories.ClienteRepository;
import br.com.dnobre.modconceit.repositories.EnderecoRepository;
import br.com.dnobre.modconceit.repositories.EstadoRepository;
import br.com.dnobre.modconceit.repositories.PagamentoRepository;
import br.com.dnobre.modconceit.repositories.PedidoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.dnobre.modconceit.repositories.ProdutoRepository;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ModconceitApplication implements CommandLineRunner{

        @Autowired
        private CategoriaRepository categoriaRepository;
        
        @Autowired
        private ProdutoRepository produtoRepository;
        
        @Autowired
        private EstadoRepository estadoRepository;
        
        @Autowired
        private CidadeRepository cidadeRepository;
        
        @Autowired
        private ClienteRepository clienteRepository;
        
        @Autowired
        private EnderecoRepository enderecoRepository;
        
        @Autowired
        private PedidoRepository pedidoRepository;
        
        @Autowired
        PagamentoRepository PagamentoRepository;
    
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
        
        
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");
        
        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);
        
        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));
        
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        
        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "123456789", TipoCliente.PESSOAFISICA);
        
        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
        
        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim","38220834",cli1, c1 );
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro","38777012",cli1, c2 );
        
        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
        
        clienteRepository.saveAll(Arrays.asList(cli1));
        
        enderecoRepository.saveAll(Arrays.asList(e1,e2));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
        
        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);
        
        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);
        
        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
       
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        
        PagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
    }
}
