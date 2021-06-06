package com.sec.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class SampleController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String home() {
        return new String("complete");
    }

    @RequestMapping(value="/{serviceid}/monitoring/v1/ping", method=RequestMethod.GET)
    public String ping() {
        return new String("OK");
    }
}
