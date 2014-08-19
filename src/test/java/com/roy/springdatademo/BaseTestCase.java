package com.roy.springdatademo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/service-*.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
public abstract class BaseTestCase {

}
