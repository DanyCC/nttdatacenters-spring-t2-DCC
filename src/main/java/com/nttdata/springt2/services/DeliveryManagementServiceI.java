package com.nttdata.springt2.services;

import com.nttdata.springt2.persistence.Order;
import com.nttdata.springt2.persistence.Product;

/**
 * Taller 2 - Spring
 *
 * Interfaz de los servicios de pedidos
 *
 * @author Daniel Alberto Cosa Cosias
 */

public interface DeliveryManagementServiceI {

    /**
     * Añade un producto a un pedido
     *
     * @param product
     * @param order
     */
    void addProduct(final Product product, final Order order);

    /**
     * Muestra los productos asociados al pedido
     *
     * @param order
     */
    void showProducts(final Order order);

    /**
     * Muestra el precio total del pedido, con y sin impuestos
     *
     * @param order
     */
    void showTotalPrice(final Order order);

    /**
     * Comprueba si un producto ya esta añadido a un pedido o no
     *
     * @param producto
     * @param order
     * @return
     */
    public boolean isProductInAnOrder(final Product producto, final Order order);
}
