package com.example.poet17;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class MyCommands {


    private final HelloWorldSourceCodeGenerator helloWorldSourceCodeGenerator;

    @ShellMethod(key = "hello-world")
    public String helloWorld(@ShellOption(defaultValue = ".") String path) {
        return helloWorldSourceCodeGenerator.generate(path);
    }
}