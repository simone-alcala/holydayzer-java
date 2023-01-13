package model.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Holiday;

public class HolydayService {
  private List<Holiday> holidays = new ArrayList<Holiday>();

  public HolydayService() {
  }

  public List<Holiday> getHolidays() {
    return holidays;
  }

  public List<Holiday> getHolidaysOrderByDate() {
    Collections.sort(holidays, Holiday.holidayDateComparator);
    return holidays;
  }
  
  public List<Holiday> getHolidaysOrderByDescription() {
    Collections.sort(holidays, Holiday.holidayDescriptionComparator);
    return holidays;
  }

  public void addHoliday(Holiday holiday) {
    holidays.add(holiday);
  }

  public void removeHoliday(Holiday holiday) {
    holidays.remove(holiday);
  }
  
  @Override
  public String toString() {
    String result = "";
    for (Holiday holiday : holidays) {
      result += holiday.toString() + "\n";
    }
    return result;
  }
}
