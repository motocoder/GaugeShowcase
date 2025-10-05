package com.ekndev.gaugelibrary;


import com.ekndev.gaugelibrary.contract.ValueFormatter;

public class DoubleValueFormatterImpl implements ValueFormatter {

    private final int decimalPlaces;

    public DoubleValueFormatterImpl(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
    @Override
    public String getFormattedValue(double value) {
        return String.format("%." + decimalPlaces + "f", value);
    }
}
