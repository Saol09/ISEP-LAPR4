/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.persistence;

import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.product.repository.ProductRepository;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;
import eapli.base.productsCategory.repository.ProductsCategoryRepository;
import eapli.base.questionnaires.repository.AnswerRepository;
import eapli.base.questionnaires.repository.QuestionnaireRepository;
import eapli.base.questionnaires.repository.StatisticalReportRepository;
import eapli.base.shoppingCart.repository.ShoppingCartRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * The interface Repository factory.
 *
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return transactional context
     */
    TransactionalContext newTransactionalContext();

    /**
     * Users user repository.
     *
     * @param autoTx the transactional context to enrol
     * @return user repository
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return user repository
     */
    UserRepository users();

    /**
     * Client users client user repository.
     *
     * @param autoTx the transactional context to enroll
     * @return client user repository
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return client user repository
     */
    ClientUserRepository clientUsers();

    /**
     * Signup requests signup request repository.
     *
     * @param autoTx the transactional context to enroll
     * @return signup request repository
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return signup request repository
     */
    SignupRequestRepository signupRequests();

    /**
     * Costumer repository costumer repository.
     *
     * @return the costumer repository
     */
    CostumerRepository costumerRepository();

    /**
     * Warehouse plant repository warehouse plant repository.
     *
     * @return the warehouse plant repository
     */
    WarehousePlantRepository warehousePlantRepository();

    /**
     * Products category repository products category repository.
     *
     * @return the products category repository
     */
    ProductsCategoryRepository productsCategoryRepository();

    /**
     * Shopping cart repository shopping cart repository.
     *
     * @return the shopping cart repository
     */
    ShoppingCartRepository shoppingCartRepository();

    /**
     * Product repository product repository.
     *
     * @return the product repository
     */
    ProductRepository productRepository();

    /**
     * Agv configuration repository agv configuration repository.
     *
     * @return the agv configuration repository
     */
    AGVConfigurationRepository agvConfigurationRepository();

    /**
     * Questionnaire repository questionnaire repository.
     *
     * @return the questionnaire repository
     */
    QuestionnaireRepository questionnaireRepository();


    /**
     * Answer repository.
     *
     * @return the answer repository
     */
    AnswerRepository answerRepository();

    /**
     * Statistical Report repository.
     *
     * @return the answer repository
     */
    StatisticalReportRepository statisticalReportRepository();

    /**
     * Product order repository product order repository.
     *
     * @return the product order repository
     */
    ProductOrderRepository productOrderRepository();


}
