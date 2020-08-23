package com.collectionAssignmentAnswers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.Transaction;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Set s=Academy.studentMap.entrySet();
		Set s1=Academy.transactionMap.entrySet();
		
		for(int i=0;i<Academy.courseList.size();i++) {
			
			String coursename="";
			Date startdate= new Date();
			float totalstudents=0f;
			float totalrevenue=0f;
			float leftfees=0f;
			float projectedrevenue=0f;
			float percentage=0f;
			
			Course c=Academy.courseList.get(i);
			coursename=c.course_name;
			startdate=c.startDate;
			totalstudents=0;
			totalrevenue=0;
			
			Iterator itr=s.iterator();
			while(itr.hasNext()) {
				Map.Entry m=(Entry) itr.next();
				Integer id=(Integer) m.getKey();
				ArrayList<Student> al=(ArrayList<Student>) m.getValue();
				
				if(c.courseId==id) {
					totalstudents=al.size();
				}
			}
			
			projectedrevenue=c.courseFees*totalstudents;
			
			Iterator itr1=s1.iterator();
			
			while(itr1.hasNext()) {
				Map.Entry m1=(Entry) itr1.next();
				Integer id1=(Integer) m1.getKey();
				ArrayList<Transaction> al1= new ArrayList<>();
				
				if(id1==c.courseId) {
					
					for(int j=0;j<al1.size();j++) {
						Transaction t=al1.get(j);
						totalrevenue=totalrevenue+t.paidfees;
					}
				}
				
				
			}
			
			leftfees=projectedrevenue-totalrevenue;
			percentage=(totalrevenue/projectedrevenue)*100;
			
			System.out.println(coursename);
			System.out.println(startdate);
			System.out.println(totalstudents);
			System.out.println(totalrevenue);
			System.out.println(leftfees);
			System.out.println(projectedrevenue);
			System.out.println(percentage);
			
			
		}
		

		
		

	}

}
