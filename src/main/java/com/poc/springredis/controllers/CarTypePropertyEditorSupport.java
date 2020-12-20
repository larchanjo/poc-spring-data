package com.poc.springredis.controllers;

import com.poc.springredis.domain.CarType;
import java.beans.PropertyEditorSupport;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarTypePropertyEditorSupport extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return ((CarType) getValue()).name();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(CarType.valueOf(text));
        } catch (IllegalArgumentException illegalArgumentException) {
            log.warn("Fail to convert {} to {}", text, CarType.class.getSimpleName());
        }
    }

}
