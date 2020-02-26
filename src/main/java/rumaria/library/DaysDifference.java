package rumaria.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DaysDifference {

  public void main() throws ParseException {
    String str = "2017/11/02 00:00:00";
    Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(str);
    str = "2017/11/07 00:00:00";
    Date date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(str);
    final int oneDayInMiliSecond = 86400000;
    int daysInBetween = (int) ((date2.getTime() - date1.getTime()) / oneDayInMiliSecond);
    if ((date2.getTime() - date1.getTime()) % oneDayInMiliSecond != 0) {
      daysInBetween++;
    }
    System.out.println(daysInBetween);
    System.out.println(date1.getYear() + 1900);
    System.out.println(date2);

  }

}
