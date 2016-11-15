package com.lmb.openl.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by n0292928 on 11/1/16.
 */
@Component
public class MedicalPremiumRule extends AbstractRule {
    private static final Logger logger = LoggerFactory.getLogger(MedicalPremiumRule.class);

    public  static final Class<?>[]     REQUIRED_MEDICAL_ARG_TYPES = {Integer.class,String.class,Boolean.class};
    public  static final Integer        REQUIRED_MEDICAL_ARG_COUNT = REQUIRED_MEDICAL_ARG_TYPES.length;

    private Integer     age;
    private String      gender;
    private Boolean     smoker;

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Boolean getSmoker() {
        return smoker;
    }
    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    public MedicalPremiumRule() { super();  }
    public MedicalPremiumRule(final String parmMethodName, final Object[] parmArgValues ) {
        super(parmMethodName, REQUIRED_MEDICAL_ARG_TYPES, parmArgValues);
    }

}
