package com.amazon.springapi.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

  @Pointcut("execution(* com.amazon.springapi.controllers.hello.get*(..))")
  private void hello(){}

  @Before("hello()")
  public void beforeDaoPackage(){
      System.out.println("Hello Controller called");
  }




}
