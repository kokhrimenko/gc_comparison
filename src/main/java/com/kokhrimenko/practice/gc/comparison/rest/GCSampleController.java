package com.kokhrimenko.practice.gc.comparison.rest;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GCSampleController {

	private static final List<UUID> oldGenObjectsToOccupy = new ArrayList<>();
	
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

        result.append("heap size: " + formatSize(Runtime.getRuntime().totalMemory()) + "\n");
        result.append("heap max size: " + formatSize(Runtime.getRuntime().maxMemory()) + "\n");
        result.append("heap free size: " + formatSize(Runtime.getRuntime().freeMemory()) + "\n");

        return result.toString();
	}

	private static String formatSize(long v) {
		if (v < 1024) {
			return v + " B";
		}
		int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
		return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
	}

	@PostMapping("/generate")
	public boolean generate() {
		for (int i = 0; i < 1_000_000; i++) {
			oldGenObjectsToOccupy.add(UUID.randomUUID());
		}
		return true;
	}
}
