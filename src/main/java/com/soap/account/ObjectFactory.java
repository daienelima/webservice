//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.06.29 às 03:29:41 PM BRT 
//


package com.soap.account;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.account package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.account
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountRequest }
     * 
     */
    public AccountRequest createAccountRequest() {
        return new AccountRequest();
    }

    /**
     * Create an instance of {@link AccountResponse }
     * 
     */
    public AccountResponse createAccountResponse() {
        return new AccountResponse();
    }

    /**
     * Create an instance of {@link AccountResponse.ListAccounts }
     * 
     */
    public AccountResponse.ListAccounts createAccountResponseListAccounts() {
        return new AccountResponse.ListAccounts();
    }

    /**
     * Create an instance of {@link AccountRequest.Filtro }
     * 
     */
    public AccountRequest.Filtro createAccountRequestFiltro() {
        return new AccountRequest.Filtro();
    }

    /**
     * Create an instance of {@link AccountResponse.ListAccounts.Account }
     * 
     */
    public AccountResponse.ListAccounts.Account createAccountResponseListAccountsAccount() {
        return new AccountResponse.ListAccounts.Account();
    }

}
