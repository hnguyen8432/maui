To add SSL support to ActiveMQ on port 61617  there are two approachs
1) Add a layer on top of an existing image of ActiveMQ which adds broker.ts, broker.ks and new activemq.xml with an ssl connector.
2) Add container volumes at /opt/activemq/conf/broker.ts, /opt/activemq/conf/broker.ks, /opt/activemq/conf/activemq.xml and
   mount them with actual files at run time.

Approach will pursue 1) because it is pretty straight forward for both local unit test and Kubernetes deployment