package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;


@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
	 Sucursal findSucursalByNomSucursal(String nomSucursal);
}
