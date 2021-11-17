package com.wyl.component.extension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applicatio {

    public static void main(String[] args) {
        SpringApplication.run(Applicatio.class, args);
        ExtensionLoader.getExtensionLoader(SomeExtPt.class).getDefaultExtension().doSomeThing();
        ExtensionLoader.getExtensionLoader(SomeExtPt.class).getExtension("someExtensionB").doSomeThing();
        ExtensionLoader.getExtensionLoader(SomeExtPt.class).getExtension("sss").doSomeThing();
    }

}
