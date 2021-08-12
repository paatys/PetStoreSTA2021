
// 1- Package

package petstore;

// 2- Libraries


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3-Class
public class Pet {
    // 3.1 - Attribute

    String uri = "https://petstore.swagger.io/v2/pet"; // endereço da entidade pet


    //3 .2 - Method and Function
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test //identifica o metodo ou funcao como um teste para o TestNG ou Junit
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/petprimeiro.json");


        //Sintaxe Gherkin
        //Dado - Quando - Então - Given - When - Then

        given() //Dado
                .contentType("application/json") //comum em API REST - antigas era "text/xml"
                .log().all()
                .body(jsonBody)
        .when() //Quando
                .post(uri)
        .then() //Entao
                .log().all() //preparacao para registrar a respostas
                .statusCode(200)
        ;

    }
}
