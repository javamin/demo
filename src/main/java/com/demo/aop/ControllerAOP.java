package com.demo.aop;



import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.pojo.ResultBean;
/**
 * AOP动态切入controller，并统一规范
 * @author yuan
 *
 */
public class ControllerAOP {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);
	 
	  public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
	    long startTime = System.currentTimeMillis();
	    logger.info("切入开始...");
	    ResultBean<?> result;
	    String[] parameters = null;
	 
	    try {
	    	Signature signature = pjp.getSignature();
	    	MethodSignature ms = (MethodSignature)signature;
	    	parameters = ms.getParameterNames();
	    	result = (ResultBean<?>) pjp.proceed();
	    } catch (Throwable e) {
	      result = handlerException(pjp, e);
	    }
	    logger.info(pjp.getSignature() + "  " + Arrays.toString(parameters) + " use time:" + (System.currentTimeMillis() - startTime));
	    logger.info("切入结束...");
	    return result;
	  }
	 
	  //组装异常数据
	  private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
	    ResultBean<?> result = new ResultBean<>();
	      logger.error(pjp.getSignature() + " error ", e);
	      result.setMsg(e.toString());
	      result.setCode(ResultBean.FAIL);
	    return result;
	  }

}
