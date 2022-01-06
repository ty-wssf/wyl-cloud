package com.wyl.component.extension;

import org.springframework.stereotype.Component;

@Component
public class SomeExtensionA implements SomeExtPt {

    @Override
    public void doSomeThing() {
        System.out.println("SomeExtensionA::doSomething");
    }

}
