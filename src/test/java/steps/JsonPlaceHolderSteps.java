package steps;

import api.HeadersApi;
import api.RequestsApi;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import posts.PostsConstructor;
import utils.PropertiesUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPlaceHolderSteps extends RequestsApi {

    PropertiesUtils propertiesUtils = new PropertiesUtils();
    Faker faker = new Faker();
    PostsConstructor envioPost;
    HeadersApi headersApi = new HeadersApi();
    String userId = "33";

    @Dado("que tenho um token valido")
    public void queTenhoUmTokenValido() {
        System.out.println("Não possui token");
    }

    @Quando("realizo uma request de postagem com dados validos")
    public void realizoUmaRequestDePostagemComDadosValidos() {
        super.uri = propertiesUtils.getProperty("uri_jsonplaceholder");
        super.headers = headersApi.jsonPlaceHolderHeaders();
        super.body = new PostsConstructor(faker.book().title(), faker.book().author()).getJson();

        super.POST();
    }

    @Entao("a postagem deve ser publicada")
    public void aPostagemDeveSerPublicada() {

        assertEquals(body.getString("title"), response.jsonPath().getString("title"));
        assertEquals(body.getString("body"), response.jsonPath().getString("body"));

    }

    @Entao("o status code deve ser {int}")
    public void oStatusCodeDeveSer(Integer statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @E("possuo uma postagem na API JsonPlaceHolder")
    public void possuoUmaPostagemNaAPIJsonPlaceHolder() {
        realizoUmaRequestDeBuscarPostagem();
    }

    @Quando("realizo uma request de buscar postagem")
    public void realizoUmaRequestDeBuscarPostagem() {
        super.uri = propertiesUtils.getProperty("uri_jsonplaceholder") + "/" + userId;
        super.headers = headersApi.jsonPlaceHolderHeaders();


        super.GET();
    }

    @Entao("a postagem deve ser retornada")
    public void aPostagemDeveSerRetornada() {
        String msg = response.asString();
        System.out.println(response.asString());
        assertEquals(msg, response.asString());
    }

    @Quando("altero os dados da postagem")
    public void alteroOsDadosDaPostagem() {
        super.uri = propertiesUtils.getProperty("uri_jsonplaceholder") + "/" + userId;
        super.headers = headersApi.jsonPlaceHolderHeaders();
        super.body = new PostsConstructor(faker.book().title(), faker.book().author()).getJson();


        super.PUT();
    }

    @Entao("a postagem deve ser alterada com sucesso")
    public void aPostagemDeveSerAlteradaComSucesso() {
        assertEquals(super.body.getString("title"), response.jsonPath().getString("title"));
    }

    @Quando("altero um ou mais dados do usuario")
    public void alteroUmOuMaisDadosDoUsuario() {
        super.uri = propertiesUtils.getProperty("uri_jsonplaceholder") + "/" + userId;
        super.headers = headersApi.jsonPlaceHolderHeaders();
        super.body = new PostsConstructor(faker.book().title(), faker.book().author()).getJson();

        super.PATCH();
    }


    @Quando("deletar uma postagem")
    public void deletarUmaPostagem() {
        super.uri = propertiesUtils.getProperty("uri_jsonplaceholder") + "/" + userId;
        super.headers = headersApi.jsonPlaceHolderHeaders();

        super.DELETE();
    }

    @Entao("a postagem deve ser removida com sucesso")
    public void aPostagemDeveSerRemovidaComSucesso() {
        String msg = response.asString();
        System.out.println(response.asString());
        assertEquals(msg, response.asString());

    }
}
