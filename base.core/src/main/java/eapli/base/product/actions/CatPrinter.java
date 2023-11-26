package eapli.base.product.actions;

import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.visitor.Visitor;

/**
 * The type Cat printer.
 */
public class CatPrinter implements Visitor<ProductsCategory> {


    @Override
    public void visit(final ProductsCategory visitee) {
        System.out.println(visitee.toString());
    }

}