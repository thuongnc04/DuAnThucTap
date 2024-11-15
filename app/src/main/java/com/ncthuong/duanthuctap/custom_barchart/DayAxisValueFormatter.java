package com.ncthuong.duanthuctap.custom_barchart;

import com.github.mikephil.charting.formatter.ValueFormatter;

/**
 * Created by philipp on 02/06/16.
 */
public class DayAxisValueFormatter extends ValueFormatter
{

    @Override
    public String getFormattedValue(float value) {
        return "T"+(int)value;
    }
}
