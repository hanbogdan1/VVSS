package lab5.features.search;

import lab5.steps.serenity.AddUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "C:\\Users\\Bogdan\\Desktop\\vvss-lab5-serenity-master\\src\\test\\resources\\features\\add\\AddData.csv")
public class AddNota {

    @Managed(uniqueSession = true)
    WebDriver webdriver = new ChromeDriver();

    @Steps
    public AddUserSteps tudor;

    String nr_matricol;
    String materie ;
    String nota;

    String result;

    @Issue("#ADD-1")
    @Test
    public void adding_data_should_display_the_correct_message() {
        tudor.is_the_home_page();
        tudor.adds(getNr_matricol(),getMaterie(),getNota());
        tudor.should_see_result(getResult());
    }



    @Qualifier
    public String getQualifier() {
        return nr_matricol;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }

    public void setWebdriver(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public AddUserSteps getTudor() {
        return tudor;
    }

    public void setTudor(AddUserSteps tudor) {
        this.tudor = tudor;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNr_matricol() {
        return nr_matricol;
    }

    public void setNr_matricol(String nr_matricol) {
        this.nr_matricol = nr_matricol;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
