This library was created for generating names based on specific rules such as :

- $UserID
- $UserName
- $CurrentDate
- $CurrentTime
- $JobID

There is a parse method *parseInput("your expression")* that takes your input string and returns the new one. 

#### How it works:
To create data for parsing you can use a builder *.builder().userId("2").userName("test").jobId("3").build();*
And if you want to generate your name based on the following pattern : $UserID-$UserName , data from the builder will be used and the following name will be generated: '2-test'.

If you will write a pattern that is not found in rules like : "$PropertyName" . 
It will throw an exception that property is not found. 

Default value is a concatenated between “CurrentDate”&”CurrentTime”. So for an empty input it will generate a name based on CurrentDate and Time, for ex. "10/10/2010-10:20". 

There is an option to combine variable with a text:
Hello - $CurrentDate, it will result the following output "Hello - $10/10/2018"

#### Steps to start working with it:
- On the command line
- git clone https://github.com/esempla/batch-name-generator.git
- Inside Intellij IDEA 
- File -> New -> Project From Existing Sources...
- Select the pom.xml. Click on the Ok button.

