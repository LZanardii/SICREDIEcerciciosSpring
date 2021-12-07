package br.sicredi.CrossOriginRequests;

import br.sicredi.CrossOriginRequests.entities.Greeting;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrossOriginRequestsApplicationTests {

	public static void main(String[] args) {
		Greeting g = new Greeting();

		Greeting g2 = new Greeting(123, "Leo");

		System.out.println(g.getId())
		;

		System.out.println(g2.getContent());
	}
}
