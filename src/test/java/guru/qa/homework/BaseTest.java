package guru.qa.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

  @BeforeAll
  public static void setUp() {
    Configuration.browserSize = "1920x1080";
  }

}
