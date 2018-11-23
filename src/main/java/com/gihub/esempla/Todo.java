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

        Rules rules = Rules.builder().userName("test").currentTime("12:12").jobId("3").build();
        String input = "$-&$JobID";
        String output = rules.parse(input);
        System.err.println(output);

        System.out.println(rules.getAllRules());


    }

}

