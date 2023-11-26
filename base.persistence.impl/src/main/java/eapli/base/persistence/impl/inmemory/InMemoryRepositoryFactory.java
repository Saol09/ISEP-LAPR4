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
package eapli.base.persistence.impl.inmemory;

import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
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
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public CostumerRepository costumerRepository() {
        return new InMemoryCostumerRepository();
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

    @Override
    public WarehousePlantRepository warehousePlantRepository(){return null;}

    @Override
    public ProductsCategoryRepository productsCategoryRepository() {
        return new InMemoryProductsCategoryRepository();
    }

    @Override
    public ProductRepository productRepository() {
        return null;
    }

    @Override
    public ShoppingCartRepository shoppingCartRepository(){
        return new InMemoryShoppingCartRepository();
    }

    @Override
    public QuestionnaireRepository questionnaireRepository() {
        return new InMemoryQuestionnaireRepository();
    }

    @Override
    public AnswerRepository answerRepository() {
        return new InMemoryAnswerRepository();
    }


    @Override
    public AGVConfigurationRepository agvConfigurationRepository() {
        return new InMemoryAGVConfigurationRepository();
    }

    @Override
    public StatisticalReportRepository statisticalReportRepository() {
        return new InMemoryStatisticalReportRepository();
    }

    @Override
    public ProductOrderRepository productOrderRepository() {
        return null;
    }

}
