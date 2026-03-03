package Session16.Thuc_hanh;

import java.util.List;

public interface IRepository<T> {
    boolean add(T item);
    boolean removeById(String id);
    T findById(String id);
    List<T> findAll();
}
