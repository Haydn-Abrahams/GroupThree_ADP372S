/** IService.java
 *  This sets the basic CRUD functionality
 *  Andrea Jacobs 218024266
 *  27 June 2023 */

package za.ac.cput.service;

public interface IService<T, ID>{
    T create (T t);
    T read (ID id);
    T update (T t);
    boolean delete(ID id);
}
