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

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {

    @Steps
    ReqresAPI reqresAPI;


    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RequestRegister.json");
        reqresAPI.postRegisterUser(json);
    }

    @And("Response body id should be {int} and token {string}")
    public void responseBodyEmailShouldBeAndPassword(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID_USER, equalTo(id))
                .body(ReqresResponses.TOKEN_USER, equalTo(token));
    }

    @And("Validate json schema register")
    public void validateJsonSchemaRegister() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/invalidRegister.json");
        reqresAPI.postInvalidRegister(json);
    }
}
