package assigment1.factory;

import assigment1.enums.RepoType;
import assigment1.dao.impls.BookRentRepository;
import assigment1.dao.impls.BookRepository;
import assigment1.dao.impls.StudentRepository;
import assigment1.dao.inerfaces.IRepository;

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
