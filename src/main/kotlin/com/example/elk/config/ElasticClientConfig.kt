package com.example.elk.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration

@Configuration
class ElasticClientConfig : ReactiveElasticsearchConfiguration() {
    override fun clientConfiguration() =
        ClientConfiguration
            .builder()
            .connectedTo("localhost:9200")
            .withBasicAuth("elastic", "changeme")
            .build()
}
