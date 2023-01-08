package com.nttdata.springt2;

import com.nttdata.springt2.persistence.Order;
import com.nttdata.springt2.persistence.Product;
import com.nttdata.springt2.services.OutOfPeninsulaDeliveryManagementServiceImpl;
import com.nttdata.springt2.services.PeninsulaDeliveryManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;

/**
 * Taller 2 - Spring
 *
 * Clase Main
 *
 * @author Daniel Alberto Cosa Cosias
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NttdatacentersSpringT2DccApplication implements CommandLineRunner {

    //Servicios que se consumiran
    @Autowired
    private PeninsulaDeliveryManagementServiceImpl peninsulaService;

    @Autowired
    private OutOfPeninsulaDeliveryManagementServiceImpl outOfPeninsulaService;

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersSpringT2DccApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        //Creacion de productos
        Product producto1 = new Product(1L, "Ruffles Sabor Jamon", 1.75f);
        Product producto2 = new Product(2L, "Jumpers", 0.5f);
        Product producto3 = new Product(3L, "Filipinos", 1.2f);
        Product producto4 = new Product(4L, "Snickers", 1f);

        //Creacion de pedidos
        Order pedido1 = new Order(1L, "Daniel Cosa", "Av. Altamira, N.29, Bl.3, 4D, Sevilla", true, new ArrayList<>());
        Order pedido2 = new Order(2L, "Juan Alejandro Tellez", "Calle almirantazgo, N.14, 6A, Santa Cruz de Tenerife", false, new ArrayList<>());

        //Consumicion del servicio y sus metodos
        peninsulaService.addProduct(producto1, pedido1);
        peninsulaService.addProduct(producto1, pedido1);
        peninsulaService.addProduct(producto2, pedido1);
        peninsulaService.addProduct(producto1, pedido1);
        outOfPeninsulaService.addProduct(producto3, pedido2);
        outOfPeninsulaService.addProduct(producto4, pedido2);
        outOfPeninsulaService.addProduct(producto4, pedido2);

        peninsulaService.showProducts(pedido1);
        peninsulaService.showTotalPrice(pedido1);
        outOfPeninsulaService.showProducts(pedido2);
        outOfPeninsulaService.showTotalPrice(pedido2);
    }
}
