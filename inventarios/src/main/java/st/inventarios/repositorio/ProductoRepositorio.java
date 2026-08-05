package st.inventarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import st.inventarios.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
