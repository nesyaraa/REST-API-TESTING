package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;


public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;


    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RequestLogin.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN_USER, equalTo(token));
    }

    @And("Validate json schema login")
    public void validateJsonSchemaLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post login user with invalid json")
    public void postLoginUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/invalidLogin.json");
        reqresAPI.postLoginUser(json);
    }
}
