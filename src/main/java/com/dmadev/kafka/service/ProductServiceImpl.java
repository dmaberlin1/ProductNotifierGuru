package com.dmadev.kafka.service;

import com.dmadev.kafka.service.dto.CreateProductDto;
import com.dmadev.kafka.service.event.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {


    private KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate;

    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductDto createProductDto) throws ExecutionException, InterruptedException {
        //TODO save DB
        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId,
                createProductDto.getTitle(),
                createProductDto.getPrice(),
                createProductDto.getQuantity()
        );
//       CompletableFuture<SendResult<String,ProductCreatedEvent>> future= kafkaTemplate
//               .send("product-created-events-topic",productId,productCreatedEvent);
//       future.whenComplete((result,exception)->{
//           if(exception !=null){
//        LOGGER.error("Failed to send message:{}",exception.getMessage());
//           }else{
//        LOGGER.info("Message sent successfully:{}",result.getRecordMetadata());
//           }
//       });
//        future.join();

               SendResult<String,ProductCreatedEvent> result= kafkaTemplate
               .send("product-created-events-topic",productId,productCreatedEvent).get();
       LOGGER.info("Return: {}",productId);
        return productId;
    }
}
