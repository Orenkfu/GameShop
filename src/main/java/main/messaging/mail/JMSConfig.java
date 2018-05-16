// package main.messaging.mail;
//
// import org.apache.activemq.ActiveMQConnectionFactory;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jms.connection.CachingConnectionFactory;
// import org.springframework.jms.core.JmsTemplate;
//
// import main.messaging.JMSMessagePoster;
//
// @Configuration
// public class JMSConfig {
//
// @Value("${tcp://localhost:61616}")
// private String brokerUrl;
//
// @Bean
// public ActiveMQConnectionFactory activeMQConnectionFactory() {
// ActiveMQConnectionFactory activeMQConnectionFactory = new
// ActiveMQConnectionFactory();
// activeMQConnectionFactory.setBrokerURL(brokerUrl);
//
// return activeMQConnectionFactory;
// }
//
// @Bean
// public CachingConnectionFactory cachingConnectionFactory() {
// return new CachingConnectionFactory(activeMQConnectionFactory());
// }
//
// @Bean
// public JmsTemplate jmsTemplate() {
// return new JmsTemplate(cachingConnectionFactory());
// }
//
// @Bean
// public JMSMessagePoster sender() {
// return new JMSMessagePoster();
// }
//
// }
