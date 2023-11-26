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
package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.costumermanagement.domain.*;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "jane.doe@email.local");

        registerSalesClerk("salesClerk", TestDataConstants.PASSWORD1, "Ze", "Manel", "zemaneldosprodutos@gmail.com");

        registerWareHouseEmployee("wareHouseEmployee", TestDataConstants.PASSWORD1, "Seginho", "Funkeirinho",
                "serginhoOempregado@gmail.com");

        registerCustomer("customer1",TestDataConstants.PASSWORD1,"Paula", "Zeze", "freitasOprogramador@gmail.com");

        registerCustomer("pessego",TestDataConstants.PASSWORD1,"Ze","Pessego","1202016@isep.ipp.pt");

        registerAGVManager("agvManager", TestDataConstants.PASSWORD1, "Seginho", "Funkeirinho",
                "serginhoOempregado@gmail.com");

        registerSalesManager("salesManager",TestDataConstants.PASSWORD1,"Tone","Ze","funke@gmail.com");

        return true;
    }


    private void registerAdmin(final String username, final String password, final String firstName,
                               final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerSalesClerk(final String username, final String password, final String firstName,
                                    final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.SALES_CLERK);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomer(final String username, final String password, final String firstName,
                                  final String lastName, final String email){

        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CLIENT_USER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerWareHouseEmployee(final String username, final String password, final String firstName,
                                           final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.WAREHOUSE_EMPLOYEE);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerSalesManager(final String username, final String password, final String firstName,
                                           final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.SALES_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerAGVManager(final String username, final String password, final String firstName,
                                           final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.AGV_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }
}
