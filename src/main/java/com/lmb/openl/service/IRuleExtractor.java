package com.lmb.openl.service;

/**
 * Created by n0292928 on 11/2/16.
 */
public interface IRuleExtractor {

    public Object executeRule(IRule parmRule) throws Exception;
    public static final String NO_MATCH_FOUND  = "Can not determine premium given the supplied values. Please respecify.";
    public static final String INVALID_METHOD_NAME  = "Supplied rule method name is invalid for working rules file. Please respecify";
    public static final String ILLEGAL_DATATYPE  = "Please verify the supplied method argument order and data types. Illegal argument execption has been caught. Please respecify";
}
