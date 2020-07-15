package com.huo.dragger.base.inject;

import com.huo.dragger.base.DaggerActivity;

import dagger.Component;

@Component
public interface ComponentTest {
    void inject(DaggerInjectActivity receiver);
    void injectKotlin(DaggerActivity receiver);
}
