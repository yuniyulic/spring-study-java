package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.allPointcut()") //aroundLog() 메소드를 Around 어드바이스로 동작시키기 위해 메소드 위에 @Around 어노테이션 추가
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//aroundLog() 메소드도 바인드 변수가 없으므로 포인트컷 메소드만 참조하면 됨.
		//어드바이스 메소드 中 유일하기 Around메소드에서만 ProceedingJoinPoint객체를 매개변수로 받음.
		
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	}
}
