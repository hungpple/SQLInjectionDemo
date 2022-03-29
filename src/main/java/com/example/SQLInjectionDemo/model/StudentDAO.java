package com.example.SQLInjectionDemo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;



public class StudentDAO implements IStudentDAO{
	Student student1 = new Student(1, "Sebastian Knist", "sebastian.k@gmail.com","123 Whitehorse Rd", "10/10");
	Student student2 = new Student(2, "Vincent Corleone", "nextgfather@gmail.com","345 Bourke St", "11/10");
	Student student3 = new Student(3, "Glenn Talbot", "bg.talbot@gmail.com","23 La Trobe St", "12/10");
    private JdbcTemplate jdbcTemplate;
	private List<Student> students = new ArrayList<Student>();
	
	public StudentDAO (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//JPA
	
	@Override
	public List < Student > getStudents(){
		/*
		 * List<Student> student_list = students; return student_list;
		 */
    	String sql = "SELECT * FROM student";
    	List < Student > listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Student aStudent = new Student();
     
            	aStudent.setId(rs.getInt("id"));
            	aStudent.setName(rs.getString("name"));
            	aStudent.setEmail(rs.getString("email"));
            	aStudent.setAddress(rs.getString("address"));
            	aStudent.setEnrolledclass(rs.getString("enrolledclass"));
     
                return aStudent;
            }
        });
        return listStudent;
    }

	

	@Override
	public List<Student> getStudentById(String id){
//		int sID = Integer.parseInt(id); 
		String sql = "SELECT * FROM student WHERE id='" + id +"'";
    	List < Student > listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Student aStudent = new Student();
     
            	aStudent.setId(rs.getInt("id"));
            	aStudent.setName(rs.getString("name"));
            	aStudent.setEmail(rs.getString("email"));
            	aStudent.setAddress(rs.getString("address"));
            	aStudent.setEnrolledclass(rs.getString("enrolledclass"));
     
                return aStudent;
            }
        });
        return listStudent;
//		return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
//		Student aStudent = new Student();
//            @Override
//            public Student extractData(ResultSet rs) throws SQLException,
//            		DataAccessException {
//            	if (rs.next()) {
//                	aStudent.setId(rs.getInt("id"));
//                	aStudent.setName(rs.getString("name"));
//                	aStudent.setEmail(rs.getString("email"));
//                	aStudent.setAddress(rs.getString("address"));
//                	aStudent.setEnrolledclass(rs.getString("enrolledclass"));
//                    return aStudent;
//                }
//            	return null;
//            }
     
    }

	
	
	@Override
	public int updateStudent(Student student) {
		if (student.getId() > 0) {
	        String sql = "UPDATE student SET name=?, email=?, address=?, "
	                + "enrolledclass=? WHERE id=?";
	        return jdbcTemplate.update(sql, student.getName(), student.getEmail(),
	        		student.getAddress(), student.getEnrolledclass(), student.getId());
		}
		return 0;
    }
	 
	@Override
	public int addStudent(Student student) {
		 // insert
		  String sql = "INSERT INTO student (name, email, address, enrolledclass) VALUES ('" + student.getName() + "', '" + student.getEmail() + "','" + student.getAddress() + "','" + student.getEnrolledclass() + "')";
		  return jdbcTemplate.update(sql);
		  //        String sql = "INSERT INTO student (name, email, address, enrolledclass)"
//                    + " VALUES (?, ?, ?, ?)";
//        return jdbcTemplate.update(sql, student.getName(), student.getEmail(),
//        		student.getAddress(), student.getEnrolledclass());
    	
        //students.add(student);
    }

	@Override
	public int deleteStudent(int id) {
	    String sql = "DELETE FROM student WHERE id=?";
	    return jdbcTemplate.update(sql, id);  	
    }
}
