package com.lmb.openl.service;

import org.openl.rules.runtime.RulesEngineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * Created by n0292928 on 11/1/16.
 */
public class RuleFactory {
    private static final Logger logger = LoggerFactory.getLogger(RuleFactory.class);

    private static RuleFactory ruleFactory=null;
    private static RulesEngineFactory<Object>   rulesEngineFactory=null;
    private static Object                       ruleEngineInstance=null;
    private static String                       rulePathFileName;

    // Gets / Sets
    public Object getRuleEngineInstance() { return ruleEngineInstance; }
    public RulesEngineFactory<Object> getRulesEngineFactory() { return rulesEngineFactory;  }

    // Each RulesFactory Create will invalidate the existing RulesFactory singleton
    public static RuleFactory createRuleFactory(final String parmRulePathFileName) {
      if ( ! StringUtils.isEmpty(parmRulePathFileName) && setRulePathFileName(parmRulePathFileName)) {
            ruleFactory = new RuleFactory();
            ruleFactory.rulesEngineFactory = new RulesEngineFactory<Object>(rulePathFileName);
            ruleFactory.ruleEngineInstance = rulesEngineFactory.newEngineInstance();
      } else {
          ruleFactory = null;
      }
      return ruleFactory;
    }

    private static Boolean setRulePathFileName(final String parmRulePathFileName) {
        Boolean bRetValue = false;
        if (! StringUtils.isEmpty(parmRulePathFileName)) {
            File ruleFile = new File(parmRulePathFileName);
            if (ruleFile.exists()) {
                bRetValue = true;
                rulePathFileName = parmRulePathFileName;
            }
        }
        return bRetValue;
    }

}
