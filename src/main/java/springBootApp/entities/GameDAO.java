package springBootApp.entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GameDAO extends CrudRepository<Game, Long> {
    //passed back out                passed in //
    List<Game> findByCategoryId(long categoryId);
   // List<Vendor> findByVendorId(long vendorId);

    @Query("SELECT g FROM Game g WHERE g.gameTitle LIKE ?1%")
    List<Game> findByNameStartsWith(String name);

    // Do i need to extend CrudRepository<Vendor, Long> ???????????  //
    //@Query("SELECT v FROM Vendor v WHERE v.vendorTitle LIKE ?1%")
    //List<Vendor> findByVendorStartsWith(String name);



}
