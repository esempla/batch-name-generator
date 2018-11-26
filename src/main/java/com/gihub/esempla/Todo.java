package com.gihub.esempla;

import com.gihub.esempla.model.Rules;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;


@AllArgsConstructor
@Data
public class Todo {

    private final ModelMapper modelMapper;


    public static void main(String[] args) throws Exception {

        Rules rules = Rules.builder().userId("2").userName("test").jobId("3").build();
        String input = "$UserID-$JobID-&$UserName-$CurrentDate";
        String output = rules.parseInput(input);
        System.err.println(output);

        System.out.println(rules.getAllRules());


    }

}

