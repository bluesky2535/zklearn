import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeekdayUtil {
 
	/**
	 * @title 判断两个日期是否在指定工作日内
	 * @detail (只计算周六和周日)
	 *          例如：前时间2008-12-05，后时间2008-12-11
	 * @author chanson
	 * @param beforeDate 前时间
	 * @param afterDate  后时间
	 * @param deadline 最多相隔时间
	 * @return 是的话，返回true，否则返回false
	 *
	 */
	static String[]  weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
	static int[]  intweekDays = {7,1,2,3,4,5,6};
	static String filePath="D:\\dim_day.txt";
	static FileOutputStream fos = null;
	static {
		try {
			fos = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
 
 
	public boolean compareWeekday(String beforeDate, String afterDate, int deadline) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = dataFormat.parse(beforeDate);
			Date d2 = dataFormat.parse(afterDate);
 
			//工作日
			int workDay = 0;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d1);
			// 两个日期相差的天数
			long time = d2.getTime() - d1.getTime();
			long day = time / 3600000 / 24 + 1;
			if(day < 0){
				//如果前日期大于后日期，将返回false
				return false;
			}
			for (int i = 0; i < day; i++) {
				if(DateUtils.isWorkday(gc)){
					workDay++;
					// System.out.println(dataFormat.format(gc.getTime())+"   工作日+DAY_OF_WEEK: " + weekDays[gc.get(Calendar.DAY_OF_WEEK)-1]);
					//buidWeekDayJson(dataFormat, gc,1);
					buidWeekDaySql(gc,1);
				} else{
					// buidWeekDayJson( dataFormat,gc,0);
					buidWeekDaySql(gc,0);
				}
				//往后加1天
				gc.add(GregorianCalendar.DATE, 1);
			}
			return workDay <= deadline;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	private void buidWeekDaySql(GregorianCalendar gc,int isWorkDay) {
 
		String day_key=DateUtils.formatDate(gc.getTime(), "yyyyMMdd");
		String date=DateUtils.formatDate(gc.getTime(), "yyyy-MM-dd");
 
 
		int  weekofday=intweekDays[gc.get(Calendar.DAY_OF_WEEK)-1];
		String  weekofday_name=weekDays[gc.get(Calendar.DAY_OF_WEEK)-1];
		int week=DateUtils.getWeekOfYear(gc.getTime());
 
		int season=DateUtils.getSeason(gc.getTime());
		int month=DateUtils.getMonth(gc.getTime());
		int year=DateUtils.getYear(gc.getTime());
		String month_yyyy_mm=null;
		String week_yyyy_ww=null;
		if(month<10){
			month_yyyy_mm=year+"-0"+month;
		}else{
			month_yyyy_mm=year+"-"+month;
		}
		if(week<10){
			week_yyyy_ww=year+"-0"+week;
		}else{
			week_yyyy_ww=year+"-"+week;
		}
 
		StringBuffer buffer=new StringBuffer(" INSERT INTO dim.dim_day_new "
				+ "(day_key,day,isworkday,week,week_name,weekofday,weekofday_name,month,month_name,season,season_name,year,year_name,month_yyyy_mm,week_yyyy_ww) VALUES ('");
		buffer.append(day_key).append("','"). append(date).append("','").
				append(isWorkDay).append("','").
				append(week).append("','").append("第"+week+"周").append("','").
				append(weekofday).append("','").append(weekofday_name).append("','").
				append(month).append("','").append(month+"月").append("','").
				append(season).append("','").append("第"+season+"季度").append("','").
				append(year).append("','").append(year+"年").append("','").
 
				append(month_yyyy_mm).append("','").append(week_yyyy_ww).append("');");
		try {
			fos.write(buffer.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println (buffer);
 
	}
 
 
	private void buidWeekDayJson(SimpleDateFormat dataFormat, GregorianCalendar gc,int isWeekday) {
		String date=dataFormat.format(gc.getTime());
		String week=weekDays[gc.get(Calendar.DAY_OF_WEEK)-1];
		StringBuffer buffer=new StringBuffer();
		int season=DateUtils.getSeason(gc.getTime());
		int month=DateUtils.getMonth(gc.getTime());
		buffer.append("{\"day\":\"").append(date).append("\",\"isworkday\":").append(isWeekday).
				append(",\"week\":\"").append(week).
				append("\",\"month\":").append(month).
				append(",\"season\":").append(season).
				append("}");
		System.out.println (buffer);
	}
	public static void main(String[] args) throws IOException {
 
		WeekdayUtil dateUtils = new WeekdayUtil();
//        FileOutputStream fos = new FileOutputStream(filePath);
		dateUtils.compareWeekday("2020-01-01", "2021-12-31", 10);
		fos.close();
 
 
	}
}
