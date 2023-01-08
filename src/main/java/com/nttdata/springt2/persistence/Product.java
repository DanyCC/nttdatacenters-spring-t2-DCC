package com.nttdata.springt2.persistence;

import java.io.Serial;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Taller 2 - Spring
 *
 * Clase Product
 *
 * @author Daniel Alberto Cosa Cosias
 */

public class Product implements Serializable {

    /**Serial Version*/
    @Serial
    private static final long serialVersionUID = 1L;

    /**ID de producto (PK)*/
    private Long productID;

    /**Nombre del producto*/
    private String productName;

    /**Precio PVP*/
    private float pvpPrice;

    /**Precio sin impuestos*/
    private float noTaxesPrice;

    /**Pedido asociado*/
    private Order associatedOrder;

    /**Metodo Constructor*/
    public Product(Long productID, String productName, float noTaxesPrice) {
        setProductID(productID);
        setProductName(productName);
        setNoTaxesPrice(noTaxesPrice);
    }

    /**
     *
     * @return Long productID
     */
    public Long getProductID() {
        return productID;
    }

    /**
     *
     * @param productID Long productID to set
     */
    public void setProductID(Long productID) {
        this.productID = productID;
    }

    /**
     *
     * @return String productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName String productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return float pvpPrice
     */
    public float getPvpPrice() {
        return pvpPrice;
    }

    /**
     *
     * @param pvpPrice float pvpPrice to set
     */
    public void setPvpPrice(float pvpPrice) {
        this.pvpPrice = pvpPrice;
    }

    /**
     *
     * @return float noTaxesPrice
     */
    public float getNoTaxesPrice() {
        return noTaxesPrice;
    }

    /**
     *
     * @param noTaxesPrice float noTaxesPrice to set
     */
    public void setNoTaxesPrice(float noTaxesPrice) {
        this.noTaxesPrice = noTaxesPrice;
    }

    /**
     *
     * @return Order associatedOrder
     */
    public Order getAssociatedOrder() {
        return associatedOrder;
    }

    /**
     *
     * @param associatedOrder Order associatedOrder to set
     */
    public void setAssociatedOrder(Order associatedOrder) {
        this.associatedOrder = associatedOrder;
    }

    /**Metodo toString*/
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        return "Product{" +
                "ID de producto = " + productID +
                ", Nombre de Producto = '" + productName + '\'' +
                ", Precio PVP = " + df.format(pvpPrice) +
                ", Precio sin impuestos = " + df.format(noTaxesPrice) +
                ", Pedido asociado = " + associatedOrder.getOrderID() +
                '}';
    }
}
