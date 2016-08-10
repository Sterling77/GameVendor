package springBootApp.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Letricia on 8/10/16.
 */
@Transactional
public interface VendorDAO extends CrudRepository<Vendor, Long> {
}
