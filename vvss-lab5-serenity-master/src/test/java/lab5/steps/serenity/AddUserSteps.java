package lab5.steps.serenity;

import lab5.pages.AddPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class AddUserSteps {
    AddPage page;

    @Step
    public void enters(String nr_matricol,String materie,String nota) {
        page.enter_keywords(nr_matricol, materie, nota);
    }

    @Step
    public void starts_adding() {
        page.add_product();
    }

    @Step
    public void should_see_result(String definition) {
        assertThat(page.getResult(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        page.open();
    }

    @Step
    public void adds(String nr_matricol,String materie,String nota) {
        enters(nr_matricol, materie,nota);
        starts_adding();
    }
}
