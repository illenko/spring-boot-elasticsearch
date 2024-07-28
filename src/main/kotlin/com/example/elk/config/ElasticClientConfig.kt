package com.example.elk.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration

@Configuration
class ElasticClientConfig : ReactiveElasticsearchConfiguration() {
    @Value("\${elasticsearch.host}")
    private lateinit var elasticsearchHost: String

    @Value("\${elasticsearch.username}")
    private lateinit var elasticsearchUsername: String

    @Value("\${elasticsearch.password}")
    private lateinit var elasticsearchPassword: String

    override fun clientConfiguration() =
        ClientConfiguration
            .builder()
            .connectedTo(elasticsearchHost)
            .withBasicAuth(elasticsearchUsername, elasticsearchPassword)
            .build()
}
