package com.huo.dragger.base.inject;

import javax.inject.Inject;

public class InjectTest {
    @Inject
    public InjectTest(){
    }

    public String getContent(){
        return  "InjectTest  getContent()";
    }
}
