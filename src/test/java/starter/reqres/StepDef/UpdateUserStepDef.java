package starter.reqres.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(Constant.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with invalid json with id {int}")
    public void putUpdateUserWithInvalidJsonWithId(int id) {
        File json = new File(Constant.JSON_REQUEST + "/invalidUpdate.json");
        reqresAPI.putUpdateUser(id, json);
    }
}