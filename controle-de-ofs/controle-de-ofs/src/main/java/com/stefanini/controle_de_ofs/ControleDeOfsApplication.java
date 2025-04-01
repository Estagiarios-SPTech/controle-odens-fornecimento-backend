package com.stefanini.controle_de_ofs;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Documentação Controle de OFs",
				version = "1.0",
				description = "Aqui você verá os endpoints disponíveis além das models utilizadas.\n\n Desenvolvedores: [Fabio](https://github.com/FabioKuriki-Stefanini), [Shirley](https://github.com/sferlima)"
		)
)
public class ControleDeOfsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeOfsApplication.class, args);
	}

}
