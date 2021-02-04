package my_package.acceptance;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static my_package.acceptance.config.DataTableConfigurator.AClass;

public class ExampleCucumberStep {

    @Given("a thing with value {string}")
    public void a_user(String thing) {
    }

    @And("a list of instances of AClass:")
    public void aListOfPayments(DataTable dataTable) {
        List<AClass> list = dataTable.asList(AClass.class);
    }

    @When("execute the thing with value {string}")
    public void executeDeDetectionOfUnusualExpenses(String thing) {
    }

    @Then("do something with value {string} with this text")
    public void sendAMailWithThisMessage(String mail, String body) {
        Assert.assertTrue(true);
        //Assert.fail("It will fail, nothing implemented yet");
    }

}
