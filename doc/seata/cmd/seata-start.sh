BASE_DIR=`cd $(dirname $0); pwd`
sh $BASE_DIR/nacos-config.sh -h localhost -p 8848 -g SEATA_GROUP -t seata -u dev -w 123456