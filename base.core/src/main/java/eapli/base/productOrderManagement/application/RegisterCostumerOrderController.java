package eapli.base.productOrderManagement.application;


import eapli.base.costumermanagement.domain.Address;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.application.ProductServices;
import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;

import eapli.base.productOrderManagement.domain.Item;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.domain.Shipment;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.*;

/**
 * The type Register costumer order controller.
 */
public class RegisterCostumerOrderController {

    private final CostumerRepository costumerRepository = PersistenceContext.repositories().costumerRepository();
    private ProductServices productServices = new ProductServices();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private Costumer costumer;
    private Set<Item> orderItems = new HashSet<>();


    /**
     * Register order product order.
     *
     * @param items               the items
     * @param deliveringAddress   the delivering address
     * @param billingAddress      the billing address
     * @param shipment            the shipment
     * @param communicationMethod the communication method
     * @param communicationDate   the communication date
     * @param comment             the comment
     * @param payment             the payment
     * @return the product order
     */
    public ProductOrder registerOrder(Set<Item> items, Address deliveringAddress, Address billingAddress, Shipment shipment, ProductOrder.CommunicationMethod communicationMethod, Calendar communicationDate, String comment, ProductOrder.PaymentMethod payment){

        ProductOrder order = new ProductOrder(costumer, deliveringAddress, billingAddress, items, shipment, communicationMethod, communicationDate, payment, authz.session().get().authenticatedUser());
        PersistenceContext.repositories().productOrderRepository().save(order);
        return order;
    }

    /**
     * Register order product order.
     *
     * @param items               the items
     * @param deliveringAddress   the delivering address
     * @param billingAddress      the billing address
     * @param shipment            the shipment
     * @param communicationMethod the communication method
     * @param communicationDate   the communication date
     * @param payment             the payment
     * @return the product order
     */
    public ProductOrder registerOrder(Set<Item> items, Address deliveringAddress, Address billingAddress, Shipment shipment, ProductOrder.CommunicationMethod communicationMethod, Calendar communicationDate, ProductOrder.PaymentMethod payment){
        ProductOrder order = new ProductOrder(costumer, deliveringAddress, billingAddress, items, shipment, communicationMethod, communicationDate, payment, authz.session().get().authenticatedUser());
        PersistenceContext.repositories().productOrderRepository().save(order);
        return order;
    }

    /**
     * Check costumer id boolean.
     *
     * @param clientId the client id
     * @return the boolean
     */
    public boolean checkCostumerId(Long clientId) {
        Optional<Costumer> costumerF = costumerRepository.ofIdentity(clientId);
        if(costumerF.isPresent()) {
            costumer = costumerF.get();
        }
        return costumerF.isPresent();
    }

    /**
     * Check product id boolean.
     *
     * @param code the code
     * @return the boolean
     */
    public boolean checkProductId(InternalCode code) {
        Product productFound = productServices.findProductByCode(code);

        return productFound != null;
    }



}
