package entities;

/**
 * Created by Alexandra on 2/5/2017.
 */

public class myCalendar {
   /* private int year;
    private int month;
    private int day;
    private int weekday;
    private String[] monthName = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private int[] MonthDays=new int[12];
    Calendar cal = Calendar.getInstance();

    void myCalendar(){}

    public void init(){
        Calendar cal = Calendar.getInstance();
        year=cal.get(Calendar.YEAR);
        month=cal.get(Calendar.MONTH);
        day=cal.get(Calendar.DAY_OF_MONTH);
        weekday = cal.get(Calendar.DAY_OF_WEEK);
        MonthDays[0]=31;MonthDays[2]=31;MonthDays[3]=30;MonthDays[4]=31;MonthDays[5]=30;MonthDays[6]=31;MonthDays[7]=30;
        MonthDays[8]=30;MonthDays[9]=31;MonthDays[10]=30;MonthDays[11]=31;
        if( (year%4==0 && year%100!=0) || year%400==0) MonthDays[1]=29; else MonthDays[1]=28;
    }

    public int firstDayOfMonth(int y, int m){
        Calendar c = Calendar.getInstance();
        c.set(y, m, 0);
        return c.get(Calendar.DAY_OF_WEEK-1);
    }

    public int firstDayOfMonth(){
        myCalendar c = myCalendar.getInstance();
        c.set(year, month, 0);
        return c.get(Calendar.DAY_OF_WEEK)-1;
    }


    public String getMonthName(int m){
        return monthName[m];
    }

    public String getMonthName(){ return monthName[month];  }

    public int getMonthDays(){ return MonthDays[month]; }

    public int getMonthDays(int m){ return MonthDays[m];    }

    public int[] getMonthDaysOfAnyYear(int y){
        int[] MonthDays2=new int[11];
        MonthDays2[0]=31;MonthDays2[2]=31;MonthDays2[3]=30;MonthDays2[4]=31;MonthDays2[5]=30;MonthDays2[6]=31;MonthDays2[7]=30;
        MonthDays2[8]=30;MonthDays2[9]=31;MonthDays2[10]=30;MonthDays2[11]=31;
        if( (y%4==0 && y%100!=0) || y%400==0) MonthDays2[1]=29; else MonthDays2[1]=28;
        return MonthDays2;
    }

    public int getPrevMonthDays(int m){
        int newMonth=m-1;
        if(newMonth==-1){
            return 31;
        }
        else return MonthDays[newMonth];
    }

    public int getPrevMonthDays(){
        int newMonth=month-1;
        if(newMonth==-1){
            return 31;
        }
        else return MonthDays[newMonth];
    }

    public String prevMonth(){
        month--;
        if(month==-1){
            year--;
            month=11;
        }
        return monthName[month];

    }


    void test(){}
*/
}
