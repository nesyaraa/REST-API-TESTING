package starter.reqres.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @Given("Delete user with invalid {int}")
    public void deleteUserWithInvalidId(int id) {
        reqresAPI.deleteUser(id);
    }

}