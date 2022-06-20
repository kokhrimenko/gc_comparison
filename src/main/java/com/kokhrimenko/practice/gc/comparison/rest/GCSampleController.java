package com.kokhrimenko.practice.gc.comparison.rest;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GCSampleController {

	@GetMapping("/get-version")
	public String doGetAction() {
		StringBuilder result = new StringBuilder();
		result.append("Java version: " + System.getProperty("java.version") + "\n");
		
		List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcMxBean : gcMxBeans) {
        	result.append("-----------------------\n");
        	result.append("mx bean name: " + gcMxBean.getName() + "\n");
        	result.append("mx bean object: " + gcMxBean.getObjectName() + "\n");
        	result.append("-----------------------\n");
        }

        return result.toString();
	}

}
