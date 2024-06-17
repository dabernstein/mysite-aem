package com.mysite.core.returnrunmode.impl;

import java.util.Map;

import com.mysite.core.returnrunmode.Runmodes;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.converter.Converters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = {Runmodes.class},
    property = {"runmode=none"}
)
public class RunmodesImpl implements Runmodes {
    private static final Logger log = LoggerFactory.getLogger(RunmodesImpl.class);

    private String runmode;

    public String getRunmode() {
        return runmode;
    }

    @Activate
    protected void activate(Map<String, Object> properties) {
        this.runmode = Converters.standardConverter().convert(properties.get("runmode")).defaultValue("none").to(String.class);

        log.info("Activated RunmodesImpl with [{}]", this.runmode);
    }

    @Deactivate
    protected void deactivate() {
        log.info("RunmodesImpl has been deactivated");
    }
}