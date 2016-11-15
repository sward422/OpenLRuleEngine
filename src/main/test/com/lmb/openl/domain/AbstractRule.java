package com.lmb.openl.domain;

import com.lmb.openl.service.IRule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by n0292928 on 11/1/16.
 */
public abstract class AbstractRule implements IRule {
    private static final Logger logger = LoggerFactory.getLogger(AbstractRule.class);

    private String          ruleMethodName;
    private Class<?>[]      argTypes;
    private Object[]        argValues;
    private Boolean         bStatus = false;

    // Gets
    public Boolean getRuleStatus() { return bStatus; }
    public String getRuleMethodName() { return ruleMethodName; }
    public Class<?>[] getArgTypes() {
        return argTypes;
    }
    public Object[] getArgValues() {
        return argValues;
    }

    public AbstractRule() {
        this.ruleMethodName = StringUtils.EMPTY;
        this.argTypes       = null;
        this.argValues      = null;
        this.bStatus        = false;
    }

    public AbstractRule(final String parmMethodName, final Class<?>[] parmArgTypes, final Object[] parmArgValues ) {

        if ( validateRuleArgs(parmArgTypes, parmArgValues) ) {
            this.ruleMethodName = parmMethodName;
            this.argTypes       = parmArgTypes;
            this.argValues      = parmArgValues;
            this.bStatus        = true;
        }
    }

    private boolean validateRuleArgs(final Class<?>[] parmArgTypes, final Object[] parmArgValues) {
        // Make Sure the rule parms match rule method signature
        if (parmArgValues != null && parmArgValues.length == parmArgTypes.length)
            return true;
        else return false;
    }

}
