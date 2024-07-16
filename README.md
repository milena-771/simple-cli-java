# Simple CLI Java project

## General description

## Commands

**`hw`**
- Command to display "Hello World!" in Eclipse console.

**`date`,`time` and `datetime`**
- Command to display current date, time and datetime in ISO-8601 format.

**`--timezone="Europe/Paris"`**
- Optionnal parameter for date, time and datetime commands
- `--timezone=` must be followed by a timezone which belongs to IANA Timezone Database and be displayed in quotation marks
- without the parameter, it uses the default timezone
- if one of the command is followed by an unknown parameter, this error message is printed: "Did you mean --timezone= ?"
- if the parameter is used but without a timezone, this error message is printed: "Please specify a timezone name."
- if the parameter is used with a timezone without quotation marks, this error message is printed "Please specify a timezone between quotes."
- if the parameter is used with an unknown timezone, this error message is printed: "Please specify a registered IANA timezone name."
  
**`print` and its alias `echo`**
- Command to display a text passed as an argument.
- It can be one or several words
- Without argument, an empty line is printed.
- exemple: `echo Bonjour` > Bonjour, `print Hi there!` > Hi there!
  
**`secsanta`**
- Command that allows you to randomly generate pairs of names from an input list
- The delimiter is a comma
- without argument, this error message is printed: "Please provide a list of names to propose pairs from."
- if the number of names given is not even, this error message is printed: "Please provide an even number of names."
- The output is the name pairs separated by :: and surrounded by []. Each pairs is separated by a blank space. The names are those given as input but returned randomly.
- exemple: `secsanta Amélie, Isabelle, Emilie, Meryll` > [Amélie::Meryll] [Isabelle::Emilie]

## Technical Stacks

- Maven Project
- Java 17
- JUnit tests

For more informations on what is a CLI, please check out [my wiki documentation](https://github.com/milena-771/simple-cli-java/wiki).


