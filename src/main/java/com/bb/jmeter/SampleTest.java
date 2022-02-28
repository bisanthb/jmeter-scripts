package com.bb.jmeter;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SampleTest extends AbstractJavaSamplerClient {
    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sampleResult = new SampleResult();
        sampleResult.sampleStart();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gtin", UUID.randomUUID());
        jsonObject.put("isConsumable", true);
        sampleResult.setResponseData(jsonObject.toString().getBytes(StandardCharsets.UTF_8));

        sampleResult.setResponseMessage("OK");
        sampleResult.setSuccessful(true);

        sampleResult.sampleEnd();
        return sampleResult;
    }
}
