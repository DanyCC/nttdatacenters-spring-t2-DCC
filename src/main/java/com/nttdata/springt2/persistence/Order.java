package com.nttdata.springt2.persistence;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Taller 2 - Spring
 *
 * Clase Order
 *
 * @author Daniel Alberto Cosa Cosias
 */

public class Order implements Serializable {

    /**Serial Version*/
    @Serial
    private static final long serialVersionUID = 1L;

    /**ID de pedido (PK)*/
    private Long orderID;

    /**Destinatario*/
    private String recipient;

    /**Direcccion de envio*/
    private String deliveryAddress;

    /**Comprobador de localizacion en la peninsula*/
    private boolean inPeninsula;

    /**Lista de productos asociada*/
    private List<Product> products;

    /**Metodo Constructor*/
    public Order(Long orderID, String recipient, String deliveryAddress, boolean inPeninsula, List<Product> products) {
        setOrderID(orderID);
        setRecipient(recipient);
        setDeliveryAddress(deliveryAddress);
        setInPeninsula(inPeninsula);
        setProducts(products);
    }

    /**
     * @return Long orderID
     */
    public Long getOrderID() {
        return orderID;
    }

    /**
     *
     * @param orderID Long orderID to set
     */
    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    /**
     * @return String recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     *
     * @param recipient String recipient to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @return String deliveryAddress
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     *
     * @param deliveryAddress String deliveryAddress to set
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * @return boolean inPeninsula
     */
    public boolean isInPeninsula() {
        return inPeninsula;
    }

    /**
     *
     * @param inPeninsula boolean inPeninsula to set
     */
    public void setInPeninsula(boolean inPeninsula) {
        this.inPeninsula = inPeninsula;
    }

    /**
     * @return List<Product> products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     *
     * @param products List<Product> products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**Metodo toString*/
    @Override
    public String toString() {
        return "Order{" +
                "ID de pedido = " + orderID +
                ", Destinatario = '" + recipient + '\'' +
                ", Direccion de envio = '" + deliveryAddress + '\'' +
                ", Esta en la peninsula = " + inPeninsula +
                ", Productos = " + products +
                '}';
    }
}
