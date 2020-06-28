FROM webcenter/activemq:5.14.3
MAINTAINER solers.com
COPY target/assembly-result/opt/activemq/conf /opt/activemq/conf
EXPOSE 61617
#WORKDIR ${APP_HOME}
CMD ["/app/run.sh"]