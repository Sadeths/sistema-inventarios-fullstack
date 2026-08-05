package st.inventarios.servicio;

import java.util.List;

import st.inventarios.modelo.Producto;

public interface IProductoServicio {
    List<Producto> listarProductos();

    Producto buscarProductoPorId(Integer idProducto);

    Producto guardarProducto(Producto producto);

    void eliminarProductoPorId(Integer idProducto);

}
