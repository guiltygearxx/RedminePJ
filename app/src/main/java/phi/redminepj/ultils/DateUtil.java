package phi.redminepj.ultils;

import android.content.Context;
import android.support.design.BuildConfig;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
    private static DateFormat dateFormat;
    private static char[] dateFormatOrder;
    private static final DateUtil instance;
    private static DateFormat longDateFormat;
    private static DateFormat mediumDateFormat;
    private static DateFormat simpleDateFormat;
    private static DateFormat simpleDatetimeGMTFormat;
    private static DateFormat timeFormat;

    public static class DateIntervalResult {
        private FieldType fieldType;
        private long time;

        public enum FieldType {
            FIELD_TYPE_YEAR,
            FIELD_TYPE_DATE,
            FIELD_TYPE_HOUR,
            FIELD_TYPE_MINUTE
        }

        public long getTime() {
            return this.time;
        }

        public FieldType getFieldType() {
            return this.fieldType;
        }
    }

    static {
        instance = new DateUtil();
    }

    public DateUtil() {
    }

    public static DateUtil getInstance(Context context) {
        if (dateFormat == null || timeFormat == null) {
            dateFormat = android.text.format.DateFormat.getDateFormat(context);
            timeFormat = android.text.format.DateFormat.getTimeFormat(context);
            mediumDateFormat = android.text.format.DateFormat.getMediumDateFormat(context);
            longDateFormat = android.text.format.DateFormat.getLongDateFormat(context);
            dateFormatOrder = android.text.format.DateFormat.getDateFormatOrder(context);
            simpleDatetimeGMTFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            simpleDatetimeGMTFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setTimeZone(TimeZone.getDefault());
            timeFormat.setTimeZone(TimeZone.getDefault());
            mediumDateFormat.setTimeZone(TimeZone.getDefault());
            longDateFormat.setTimeZone(TimeZone.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        return instance;
    }

    public String parseToString(Date date) {
        return simpleDateFormat.format(date);
    }

    public Date convertToDate(String dateString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return convertedDate;
    }

    public Date parseToDate(String date) {
        if (date == null) {
            return null;
        }
        try {
            date = date.replace("/", "-");
            if (date.indexOf("Z") <= 0) {
                return simpleDateFormat.parse(date);
            }
            Matcher matcher = Pattern.compile("^(.+T.+)\\.[0-9]{3}Z$").matcher(date);
            if (matcher.find()) {
                date = matcher.group(1) + "Z";
            }
            return simpleDatetimeGMTFormat.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getDateTimeMinute() {
        return getDateTimeMinute(new Date());
    }

    public String getDateTimeMinute(Date date) {
        return dateFormat.format(date) + " " + timeFormat.format(date);
    }

    public String getDate() {
        return getDate(new Date());
    }

    public String getDate(Date date) {
        if (date == null) {
            return BuildConfig.VERSION_NAME;
        }
        return dateFormat.format(date);
    }

    public DateIntervalResult getDateInterval(Date d) {
        DateIntervalResult res = new DateIntervalResult();
        long minutes = (new Date().getTime() - d.getTime()) / 60000;
        long hours = minutes / 60;
        long days = hours / 24;
        long years = days / 365;
        if (years >= 1 || years <= -1) {
            res.time = years;
            res.fieldType = DateIntervalResult.FieldType.FIELD_TYPE_YEAR;
        } else if (days >= 1 || days <= -1) {
            res.time = days;
            res.fieldType = DateIntervalResult.FieldType.FIELD_TYPE_DATE;
        } else if (hours >= 1 || hours <= -1) {
            res.time = hours;
            res.fieldType = DateIntervalResult.FieldType.FIELD_TYPE_HOUR;
        } else if (minutes > 1 || minutes < -1) {
            res.time = minutes;
            res.fieldType = DateIntervalResult.FieldType.FIELD_TYPE_MINUTE;
        } else {
            res.time = 1;
            res.fieldType = DateIntervalResult.FieldType.FIELD_TYPE_MINUTE;
        }
        return res;
    }


}
