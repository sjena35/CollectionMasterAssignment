package com.collectionAssignmentAnswers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import master_assignment.bean.*;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method st
		
		int max=0;
		int course=0;
		
		Set<Entry<Integer, List<Student>>> s=Academy.studentMap.entrySet();
		Iterator<Entry<Integer, List<Student>>> itr=s.iterator();
		
		while(itr.hasNext()) {
			Map.Entry m=(Entry) itr.next();
			Integer id=(Integer) m.getKey();
			ArrayList<Student> al=(ArrayList<Student>) m.getValue();
			
			if(al.size()>max) {
				max=al.size();
				course=id;
			}
		}
		
		System.out.println(course);

	}

}
