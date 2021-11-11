package com.example.UnidadeAprendizagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class UnidadeAprendizagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnidadeAprendizagemApplication.class, args);
	}
}

/*
 *a) Qual o propósito da anotação @RestController?
 * É responsável por demarcar as classes que recebem as query da url. Basta criarmos uma classe anotada
 * com @RestController, e mapear as rotas da API com as anotações @RequestMapping, @GetMapping, @PostMapping,
 * @PutMapping e @DeleteMapping. Marca a classe como controller, onde todos os métodos retornam objeto e os dados
 * do objeto são gravados diretamente na resposta HTTP como JSON ou XML.
 *
 * b) b) Qual o propósito da anotação @RequestMapping? Qual a sua relação com as anotações @GetMapping, @PostMapping,
 * @PutMapping, @DeleteMapping, e @PatchMapping?
 * É responsavel por mapear web requests que vem de alguma query específica, distribuindo para as devidas classes com
 * métodos manipuladores específicos. as anotações a mais são formas mais simples de mapear mas mesmas coisas
 * que o RequestMap pode mapear.
 *
 * c) Qual o propósito da anotação @RequestParam?
 * Mapeia os parâmetros que vem na url, normalmente seguido por um método que vai distribuir eles da forma desejada
 *
 * d) De que maneira se configura o acesso aos elementos componentes de uma requisição HTTP?
 * Mapeando as variáveis que podem vir na requisição e redistribuindo para as funcionalidades necessárias
 * para aquela requisição, utilizando os @mostrados acima.
 *
 *e) Qual o propósito da bilbioteca “Jackson”?
 * Processar os dados por meio de ferramentas para o java.  including the flagship streaming JSON parser / generator
 * library, matching data-binding library (POJOs to and from JSON) and additional data format modules to process data
 * encoded in Avro, BSON, CBOR, CSV, Smile, (Java) Properties, Protobuf, TOML, XML or YAML;
 *
 */