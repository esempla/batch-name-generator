package tests;

import com.gihub.esempla.model.NoSuchProperty;
import com.gihub.esempla.model.Rules;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RulesTest {


    @Test
    public void testValidUsernameAndDate() throws Exception {
        Rules rules = Rules.builder()
                .userName("Test").userId("1")
                .currentTime("10:10").currentDate("10/10/2018")
                .jobId("3").build();

        String input = "$UserName-$CurrentDate";
        String output = rules.parseInput(input);
        assertEquals(output, "Test-10/10/2018");
    }

    @Test
    public void testValidUsernameAndEmptyDate() throws Exception {
        Rules rules = Rules.builder()
                .userName("Test").userId("1")
                .currentTime("10:10")
                .jobId("3").build();

        String input = "$UserName-$CurrentDate";
        String output = rules.parseInput(input);
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(output, "Test-" + localDate);
    }

    @Test
    public void testInvalidInput() throws Exception {
        Rules rules = Rules.builder()
                .userName("Test").userId("1")
                .currentTime("10:10")
                .jobId("3").build();

        String input = "$PropertyName";
        String output = rules.parseInput(input);
        Executable closureContainingCodeToTest = () -> new NoSuchProperty("Property not Found.");
        assertThrows(NoSuchProperty.class, closureContainingCodeToTest, "Property not Found.");

    }

    @Test
    public void testEmptyExpression() throws Exception {
        Rules rules = new Rules();
        String output = rules.parse();
        String localTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(output, localDate + "&" + localTime);
    }

    @Test
    public void testTextWithVariable() throws Exception {
        Rules rules = Rules.builder()
                .userName("Test").userId("1")
                .currentTime("10:10")
                .jobId("3").build();

        String input = "Test - $JobID";
        String output = rules.parseInput(input);
        assertEquals(output, "Test -" + " 3");

    }
}
