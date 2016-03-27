package com.syn.phrase.config;

public abstract class PhraseSynConfig {

    protected int maxThreads;

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }
}
