package grow.user;

import java.io.Serializable;
import java.util.List;

public interface Dao<I extends Serializable, E> {
	  List<E> loadAll();
	  E findById(I id);
	  void save(E entity);
	  void remove(E entity);
	}