
package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;

import java.io.File;

public class ReqresAPI {
//    public static String BASE_URL = "https://reqres.in"; //ini base URL
//    public static final String DIR = System.getProperty("user.dir"); //ini untuk dapatkan location project
//    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request"; //untuk path JSON Request
//    public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema"; //untuk path JSON Schema

    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}"; //untuk URL get list users
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users"; //untuk URL create user
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}"; //untuk URL update user
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}"; //untuk URL delete user
    public static String REGISTER_USER = Constant.BASE_URL+"/api/register";
    public static String LOGIN_USER = Constant.BASE_URL+"/api/login";



    //METHOD
    @Step("Get list users") //valid get list user
    public void getListUsers(int page){

        SerenityRest.given().pathParam("page",page);
    }

    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login  user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Post create user invalid")
    public void postCreateUserInvalidJson(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("list user invalid")
    public void getListUsersInvalid(int page) {
        SerenityRest.given().pathParam("page",page);
    }

    @Step ("Invalid Register")
    public void postInvalidRegister(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}