package com.collectionAssignmentAnswers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.Transaction;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedHashMap<Integer, ArrayList<Student>> paidstud=new LinkedHashMap<>();
		
		Set s=Academy.transactionMap.entrySet();
		Set s1 =Academy.studentMap.entrySet();
		
		
		for(int i=0;i<Academy.courseList.size();i++) {
			Course c=Academy.courseList.get(i);
			int cid=c.courseId;
			int cfees=c.courseFees;
			ArrayList<Student> stud= new ArrayList<>();
			
			Iterator itr=s.iterator();
			while(itr.hasNext()) {
				
				Map.Entry m=(Entry) itr.next();
				Integer id=(Integer) m.getKey();
				ArrayList<Transaction> al=(ArrayList<Transaction>) m.getValue();
				
				if(cid==id) {
					
					for(int j=0;j<al.size();j++) {
						Transaction t=al.get(j);
						int amount=t.paidfees;
						int sid=t.studId;
						for(int k=j+1;k<al.size();k++) {
							if(al.get(k).studId==sid) {
								amount=amount+al.get(k).paidfees;
								al.remove(k);
								k--;
							}
						}
						
						if(cfees==amount) {
							
							Iterator itr1=s1.iterator();
							
							while(itr1.hasNext()) {
								Map.Entry m1=(Entry) itr.next();
								int cid1=(int) m1.getKey();
								ArrayList<Student> al1= (ArrayList<Student>) m1.getValue();
								
								if(cid1==id) {
									
									for(int p=0;p<al1.size();p++) {
										if(al1.get(p).getStudent_id()==sid) {
											stud.add(al1.get(p));
										}
									}
								}
							}
						}
						
						
					}
				}
			}
			
			paidstud.put(cid, stud);
			
			
		}

	}

}
