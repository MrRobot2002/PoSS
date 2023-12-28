package com.vu.localhost.poss;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RFC3339DateFormat extends DateFormat {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

  @Override
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    // Convert Date to ZonedDateTime
    ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());
    // Format the ZonedDateTime
    String formatted = FORMATTER.format(zdt);
    // Append the formatted string to the StringBuffer
    toAppendTo.append(formatted);
    return toAppendTo;
  }

  @Override
  public Date parse(String source, ParsePosition pos) {
    // Implement the parsing logic to convert a string into a Date
    // This is a placeholder implementation
    throw new UnsupportedOperationException("Parsing not implemented.");
  }

  // Additional convenience method for formatting ZonedDateTime
  public String format(ZonedDateTime dateTime) {
    return FORMATTER.format(dateTime);
  }
}
