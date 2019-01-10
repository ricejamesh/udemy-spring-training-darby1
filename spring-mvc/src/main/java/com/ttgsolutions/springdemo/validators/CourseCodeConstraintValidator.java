package com.ttgsolutions.springdemo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;

   public void initialize(CourseCode theCourseCode) {
      coursePrefix = theCourseCode.value();
   }

   public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

      boolean result = true;

      if (theCode != null) {
         result = theCode.startsWith(coursePrefix);
      }

      return result;
   }
}
