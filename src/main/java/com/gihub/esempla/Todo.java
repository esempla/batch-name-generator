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

        Rules rules = Rules.builder().userName("Grisha").currentTime("12:12").jobId("3").build();
        String input = "$$UserName";
        String output = rules.parse();
        System.err.println(output);


    }

}

