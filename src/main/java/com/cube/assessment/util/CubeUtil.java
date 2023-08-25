package com.cube.assessment.util;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class CubeUtil {

//	private static final String URL = "http://ip-api.com/json/%s";
//	private static final String URL = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=precipitation";

	public static String getShortGUID() {
		final UUID uuid = UUID.randomUUID();

		final long lsb = uuid.getLeastSignificantBits();
		final long msb = uuid.getMostSignificantBits();
		final byte[] uuidBytes = ByteBuffer.allocate(16).putLong(msb).putLong(lsb).array();

		return Base64.getEncoder().encodeToString(uuidBytes).substring(0, 22).replace("/", "_").replace("+", "-");
	}
}
