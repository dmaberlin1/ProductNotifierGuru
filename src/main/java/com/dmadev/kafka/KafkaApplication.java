package com.dmadev.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

}


/*
./kafka-storage.sh random-uuid
с полученным id
./kafka-storage.sh format -t 4X2FIaVITN-W_Ay-zdfUFQ -c ../config/kraft/server.properties
./kafka-storage.sh format -t 4X2FIaVITN-W_Ay-zdfUFQ
 -c ../config/kraft/server2.properties
./kafka-storage.sh format -t a5DtHL57TOCEAaW0X91B6g -c ../config/kraft/server3.properties


./kafka-server-start.sh ../config/kraft/server.properties
./kafka-server-start.sh ../config/kraft/server2.properties
./kafka-server-start.sh ../config/kraft/server3.properties
*/