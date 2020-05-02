package webgroup.iihtCRUDproj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CRUDOperationController {
	List <Student> student;
	
	@RequestMapping(value="/init")
	@ResponseBody
	public void init(){
		student =createStudentList();
	}
	
	@RequestMapping(value="/studentss", method= RequestMethod.GET,headers="Accept=application/json")
	public List getStudents(){
		List listOfStudents=new ArrayList();
		listOfStudents=createStudentList();
		return listOfStudents;
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Student getCountryById(@PathVariable int id)
	{
		List<Student> listOfStudents = new ArrayList();
		listOfStudents=createStudentList();
 
		for (Student student: listOfStudents) {
			if(student.getStudentId()==id)
				return student;
		}
 
		return null;
	}
	
	@RequestMapping(value="/students",method=RequestMethod.POST)
	@ResponseBody
	public String getStudents(@RequestParam Integer classID){
		return student.get(classID - 1).toString();
	}
	
	@RequestMapping(value="/students",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteStudents(@RequestParam Integer classID){
		student.remove(classID - 1);
		System.out.print(student);
	}
	
	@RequestMapping(value="/students",method=RequestMethod.PUT)
	@ResponseBody
	public void putStudents(@RequestParam Integer classID,@RequestParam String StudentName){
		Student stud;
		if(classID > student.size()-1){
			stud=new Student(classID,StudentName,"JAVA");
			student.add(stud);			}
		else{
			Student num=student.get(classID-1);
			num.setStudentName(StudentName);
			student.add(num);
		}
		System.out.print(student);
	}
	
	
	
	public List createStudentList(){
		Student student2=new Student(1,"Anu","JAVA");
		Student student1=new Student(2,"Nagu","PYTHON");
		List listOfStudents=new ArrayList();
		listOfStudents.add(student2);
		listOfStudents.add(student1);
		/*student.add(student1);
		student.add(student2);*/
		return listOfStudents;
	}
}
