package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Holiday {

  private LocalDate date;
  private String description;

  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public Holiday() {
  }

  public Holiday(LocalDate date, String description) {
    this.date = date;
    this.description = description;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDescription() {
    return description.trim();
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return getDate().format(fmt) + " => " + getDescription();
  }

  /*@Override
  public int compareTo(Holiday holiday) {
    return this.date.compareTo(holiday.getDate());
  }
*/
  

  public static Comparator<Holiday> holidayDescriptionComparator = new Comparator<Holiday>() {
    public int compare(Holiday h1, Holiday h2) {
      return h1.getDescription().compareTo(h2.getDescription());
    }
  };
  
  public static Comparator<Holiday> holidayDateComparator = new Comparator<Holiday>() {
    public int compare(Holiday h1, Holiday h2) {
      return h1.getDate().compareTo(h2.getDate());
    }
  };
  
}
