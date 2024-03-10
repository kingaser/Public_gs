package org.park.public_bpss;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PublicBpssApplication {

	public static void main(String[] args) throws ParseException {
		//SpringApplication.run(PublicBpssApplication.class, args);

		List<List<String>> alist = new ArrayList<List<String>>();
		BufferedReader br = null;

		try{
			br = Files.newBufferedReader(Paths.get("D:\\code\\test.csv"));
			String line = "";

			while((line=br.readLine())!=null){

				long day_pay = 0;
				long day_pay_add = 0;

				long day_min_pay = 1000;
				long day_max_pay = 36000;
				long day_pay_unit = 500;

				List<String> tmplist = new ArrayList<String>();
				String arr[] = line.split(",");
				tmplist = Arrays.asList(arr);
				System.out.println(tmplist);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date1 = sdf.parse(tmplist.get(1));
				Date date2 = sdf.parse(tmplist.get(2));

				long dateTime = (date2.getTime()-date1.getTime());

				//System.out.println(dateTime);

				day_pay = ((date2.getTime()-date1.getTime())/60000/4);
				day_pay_add = ((date2.getTime()-date1.getTime())/60000%5);		
				if(day_pay==0){		// 3분이하시 금액 0원
					day_pay = day_pay*0;
				}else if(day_pay<=2){
					day_pay = day_min_pay;
				}else if(day_pay_add==0 && day_pay>2 && 72>day_pay){
					day_pay = day_pay*day_pay_unit;
				}else if(day_pay_add>0 && day_pay>2 && 72>day_pay){
					day_pay = day_pay*day_pay_unit+day_pay_unit;
				}else if(72<day_pay){
					day_pay = day_max_pay;
				}else{
					day_pay=0;
				}
				//System.out.println(day_pay);

				alist.add(tmplist);
			}

		} catch (IOException e) {
			e.printStackTrace();
    }finally {
			try {
				if(br != null){
					br.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
  }

}
