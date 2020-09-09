# ELK安装

## ElasticSearch

```bash
docker run -d --rm --name elasticsearch -p 9200:9200 -p 9300:9300 -v //d/Docker/ELK/Data:/usr/share/elasticsearch/data -e TZ="Asia/Shanghai" -e discovery.type=single-node docker.elastic.co/elasticsearch/elasticsearch:7.3.0
```

## Kibana

```bash
docker run -d --rm --name kibana -p 5601:5601 --link elasticsearch:elasticsearch -e TZ="Asia/Shanghai" -e ELASTICSEARCH_HOSTS=http://elasticsearch:9200 docker.elastic.co/kibana/kibana:7.3.0;
```

## Logstash

```bash
docker run -d  --rm --name logstash -p 4560:4560 -p 9600:9600 --link elasticsearch:elasticsearch \
-v //d/Docker/ELK/Conf:/etc/logstash/conf.d -v //d/Docker/ELK/Conf/logstash.yml:/usr/share/logstash/config/logstash.yml  -e TZ="Asia/Shanghai" \
docker.elastic.co/logstash/logstash:7.3.0 logstash -f /etc/logstash/conf.d/logstash.conf;
```

