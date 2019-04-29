package com.cm.SueldoService;

import com.cm.entity.SueldoEntityImpl;
import com.cm.service.ISRService;
import com.cm.service.ISRServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class SueldoServiceApplicationTests {



	@Test
	public void sucecesOnCorrectISRCalculation(){
		ISRService service = new ISRServiceImpl(new SueldoEntityImpl());
		Double resultado ;
		final StringBuilder result = new StringBuilder();
		Mono<Double> isr = service.calculaISR(333.00);
		isr.subscribe(result::append);

		Assert.assertEquals("1035.36", result.toString());

	}

}
