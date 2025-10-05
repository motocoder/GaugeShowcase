package com.ekndev.guagelibrary;


import com.ekndev.guagelibrary.contract.ValueFormatter;

public class ValueFormatterImpl implements ValueFormatter {
    @Override
    public String getFormattedValue(double value) {
        return String.valueOf(value);
    }
}
