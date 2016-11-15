package com.lmb.openl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by n0292928 on 11/1/16.
 */
public class RuleExecutor  {

    private static final Logger logger = LoggerFactory.getLogger(RuleExecutor.class);
    private RuleFactory ruleFactory;

    public RuleExecutor(final RuleFactory parmRuleFactory) {
        if ( parmRuleFactory != null ) {
            this.ruleFactory = parmRuleFactory;
        }
    }
    // Gets /  Sets
    public RuleFactory getRuleFactory() {
        return ruleFactory;
    }


    // Execute Rule Method
    public Object executeRule(final IRule parmRule) throws NoSuchMethodException,IllegalArgumentException,
                                                           IllegalAccessException,InvocationTargetException {
        Object objResults = null;
        logger.info("Rule Exec request...Rule Name ( Method ) [{}]", parmRule.getRuleMethodName());

        for ( Object arg : parmRule.getArgValues()) {
              logger.info("Parm Value = [{}]", arg.toString());
        }
        Class<?> objWrapperClass = this.ruleFactory.getRulesEngineFactory().getInterfaceClass();
        if (objWrapperClass != null ) {

           Method method = objWrapperClass.getMethod(parmRule.getRuleMethodName(), parmRule.getArgTypes());
           objResults = method.invoke(this.ruleFactory.getRuleEngineInstance(), parmRule.getArgValues());
        }
        return objResults;
    }
}
