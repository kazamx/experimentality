package experimentality.pruebatecnica.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import experimentality.pruebatecnica.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{

	//Obtiene los registros más buscados
    @Query(value = "SELECT * FROM productos WHERE buscados = 1", nativeQuery = true)
    public ArrayList<ProductoModel> obtenerBuscados();
    
    //Obtiene cantidad registros para poder determinar el id
    @Query(value = "SELECT CASE WHEN MAX(a.id) IS NULL THEN 0 ELSE MAX(a.id) END FROM productos a", nativeQuery = true)
    public int obtieneUltimoId();
}
