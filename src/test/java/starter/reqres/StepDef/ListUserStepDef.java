package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @And("Response body should page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }


    @Given("Get list user with invalid page {int}")
    public void getListUserWithInvalidPage(int page) {
        reqresAPI.getListUsersInvalid(page);
    }
}
