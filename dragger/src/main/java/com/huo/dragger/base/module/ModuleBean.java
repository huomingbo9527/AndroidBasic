package com.huo.dragger.base.module;


public class ModuleBean {

    private String name;

    public ModuleBean(){
    }

    public ModuleBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent(){
        return  "ModuleBean  getContent()  name = "+name;
    }
}
