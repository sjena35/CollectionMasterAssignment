package com.collectionAssignmentAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import master_assignment.bean.Academy;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		Set s=Academy.studentMap.entrySet();
		Set s1=Academy.test_map.entrySet();
		
		for(int i=0;i<Academy.courseList.size();i++) {
			ArrayList<Student> stud= new ArrayList<>();
			ArrayList<TestResult> test= new ArrayList<>();
			int cid=Academy.courseList.get(i).courseId;
			
			Iterator itr=s.iterator();
			
			while(itr.hasNext()) {
				Map.Entry m=(Entry) itr.next();
				Integer cid1=(Integer) m.getKey();
				if(cid==cid1) {
					stud=(ArrayList<Student>) m.getValue();
					Collections.sort(stud, new StudentComparator());
					break;
				}
			}
			
			for(int j=0;j<stud.size();j++) {
				int sid=stud.get(j).getStudent_id();
				
				Iterator itr1=s1.iterator();
				
				while(itr1.hasNext()) {
					Map.Entry m1=(Entry) itr.next();
					Integer cid2=(Integer) m1.getKey();
					
					if(cid2==cid) {
						ArrayList<TestResult> al1= (ArrayList<TestResult>) m1.getValue();
						
						for(int k=0;k<al1.size();k++) {
							int sid1=al1.get(k).studentId;
							if(sid1==sid) {
								test.add(al1.get(k));
								break;
							}
						}
					}
				}
				
				
			}
			
			Collections.sort(test,new markscomparator());
			System.out.println(cid);
			System.out.println(test);
		}
		
	}

}

class markscomparator implements Comparator<TestResult>{

	@Override
	public int compare(TestResult o1, TestResult o2) {
		
			return o2.marks-o1.marks;
	
}
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getstudent_name().compareTo(o2.getstudent_name());
	}
}
	

