package com.github.esempla;

import com.gihub.esempla.batch.BatchNameGenerator;
import com.gihub.esempla.batch.NoSuchPropertyExceptiopn;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RulesTest {

    @Test
    public void testValidUsernameAndDate() {
        BatchNameGenerator rules = BatchNameGenerator.builder()
                .userName("Test").userId("1")
                .currentTime("10:10").currentDate("10-10-2018")
                .jobId("3").build();

        String input = "$UserName-$CurrentDate";
        String output = rules.parseInput(input);
        assertEquals(output, "Test-10-10-2018");
    }

    @Test
    public void testValidUsernameAndEmptyDate() {
        BatchNameGenerator rules = BatchNameGenerator.builder()
                .userName("Test").userId("1")
                .currentTime("10:10")
                .jobId("3").build();

        String input = "$UserName-$CurrentDate";
        String output = rules.parseInput(input);
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertEquals(output, "Test-" + localDate);
    }

//    @Test
//    public void testInvalidInput()  throws NoSuchPropertyExceptiopn {
//        BatchNameGenerator rules = BatchNameGenerator.builder()
//                .userName("Test").userId("1")
//                .currentTime("10:10")
//                .jobId("3").build();
//
//        String input = "$PropertyName";
//        String output = rules.parseInput(input);
//        Executable closureContainingCodeToTest = () -> new NoSuchPropertyExceptiopn("Property not Found.");
//        assertThrows(NoSuchPropertyExceptiopn.class, closureContainingCodeToTest, "Property not Found.");
//
//    }

    @Test
    public void testEmptyExpression() {
        BatchNameGenerator rules = BatchNameGenerator.builder().build();
        String output = rules.parseInput();
        String localTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertEquals(output, localDate + "&" + localTime);
    }

    @Test
    public void testTextWithVariable() {
        BatchNameGenerator rules = BatchNameGenerator.builder()
                .userName("Test").userId("1")
                .currentTime("10:10")
                .jobId("3").build();

        String input = "Test - $JobID";
        String output = rules.parseInput(input);
        assertEquals(output, "Test -" + " 3");

    }
}
