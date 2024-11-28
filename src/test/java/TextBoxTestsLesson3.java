import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTestsLesson3 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 4000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("ivanova@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8908888888");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--015").click();


        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("git.PNG");

        $("#currentAddress").setValue("Palace Square, 4, Saint Petersburg");
        $("#state").click();
        $("#state").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaiselmer")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $(".table-responsive").$(byText("Student Name"))
                .sibling(0).shouldHave(text("Maria Ivanova"));
        $(".table-responsive").$(byText("Student Email"))
                .sibling(0).shouldHave(text("ivanova@mail.ru"));
        $(".table-responsive").$(byText("Gender"))
                .sibling(0).shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile"))
                .sibling(0).shouldHave(text("8908888888"));
        $(".table-responsive").$(byText("Date of Birth"))
                .sibling(0).shouldHave(text("15 September,2000"));
        $(".table-responsive").$(byText("Subjects"))
                .sibling(0).shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies"))
                .sibling(0).shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture"))
                .sibling(0).shouldHave(text("git.png"));
        $(".table-responsive").$(byText("Address"))
                .sibling(0).shouldHave(text("Palace Square, 4, Saint Petersburg"));
        $(".table-responsive").$(byText("State and City"))
                .sibling(0).shouldHave(text("Rajasthan Jaiselmer"));



        $("#closeLargeModal").click();

    }

}
