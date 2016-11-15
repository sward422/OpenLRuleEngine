package com.lmb.openl.service;

public interface IRule {

    public static final String         RULE_HELLO   = "hello";
    public static final String         RULE_MEDICAL = "medicalPremium";
    public static final String         RULE_LIFE    = "termLifePremium";

    public String       getRuleMethodName();
    public Class<?>[]   getArgTypes();
    public Object[]     getArgValues();

}
