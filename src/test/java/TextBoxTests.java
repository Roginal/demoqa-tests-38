package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        // Открытие страницы (используем относительный URL благодаря baseUrl)
        open("/text-box");

        // Заполнение основных полей
        $("#userName").setValue("Gleb");
        $("#userEmail").setValue("plekhov.gleb@yandex.ru");
        $("#currentAddress").setValue("Some Street 1");
        $("#permanentAddress").setValue("Another street 1");

        // Отправка формы
        $("#submit").click();

        // Проверка результатов
        $("#output").shouldBe(Condition.visible);
        $("#name").shouldHave(Condition.text("Gleb"));
        $("#email").shouldHave(Condition.text("plekhov.gleb@yandex.ru"));
        $("#output #currentAddress").shouldHave(Condition.text("Some Street 1"));
        $("#output #permanentAddress").shouldHave(Condition.text("Another street 1"));
    }
}