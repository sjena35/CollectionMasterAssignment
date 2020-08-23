package com.collectionAssignmentAnswers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		Set s=Academy.test_map.entrySet();
		Iterator itr=s.iterator();
		
		while(itr.hasNext()) {
			ArrayList<Integer> poorStudents= new ArrayList<>();
			Map.Entry m=(Entry) itr.next();
			Integer id1=(Integer) m.getKey();
			ArrayList<TestResult> al=(ArrayList<TestResult>) m.getValue();
			
			for(int i=0;i<al.size();i++) {
				int id=al.get(i).studentId;
				float mark=al.get(i).marks;
				float totalmarks=al.get(i).out_of_marks;
				
				float percentage=(mark/totalmarks)*100;
				
				if(percentage<40) {
					poorStudents.add(id);
				}
			}
			
			System.out.println(id1);
			
			System.out.println(poorStudents);
		}
		
		

	}

}
