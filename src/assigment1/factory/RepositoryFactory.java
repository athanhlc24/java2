package assigment1.factory;

import assigment1.enums.RepoType;
import dao.impls.BookRentRepository;
import dao.impls.BookRepository;
import dao.impls.StudentRepository;
import dao.inerfaces.IRepository;

public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static IRepository createRepository(RepoType type){
        switch (type){
            case BOOK: return new BookRepository();
            case BOOKRENT:return new BookRentRepository();
            case STUDENT:return new StudentRepository();
            default: throw  new IllegalArgumentException("Thiếu tham số rồi");
        }
    }
}
