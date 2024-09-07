import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckJUnitExample {

    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1366x768";
    }

    @Test
    void checkJUniteCodeExampleTest() {
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$("div[data-testid='results-list'] div").first().$("a").click();
        $("a[href='/selenide/selenide']").shouldHave(text("selenide"));
        $("a[href='/selenide/selenide/wiki']").click();
        $("#wiki-content").shouldHave(text("Soft assertions"));
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                    @Test
                    void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");

                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                    }
                } 
                """));
    }
}

