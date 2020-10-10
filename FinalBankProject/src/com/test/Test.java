package com.test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.TimeUnit;

public class Test {

	public static String returnDate(String date) {
		String sDate[] = date.split("-");
		String respoDate= sDate[2]+","+sDate[1]+","+sDate[0];
		
		return respoDate;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start_date = "2018-07-15";
		String end_date = "2022-07-15";
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		try {
			//System.out.println("*******"+df.parse(start_date));
		 
		/*java.util.Date date1= df.parse(start_date); 
		//System.out.println(date1);
		java.util.Date date2= new SimpleDateFormat("YYYY-MM-DD").parse(end_date); 
		
		//System.out.println(date1);
		//System.out.println(date2);
		long strDate = date1.getTime();
		long eDate = date2.getTime();
		
		long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    
	    System.out.println("$$$$$$$$$$$$$$$$$$$$$$%%$$$$$$$$$$$$$$"+diff);
		
		int diffInDays = (int) (diff / (1000 * 60 * 60 * 24) );
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+diffInDays);*/
			/*
			 * 
			 * LocalDate endofCentury = LocalDate.of(Integer.parseInt(start_date.split(",")[0]),Integer.parseInt(start_date.split(",")[1]),Integer.parseInt(start_date.split(",")[2]));
			//LocalDate LocalDate endofCentury = LocalDate.of(Integer.parseInt(start_date.split(",")[0]),Integer.parseInt(start_date.split(",")[1]),Integer.parseInt(start_date.split(",")[2])); = LocalDate.now();//
			
			LocalDate now = LocalDate.of(Integer.parseInt(end_date.split(",")[0]),Integer.parseInt(end_date.split(",")[1]),Integer.parseInt(end_date.split(",")[2]));
			Period diff = Period.between(endofCentury, now);
			 
			 * 
			 */
			
			int eDateYear = Integer.parseInt(end_date.split("-")[0]);
			int eDateMonth = Integer.parseInt(end_date.split("-")[1]);
			int eDateDay = Integer.parseInt(end_date.split("-")[2]);
			int sDateYear = Integer.parseInt(start_date.split("-")[0]);
			int sDateMonth = Integer.parseInt(start_date.split("-")[1]);
			int sDateDay = Integer.parseInt(start_date.split("-")[2]);
			
			LocalDate endofCentury = LocalDate.of(eDateYear, eDateMonth, eDateDay);
			LocalDate now = LocalDate.of(sDateYear, sDateMonth, sDateDay);
			//LocalDate now = LocalDate.now();
			System.out.println(sDateYear +":"+eDateYear);
			 System.out.println(now+":"+endofCentury);
			Period diff = Period.between(now,endofCentury);
			double principle=10000;
			 double roi;
			System.out.printf("Difference is %d years, %d months and %d days ",
			                    diff.getYears(), diff.getMonths(), diff.getDays());
			if(diff.getMonths()<=12 && diff.getYears()==0) {
				 roi=0.06;
			}
			else if(diff.getYears()<=2) {
				roi=0.07;
			}
			else {
				roi=0.08;
			}
			double time=diff.getYears()+(0.08*diff.getMonths());
			double maturityamount;
			double temp=(1+roi);
	        maturityamount=principle*Math.pow(temp,(time));
	        System.out.println("Fixed deposit: "+ maturityamount);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
