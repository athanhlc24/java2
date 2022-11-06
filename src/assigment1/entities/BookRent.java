package assigment1.entities;

import assigment1.dao.impls.StudentRepository;
import assigment1.enums.RepoType;
import assigment1.factory.RepositoryFactory;
import assigment1.dao.impls.BookRepository;

import java.sql.Date;

public class BookRent {
    private Integer id;
    private Integer bookId;
    private Integer studentId;
    private Date rentDate;
    private Date expiredDate;
    private Integer status;

    private String bookName;
    private String studentName;
    private String statusLabel;

    public BookRent() {
    }

    public BookRent(Integer bookId, Integer studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }

    public BookRent(Integer id, Integer bookId, Integer studentId, Date rentDate, Date expiredDate, Integer status) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.rentDate = rentDate;
        this.expiredDate = expiredDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookName() {
//        System.out.println(this.book());
        return this.book().getName() ;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStatusLabel() {
        return status==0?"Chưa trả":"Đã trả";
    }

    public String getStudentName() {
        return this.student().getName();
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Book book(){
      return ((BookRepository)RepositoryFactory.createRepository(RepoType.BOOK)).findOne(this.getBookId());
//        BookRepository br =new BookRepository();
//        Book b = br.findOne(this.bookId);
//        return b;
    }
    public Student student(){
        return ((StudentRepository)RepositoryFactory.createRepository(RepoType.STUDENT)).findOne(this.getBookId());
//        BookRepository br =new BookRepository();
//        Book b = br.findOne(this.bookId);
//        return b;
    }
}