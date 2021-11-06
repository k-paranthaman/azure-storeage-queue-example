package org.example.azure.storeage.queue.config;

import com.azure.spring.integration.storage.queue.StorageQueueTemplate;
import com.azure.spring.integration.storage.queue.factory.DefaultStorageQueueClientFactory;
import com.azure.spring.integration.storage.queue.factory.StorageQueueClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class AzureStoreageQueueConfig {

    private final static String CONNECTION_STRING = "DefaultEndpointsProtocol=https;EndpointSuffix=core.windows.net;AccountName=demostoreagequeue;AccountKey=A1EIjhTkUVIKB1GFblYqeWlEPIupSE+Szq8rzTRFdpAzkL7RKkFcN4ZzkzR1IZLtLP9mT+6rKLlwVc/Yy6Ht7A==";


    @Bean
    public StorageQueueTemplate storeQureTempleBean(@NonNull StorageQueueClientFactory storageQueueClientFactory){
        return new StorageQueueTemplate(storageQueueClientFactory);
    }

    @Bean
    public StorageQueueClientFactory storeQureClientFactoryBean(){
        return new DefaultStorageQueueClientFactory(CONNECTION_STRING);
    }
}
