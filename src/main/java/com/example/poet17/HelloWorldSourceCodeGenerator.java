package com.example.poet17;

import lombok.SneakyThrows;
import org.springframework.javapoet.JavaFile;
import org.springframework.javapoet.MethodSpec;
import org.springframework.javapoet.TypeSpec;
import org.springframework.stereotype.Component;

import javax.lang.model.element.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

@Component

public class HelloWorldSourceCodeGenerator {

    @SneakyThrows
    public String generate(String path) {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.poet17", helloWorld)
                .build();

        javaFile.writeTo(System.out);
        javaFile.writeToPath(Paths.get(path), StandardCharsets.UTF_8);

        return javaFile.toString();
    }
}
