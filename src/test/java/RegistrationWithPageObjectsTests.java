import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestDataGenerator;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataGenerator testData = new TestDataGenerator();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.emailAddress)
                .setGender(testData.gender)
                .setUserNumber(testData.mobileNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubjects(testData.subjects)
                .setHobbiesWrapper(testData.hobbies)
                .setUploadPicture("git.png")
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city);
        registrationPage.submit();
        registrationPage.checkModalDialogAppear()
                .checkDataInTable("Student Name",testData.firstName + " " + testData.lastName)
                .checkDataInTable("Student Email",testData.emailAddress)
                .checkDataInTable("Gender",testData.gender)
                .checkDataInTable("Mobile",testData.mobileNumber)
                .checkDataInTable("Date of Birth",testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkDataInTable("Subjects",testData.subjects)
                .checkDataInTable("Hobbies",testData.hobbies)
                .checkDataInTable("Picture","git.png")
                .checkDataInTable("Address", testData.currentAddress)
                .checkDataInTable("State and City",testData.state +" " + testData.city);

    }

    @Test
    void successfulRegistrationMinimumValuesTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.emailAddress)
                .setGender(testData.gender)
                .setUserNumber(testData.mobileNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth);
        registrationPage.submit();
        registrationPage.checkModalDialogAppear()
                .checkDataInTable("Student Name",testData.firstName + " " + testData.lastName)
                .checkDataInTable("Student Email",testData.emailAddress)
                .checkDataInTable("Gender",testData.gender)
                .checkDataInTable("Mobile",testData.mobileNumber)
                .checkDataInTable("Date of Birth",testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth);
    }

    @Test
    void unsuccessfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .submit()
                .checkModalDialogNotAppear();
      }
}