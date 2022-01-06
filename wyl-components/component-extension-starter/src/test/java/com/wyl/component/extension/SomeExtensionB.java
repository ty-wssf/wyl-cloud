package com.wyl.component.extension;

import org.springframework.stereotype.Component;

@Extension("2222")
@Component
public class SomeExtensionB implements SomeExtPt {

    @Override
    public void doSomeThing() {
        System.out.println("SomeExtensionB::doSomething");
    }

}
