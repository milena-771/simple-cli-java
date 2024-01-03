<h3>What is a Command Line Interpreter ?</h3>

**A command line interpreter** (CLI) allows the user to interact with a program using commands in the form of text lines. 
It was frequently used till the 1970’s. However, in modern times many command line interpreters are replaced by **graphical user interfaces** (GUI) and menu-driven interfaces.

Command line interpreters can be more useful than graphical user interfaces in some cases :
- Command line interpreters have a **large range of commands and queries** available for different operations. Also, it is **much faster** to type than to click as is done using graphical user interfaces.
- There are some **systems that don’t have enough resources** to support graphical user interfaces. In those cases, command line interpreters can be used.
- Technically **advanced users also prefer command line interpreters** as compared to graphical user interfaces.
- Commands and instructions can be displayed using braille displays in command line interpreters **for people with visual disabilities.**

<h3>How does a CLI work ?</h3>

A command interpreter is a way to interact with the system with **text-based commands only.**<br>
While there are several command-line interpreters, they do not work the same way.<br>
This is because command lines are **based on the syntax of the programming language** that we are using.<br>
Thus, a command that works on a CLI on one system may **not work the same way in other systems.** 

1- Users interact with a system or application by typing in text (commands).<br>
2- The command is typed on a specific line following a **visual prompt** from the computer. A command prompt (or just prompt) is a sequence of (one or more) characters used in a command-line interface to indicate readiness to accept commands. It literally prompts the user to take action.<br>
3- The CLI **receives and displays all characters you have entered.** When you press Enter, the CLI begins to process the command.<br>
4- Command **matching** phase :<br>
  - The system **compares** the received command with commands in the current command mode to search for a matching command.<br>
  - If a **matching command exists**, the system enters the command **checking phase**.<br>
  - If a **matching command does not exist**, the system informs you that the **command is invalid and waits for a new command.**<br>
  
5- Command checking phase :<br>
The CLI **checks every element of the entered command against the matching command** (including the string length and value range validity)<br>
  - If all command elements are **valid**, the system **authenticates the command.**<br>
  - If any command element is **invalid**, the system **informs you that the command is invalid** and waits for a new command.<br>
  
6- Command **parsing** phase<br>
After parsing a command into a **packet that carries specific information**, the CLI sends the packet to the command processing module and waits for the results.<br>
The CLI then **parses** the packet carrying the results and **displays** them on the terminal.<br>

7- The system responds to the text, and the user may then type on the next command line that appears.<br>

Through this command and response interaction, the user is able to issue a series of commands, which are executed by the system or program.

<h3>What is a command line ?</h3>

- The command line is a blank line and cursor on the screen, allowing the user **to type in instructions for immediate execution.**
- Commands can be executed **one at a time by typing the command and pressing Enter.**
- They can also be executed as a group, in which case the commands are typed into **a "batch" or "script" file.** The file name is typed on the command line, and pressing Enter causes **each command to be executed in order.**

<h3>CLI structure</h3>

command [arguments] [options]<br>
<ins>exemple :</ins> ```ls /home/dir --all```

program command [arguments] [options]<br>
<ins>exemple:</ins> ```git commit -m "first commit"```

Commands are usually represented as **verbs** and programs as **nouns** (as they are usually a short version of the program's name).

**Arguments**<br>
- Arguments in a CLI allow users **to send data** to the application, sometimes in a command context.<br>
- They are often called positional arguments because they are **identified by their position**, which means users must write the value for each argument in the correct position.<br>
- They can be **required or not.** If they are not required, the command's behavior may vary in the absence of the parameter, often using a default value instead.<br>

**Options**<br>
- Options are named parameters that can be passed to a command and are represented by **key-value pairs.**<br>
- Unlike positional arguments, **their position is not important.**<br>
- Options are usually (not always) used to represent **optional parameters.** In most cases, if a parameter is required, a positional argument is the best way to go.<br>
- Some options have **aliases**, which are short versions of the same option, easier to type and remember. They're usually identified by a **single dash prefix.**<br>
<ins>exemple :</ins> ```mycli -h```<br>
- Options that don't require a value are often called **Flags.** They are **boolean**, meaning their presence indicates "true" and their absence "false".<br>
<ins>exemple:</ins> ```git push --force```


<h3>Resources</h3>
https://www.tutorialspoint.com/command-line-interpreters<br>
https://techcult.com/what-is-a-command-line-interpreter/<br>
https://www.pcmag.com/encyclopedia/term/command-line<br>
https://dev.to/paulasantamaria/command-line-interfaces-structure-syntax-2533#11-structure


