package guru.qa.homework;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends BaseTest {

  private static final String FIRST_NAME = "Ivan";
  private static final String LAST_NAME = "Ivanov";
  private static final String EMAIL = "ivanov@mail.ru";
  private static final String GENDER = "male";
  private static final String PHONE_NUMBER = "9000000000";
  private static final String BIRTH_DATE = "07 April,1990";
  private static final String SUBJECT = "Maths";
  private static final String HOBBIES = "Reading";
  private static final String IMAGE_NAME = "image.png";
  private static final String ADDRESS = "test address";
  private static final String STATE = "NCR";
  private static final String CITY = "Delhi";

  @Test
  public void submitFormWithValidData() {
    open("https://demoqa.com/automation-practice-form");
    $x("//input[@id='firstName']").setValue(FIRST_NAME);
    $x("//input[@id='lastName']").setValue(LAST_NAME);
    $x("//input[@id='userEmail']").setValue(EMAIL);
    $x("//label[@for='gender-radio-1']").click();
    $x("//input[@id='userNumber']").setValue(PHONE_NUMBER);
    $x("//input[@id='dateOfBirthInput']").click();
    $x("//select[@class='react-datepicker__month-select']").click();
    $x("//option[@value='3']").click();
    $x("//select[@class='react-datepicker__year-select']").click();
    $x("//option[@value='1990']").click();
    $x("//div[contains(text(), '7')]").click();
    $x("//input[@id='subjectsInput']").setValue(SUBJECT).pressEnter();
    $x("//label[@for='hobbies-checkbox-2']").click();
    $x("//input[@id='uploadPicture']").uploadFromClasspath(IMAGE_NAME);
    $x("//textarea[@id='currentAddress']").setValue(ADDRESS);
    $x("//input[@id='react-select-3-input']").setValue(STATE).pressEnter();
    $x("//input[@id='react-select-4-input']").setValue(CITY).pressEnter();
    $x("//button[@id='submit']").scrollTo().click();
    checkField("Student Name", FIRST_NAME + " " + LAST_NAME);
    checkField("Student Email", EMAIL);
    checkField("Gender", GENDER);
    checkField("Mobile", PHONE_NUMBER);
    checkField("Date of Birth", BIRTH_DATE);
    checkField("Subjects", SUBJECT);
    checkField("Hobbies", HOBBIES);
    checkField("Picture", IMAGE_NAME);
    checkField("Address", ADDRESS);
    checkField("State and City", STATE + " " + CITY);
  }

  private void checkField(String label, String value) {
    $x(("//td[text()='" + label + "']/following-sibling::td")).shouldHave(exactText(value));
  }

}
