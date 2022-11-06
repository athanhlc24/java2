package assigment1.dao.impls;

import assigment1.database.Connector;
import assigment1.entities.Book;
import assigment1.entities.Student;
import assigment1.dao.inerfaces.IRepository;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements IRepository<Student> {
    @Override
    public ArrayList<Student> all() {
        ArrayList<Student> ls = new ArrayList<>();
        try {
            String sql_txt= "select * from student";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");

                Student s = new Student(id,name,email,tel);
                ls.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Student student) {
        try {
            String sql_txt = "insert into student(name,email,tel) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getTel());
            if (conn.excute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        try{
        String sql_txt = "update student set name=?, email=?, tel=? where id=?";
        Connector conn = Connector.getInstance();
        ArrayList arr = new ArrayList<>();
        arr.add(student.getName());
        arr.add(student.getEmail());
        arr.add(student.getTel());
        arr.add(student.getId());
        if (conn.excute(sql_txt,arr)){
            return true;
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        try{
            String sql_txt = "delete from student where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(student.getId());
            if (conn.excute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Student findOne(Integer id) {
        try {
            String sql_txt = "select * from student where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(id);
            ResultSet rs = conn.excuteQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel =  rs.getString("tel");

                return new Student(Id,name,email,tel);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
