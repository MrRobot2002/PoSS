package com.vu.localhost.poss;

import java.text.FieldPosition;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RFC3339DateFormat extends SimpleDateFormat {

  private static final long serialVersionUID = 1L;

  // Same as SimpleDateFormat but serializing milliseconds.
  @Override
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    String value = super.format(date);
    toAppendTo.append(value);
    return toAppendTo;
  }

}