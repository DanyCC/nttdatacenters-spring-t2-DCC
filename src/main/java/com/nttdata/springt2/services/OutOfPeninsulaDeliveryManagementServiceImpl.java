package com.nttdata.springt2.services;

import com.nttdata.springt2.persistence.Order;
import com.nttdata.springt2.persistence.Product;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * Taller 2 - Spring
 *
 * Servicio encargado de los servicios de fuera de la peninsula
 *
 * @author Daniel Alberto Cosa Cosias
 */

@Service
public class OutOfPeninsulaDeliveryManagementServiceImpl implements DeliveryManagementServiceI {

    /**String con mensaje de error (Soluciona un aviso de SonarLint)*/
    private String inPeninsulaErrorMessage = "Esta usted utilizando el servicio encargado de fuera de la peninsula con un pedido en esta, " +
            "utilize el servicio 'PeninsulaDeliveryManagementServiceImpl'";
    @Override
    public void addProduct(Product product, Order order) {
        //Se comprueba que el pedido este fuera de la peninsula, que la lista de productos no sea nula y que el producto no este asociado a otro pedido
        if (!order.isInPeninsula()){
            if (order.getProducts() != null) {
                if (!isProductInAnOrder(product, order)){
                    //Se añade el producto al pedido y este se asocia
                    order.getProducts().add(product);
                    product.setAssociatedOrder(order);
                }
            } else {
                System.out.println("La lista no se encuentra instanciada");
            }
        } else {
            System.out.println(inPeninsulaErrorMessage);
        }
    }

    @Override
    public void showProducts(Order order) {
        //Se comprueba que el pedido no este en la peninsula
        if (!order.isInPeninsula()){
            System.out.println("Productos asociados al pedido de " + order.getRecipient() + ":");
            //Se recorre la lista
            for (Product product : order.getProducts()) {
                //Se le aplica el IPSI al producto y se imprime
                product.setPvpPrice(product.getNoTaxesPrice() + (product.getNoTaxesPrice() * 0.04f));
                System.out.println(product.toString());
            }
        } else {
            System.out.println(inPeninsulaErrorMessage);
        }
    }

    @Override
    public void showTotalPrice(Order order) {
        //Se comprueba que el pedido no este en la peninsula
        if (!order.isInPeninsula()){
            //DecimalFormat para mostrar el precio de la siguiente manera "E,CC"
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            //Se crean dos variables que almacenaran los precios
            float totalPriceNoTaxes = 0;
            float totalPrice = 0;
            System.out.println("Precios asociados al pedido de " + order.getRecipient() + ":");
            //Se recorre la lista
            for (Product product : order.getProducts()) {
                //Se le añade el IVA a los productos y se almacenan en las variables
                product.setPvpPrice(product.getNoTaxesPrice() + (product.getNoTaxesPrice() * 0.04f));
                totalPrice += product.getPvpPrice();
                totalPriceNoTaxes += product.getNoTaxesPrice();
            }
            //Se imprimen los precios
            System.out.println("Precio sin impuestos: " + df.format(totalPriceNoTaxes));
            System.out.println("Precio PVP: " + df.format(totalPrice));
        } else {
            System.out.println(inPeninsulaErrorMessage);
        }
    }

    @Override
    public boolean isProductInAnOrder(Product producto, Order order) {
        //Si el pedido asociado no es nulo y no es el pedido al que se va a insertar devuelve verdadero
        if (producto.getAssociatedOrder()!=null && !producto.getAssociatedOrder().getOrderID().equals(order.getOrderID())) {
            System.out.println("El producto ya esta asociado a otro pedido");
            return true;
        }
        //Si no se devuelve falso
        return false;
    }
}
