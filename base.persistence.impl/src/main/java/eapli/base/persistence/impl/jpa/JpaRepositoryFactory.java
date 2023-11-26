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
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.costumermanagement.repositories.CostumerRepository;
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
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CostumerRepository costumerRepository() {
        return new JpaCostumerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public ProductsCategoryRepository productsCategoryRepository(){
        return new JpaProductsCategoryRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ShoppingCartRepository shoppingCartRepository() {
        return new JpaShoppingCartRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public WarehousePlantRepository warehousePlantRepository(){
        return new JpaWarehousePlantRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AGVConfigurationRepository agvConfigurationRepository() {
        return new JpaAGVConfigurationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public QuestionnaireRepository questionnaireRepository() {
        return new JpaQuestionnaireRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ProductOrderRepository productOrderRepository() {
        return new JpaProductOrderRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ProductRepository productRepository(){
        return new JpaProductRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public AnswerRepository answerRepository(){
        return new JpaAnswerRepository(Application.settings().getPersistenceUnitName());
    }

//    @Override
//    public StatisticalReportRepository statisticalReportRepository(){
//        return new JpaStatisticalReportRepository(Application.settings().getPersistenceUnitName());
//    }

    @Override
    public StatisticalReportRepository statisticalReportRepository(){
        return new JpaStatisticalReportRepository(Application.settings().getPersistenceUnitName());
    }


}
