package lab5.pages;


import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://localhost:8080/AddServlet.html")
public class AddPage extends PageObject {

    @FindBy(name="nr_matricol")
    private WebElementFacade nr_matricol;

    @FindBy(name="materie")
    private WebElementFacade materie;

    @FindBy(name="nota")
    private WebElementFacade nota;

    @FindBy(name="addBtn")
    private WebElementFacade addBtn;


    public void enter_keywords(String nr_matricol,String materie ,String nota) {

        this.nr_matricol.type(nr_matricol);
        this.materie.type(materie);
        this.nota.type(nota);
    }

    public void add_product() {
        addBtn.click();
    }

    public List<String> getResult() {
        WebElementFacade definitionList = find(By.id("res"));
        String text = definitionList.getText();
        List<String> list = new ArrayList<>();
        list.add(text);
        return list;
    }
}
