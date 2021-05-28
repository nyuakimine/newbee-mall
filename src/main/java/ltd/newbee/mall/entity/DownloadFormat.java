package ltd.newbee.mall.entity;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DownloadFormat {

 private Integer[] ids;
 private String format;
 
public Integer[] getIds() {
    return ids;
}
public void setIds(Integer[] ids) {
    this.ids = ids;
}
public String getFormat() {
    return format;
}
public void setFormat(String format) {
    this.format = format;
}
@Override
public String toString() {
    return "DownloadFormat [ids=" + Arrays.toString(ids) + ", format=" + format + "]";
}

}